package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.InputTypeConfigConverter;
import com.travel.travtronics.converter.PricingConverter;
import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.dto.PricingLinesFetchModel;
import com.travel.travtronics.dto.TaxTemplateDto;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.InputTypeConfig;
import com.travel.travtronics.model.Item;
import com.travel.travtronics.model.PricingHeader;
import com.travel.travtronics.model.PricingLines;
import com.travel.travtronics.model.ServicePricing;
import com.travel.travtronics.repository.InputTypeConfigRepository;
import com.travel.travtronics.repository.ItemRepository;
import com.travel.travtronics.repository.PricingHeaderRepository;
import com.travel.travtronics.repository.PricingLineRepository;
import com.travel.travtronics.repository.ServicePricingRepository;
import com.travel.travtronics.repository.TaxHeaderRepository;
import com.travel.travtronics.request.PricingRequestModel;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.ChargablePricingResponse;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.response.PricingHeaderResponse;
import com.travel.travtronics.response.PricingLineConfigResponse;
import com.travel.travtronics.response.PricingLinesResponse;

@Service
public class PricingService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PricingHeaderRepository headerRepositroy;

	@Autowired
	PricingLineRepository lineRepository;

	@Autowired
	InputTypeConfigRepository configRepository;

	@Autowired
	ServicePricingRepository servicePricingRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	TaxHeaderRepository taxHeaderRepository;

	@Autowired
	EServiceRegisterCustomRepository esCustomRepository;

	public MessageStatusResponse createPrice(PricingRequestModel model) {

		PricingHeader save = headerRepositroy.save(PricingConverter.convertJsonToModel(model.getPricingHeader()));

		logger.info("--header saved to db--");

		lineRepository
				.saveAll(PricingConverter.convertListLineJsonToListModels(model.getPricingLines().stream().map(temp -> {

					temp.setHeaderId(save.getId());
					logger.info("--headerId saved in lines--");
					return temp;
				}).collect(Collectors.toList())));

		logger.info("--salary lines saved--");

		return new MessageStatusResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
	}

	public MessageStatusResponse modifyPrice(PricingRequestModel model, Long id) {

		Optional<PricingHeader> findById = headerRepositroy.findById(id);
		if (!findById.isPresent()) {
			return new MessageStatusResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
		} else {
			PricingHeader save = headerRepositroy
					.save(PricingConverter.updateJsonToModel(model.getPricingHeader(), id));

			logger.info("--header saved to db--");

			lineRepository.saveAll(
					PricingConverter.convertListLineJsonToListModels(model.getPricingLines().stream().map(temp -> {

						temp.setHeaderId(save.getId());
						logger.info("--headerId saved in lines--");
						return temp;
					}).collect(Collectors.toList())));

			logger.info("--salary lines saved--");

			return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
		}

	}

	public APIResponse getPriceHeaderListByOrganization(Long organization) {

		List<PricingHeaderResponse> collect = PricingConverter
				.convertListModelToListJson(headerRepositroy.findAllByOrganization(organization)).stream()
				.map(model -> {

//                    PricingJoinDto salaryNames = headerRepositroy.getSalaryNames(model.getId());
//                    model.setBusinessUnitName(salaryNames.getBusinessUnitName());
//                    model.setOrganizationName(salaryNames.getOrganizationName());
//                    model.setDepartmentName(salaryNames.getDepartmentName());
					return model;

				}).collect(Collectors.toList());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
	}

	public APIResponse getPriceHeader(Long id) {
		Optional<PricingHeader> findById = headerRepositroy.findById(id);
		if (!findById.isPresent()) {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(PricingConverter.convertModelToJson(findById.get())));
		}
	}

	/*
	 * public APIResponse getSalaryLinesByHeader(Long id) { List<PricingLines> lines
	 * = lineRepository.findAllByHeaderIdAndStatus(id, Status.Active); if
	 * (lines.isEmpty()) { return new APIResponse(HttpStatus.NOT_FOUND.value(),
	 * HttpStatus.NOT_FOUND.name(), Collections.emptyList()); } else { return new
	 * APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
	 * PricingConverter.convertLineModelsToLineJsons(lines)); }
	 * 
	 * }
	 */

	public APIResponse getPriceLinesByHeader(Long headerId) {
//    	List<PricingLinesFetchModel> collect = lineRepository.findAllByHeaderIdAndStatus(headerId, Status.Active)
//				.stream().map(PricingConverter::convertPricingLinesTypeModelToJson).peek(model -> {
//					//model.setConfigModel(fetchInputConfigWithType(model.getField()));
//					InputTypeConfig model=model.getField()!=null ? fetchInputConfigWithType(model.getField())  : null;
//				}).collect(Collectors.toList());

		List<PricingLines> collect = lineRepository.findAllByHeaderIdAndStatus(headerId, Status.Active);
		List<PricingLinesFetchModel> responseModel = PricingConverter.convertPricingLinesTypeModelToJson(collect)
				.stream().map(model -> {

					if (model.getField() != null && model.getField() != 0) {
						logger.info(model.getField().toString());
						model.setConfigModel(fetchInputConfigWithType(model.getField()));
					}
					return model;

				}).collect(Collectors.toList());

		if (!responseModel.isEmpty()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), responseModel);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}
	}

	private PricingLineConfigResponse fetchInputConfigWithType(Integer configId) {

		PricingLineConfigResponse response = new PricingLineConfigResponse();

		InputTypeConfig configModel = configRepository.findByConfigId(configId != null ? configId : 0);

		response = InputTypeConfigConverter
				.convertModelToPricingLinesResponse(configModel != null ? configModel : null);

		String findByTypeId = configRepository.findByTypeId(response.getType() != null ? response.getType() : 0);

		response.setTypeName(findByTypeId != null ? findByTypeId : null);

		return response;
	}

	public APIResponse getChargablePriceLinesBySrTypeId(Long srHeaderId) {

		if (srHeaderId <= 0) {
			return new APIResponse(HttpStatus.BAD_REQUEST.value(), "srHeaderId is should not be empty or Zero.",
					new ArrayList<>());
		}

		List<ServicePricing> headersList = servicePricingRepository.findByHeaderIdAndStatus(srHeaderId, Status.Active);

		if (headersList.size() == 0) {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), "Not found any data in the system.",
					new ArrayList<>());
		}

		List<PricingLinesResponse> responseList = new ArrayList<PricingLinesResponse>();

		if (headersList.size() > 0) {

			for (ServicePricing headerLine : headersList) {

				List<PricingLines> collectList = lineRepository
						.getCharablePriceLinesByHeaderId(headerLine.getPriceList());

				responseList = PricingConverter.convertChargablePricingLinesTypeModelToJson(collectList).stream()
						.map(model -> {

							if (model.getField() != null && model.getField() != 0) {
								model.setConfigModel(fetchInputConfigWithType(model.getField()));
							}

							int taxCatId = 0;
							Optional<Item> itemInfo = itemRepository.getItemInfoById(model.getItem());
							if (itemInfo != null && itemInfo.isPresent()) {
								taxCatId = Math.toIntExact(itemInfo.get().getTaxCategory());
								model.setItemName(itemInfo.get().getName());
							} else {
								model.setItemName("");
							}
							System.out.println(taxCatId);
							// Get Tax lines by tax header id
							List<TaxTemplateDto> taxLines = taxHeaderRepository.getTaxLinesInfoByTaxCategory(taxCatId,
									model.getOrganizationId().intValue());

							double itemPrice = Double.valueOf(model.getCharge());

							ChargablePricingResponse priceData = PricingConverter
									.convertPriceListDataToChargablePriceResponse(model.getId(), itemPrice, taxLines);

							model.setPriceInfo(priceData);

							return model;

						}).collect(Collectors.toList());
			}

		}

		if (responseList != null && responseList.size() > 0) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), responseList);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}
	}

	public APIResponsePaging getPagenationByOrganization(Long organization, String name, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<PricingHeader> menuData = esCustomRepository.fetchPricingPagination(name, organization, pageable, sortBy,
				sortType);
//		if (organization != null ) {
//			Page<PricingHeader> menuData = headerRepositroy.findByOrganization(organization, pageable);
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
				new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
//		} else {
//			Page<PricingHeader> esRegister = headerRepositroy.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
//					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
//					esRegister.getTotalPages());
//		}
	}

	public APIResponse getItemsByPricingLinesByHeaderId(Long headerId, Long organizationId) {
		List<Map<String,String>> list = lineRepository.findByHeaderIdAndOrganizationsId(headerId,organizationId);
	if(!list.isEmpty()) {
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),list);

		}
		else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), "No data found in the system with the provided header id and Organization id",
	                Collections.emptyList());
		}
	}
}
