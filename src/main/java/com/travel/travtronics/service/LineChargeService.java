package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.LineChargesConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.LineCharges;
import com.travel.travtronics.repository.LineChargesRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.LineChargesResponse;

@Service
public class LineChargeService {

	@Autowired
	LineChargesRepository lineChargesRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse createCharges(List<LineCharges> line) {
		try {
			List<LineCharges> list = new ArrayList<>();
			List<LineCharges> save = lineChargesRepository.saveAll(line);
			list.addAll(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		try {
			Optional<LineCharges> opt = lineChargesRepository.findById(id);
			List<LineCharges> list = new ArrayList<>();
			if (opt.isPresent()) {
				list.add(opt.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

//	public APIResponse editLineCharge(List<LineChargesRequest> line) {
//		List<LineCharges> list = lineChargesRepository.saveAll(
//				line.stream().map(LineChargesConverter::convertLineChargesToModel).collect(Collectors.toList()));
//		logger.info("fieldlines-modified");
//		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
//	}

	public APIResponse getAll(Long organizationId) {
		try {
			List<Map<String, String>> list = lineChargesRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<LineCharges> findByOrganizationId = lineChargesRepository.findByOrganizationId(organizationId,pageable);
			Page<LineChargesResponse> item = findByOrganizationId.map(model -> {
				LineChargesResponse response = LineChargesConverter.convertLineChargesToResponse(model);
				Optional<String> orgName = lineChargesRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = lineChargesRepository.getItemName(response.getItem());
				Optional<String> agreement = lineChargesRepository.getAgreementName(response.getAgreementId());
				Optional<String> agreementLine = lineChargesRepository.getAgreementLineName(response.getAgreementLineId());
				if (orgName.isPresent())
					response.setOrganizationName(orgName.get());
				if (itemName.isPresent())
					response.setItemName(itemName.get());
				if (agreement.isPresent())
					response.setAgreementName(agreement.get());
				if (agreementLine.isPresent())
					response.setAgreementLineName(agreementLine.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<LineCharges> findByOrganizationId = lineChargesRepository.findAll(pageable);
			Page<LineChargesResponse> item = findByOrganizationId.map(model -> {
				LineChargesResponse response = LineChargesConverter.convertLineChargesToResponse(model);
				Optional<String> orgName = lineChargesRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = lineChargesRepository.getItemName(response.getItem());
				Optional<String> agreement = lineChargesRepository.getAgreementName(response.getAgreementId());
				Optional<String> agreementLine = lineChargesRepository
						.getAgreementLineName(response.getAgreementLineId());
				if (orgName.isPresent())
					response.setOrganizationName(orgName.get());
				if (itemName.isPresent())
					response.setItemName(itemName.get());
				if (agreement.isPresent())
					response.setAgreementName(agreement.get());
				if (agreementLine.isPresent())
					response.setAgreementLineName(agreementLine.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}

	public APIResponse getAllByAgreementId(Long agreementId) {
		try {
			List<Map<String, String>> list = lineChargesRepository.findByAgreementId(agreementId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getAllByAgreementLineId(Long agreementLineId) {
		try {
			List<Map<String, String>> list = lineChargesRepository.findByAgreementLineId(agreementLineId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse saveAndEdit(List<LineCharges> line) {
		try {
			List<LineCharges> save = lineChargesRepository.saveAll(line);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), save);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}
}
