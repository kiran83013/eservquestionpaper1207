package com.travel.travtronics.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.travtronics.converter.InputTypeConfigConverter;
import com.travel.travtronics.converter.MenuItemConverter;
import com.travel.travtronics.converter.ServiceTypeConveter;
import com.travel.travtronics.dto.PaginationFetchDto;
import com.travel.travtronics.dto.PaginationFetchGroupDto;
import com.travel.travtronics.dto.SanctionConfigDto;
import com.travel.travtronics.dto.ServiceTypeHeaderResponse;
import com.travel.travtronics.dto.ServiceTypeLinesFetchModel;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Departments;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.FeildLanguageLinesModel;
import com.travel.travtronics.model.FieldLanguageDepartments;
import com.travel.travtronics.model.FieldLanguageServiceTypes;
import com.travel.travtronics.model.InputTypeConfig;
import com.travel.travtronics.model.ServiceMenu;
import com.travel.travtronics.model.ServiceTypeLines;
import com.travel.travtronics.model.ServiceTypeMenuEntity;
import com.travel.travtronics.model.ServiceTypesHeader;
import com.travel.travtronics.repository.DepartmentsRepository;
import com.travel.travtronics.repository.EServiceRegisterRepository;
import com.travel.travtronics.repository.FeildLanguageLinesRepository;
import com.travel.travtronics.repository.FieldLanguageDepartmentsRepository;
import com.travel.travtronics.repository.FieldLanguageServiceTypesRepository;
import com.travel.travtronics.repository.InputTypeConfigRepository;
import com.travel.travtronics.repository.PricingLineRepository;
import com.travel.travtronics.repository.ServiceMenuRepository;
import com.travel.travtronics.repository.ServicePricingRepository;
import com.travel.travtronics.repository.ServiceTypeCustomRepository;
import com.travel.travtronics.repository.ServiceTypeMenuEntityRepository;
import com.travel.travtronics.repository.ServiceTypesLineRepository;
import com.travel.travtronics.repository.ServiceTypesRepository;
import com.travel.travtronics.repository.TaxHeaderRepository;
import com.travel.travtronics.request.FeildFormDataRequest;
import com.travel.travtronics.request.ServiceLineRequest;
import com.travel.travtronics.request.ServiceTypeHeaderRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.ConfigResponse;
import com.travel.travtronics.response.CostCenterResponse;
import com.travel.travtronics.response.FeildLineMappedResponseDto;
import com.travel.travtronics.response.FinalServiceTypesHeaderFormDataResponse;
import com.travel.travtronics.response.MenuItemsResponse;
import com.travel.travtronics.response.MenuOfServiceResponse;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.response.ProductsResponse;
import com.travel.travtronics.response.ServiceTypesHeaderResponse;

@Service
public class ServiceTypesService {

	@Autowired
	ServiceTypesRepository serviceTypeHeaderRepository;

	@Autowired
	ServiceTypesLineRepository serviceLineRepository;
	@Autowired
	InputTypeConfigRepository configRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ServiceTypeCustomRepository serviceTypeCustRepository;

	@Autowired
	DepartmentsRepository departmentsRepository;

	@Autowired
	ServiceMenuRepository ServiceMenuRepository;
	@Autowired
	FieldLanguageDepartmentsRepository feildLangDeptRepository;

	@Autowired
	FieldLanguageServiceTypesRepository feildLangSrTypeRepository;

	@Autowired
	FeildLanguageLinesRepository feildLangLinesRepository;

	@Autowired
	FieldLanguageServiceTypesRepository feildLangugaeServiceTypesRepository;

	@Autowired
	ServiceTypeMenuEntityRepository serviceTypeMenuEntityRepository;

	@Autowired
	EServiceRegisterRepository eServiceRegisterRepository;

	@Autowired
	ServicePricingRepository servicePricingRepository;

	@Autowired
	PricingLineRepository pricingLineRepository;

	@Autowired
	TaxHeaderRepository taxHeaderRepository;

	@Autowired
	ServicePricingService servicePricingService;

	public APIResponse serviceTypeHedaer(ServiceTypeHeaderRequest model) {

		ServiceTypesHeader save = serviceTypeHeaderRepository.save(ServiceTypeConveter.convertJsonToModel(model));
		logger.info("header-created");
		return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), Collections.singletonList(save));

	}

	public MessageStatusResponse modifyServiceTypeHeader(ServiceTypeHeaderRequest model, Long id) {

		Optional<ServiceTypesHeader> validatedModel = serviceTypeHeaderRepository.findById(id);

		if (validatedModel.isEmpty())
			return new MessageStatusResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
		else {
			serviceTypeHeaderRepository.save(ServiceTypeConveter.modifyJsonToModel(model, id));
			logger.info("header-modified");
			return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
		}

	}

	public APIResponse getServiceTypeHeader(Long id) {
		Optional<ServiceTypesHeader> validatedModel = serviceTypeHeaderRepository.findById(id);
		if (validatedModel.isEmpty())
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.EMPTY_LIST);
		else {
			logger.info("header-fetched-successfully");
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(validatedModel));
		}
	}

	public APIResponse getServiceHeaderTypes(String organizationId) {
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
				serviceTypeHeaderRepository.findAllByList(organizationId));
	}

	/*public APIResponse fetchPagination(String organizationId, String departmentId, String parentId, Status status,
			int pageNo, int pageSize, String sortBy, SortType sortType) {

		PaginationFetchDto dto = new PaginationFetchDto();

		if (organizationId != null && !organizationId.isEmpty())
			dto.setOrganizationId(organizationId);
		if (departmentId != null && !departmentId.isEmpty())
			dto.setDepartmentId(departmentId);
		if (parentId != null && !parentId.isEmpty())
			dto.setParentId(parentId);
		dto.setPageNo(Objects.isNull(pageNo) ? 0 : pageNo);

		int validPageSize = pageSize != 0 ? pageSize : 1;
		if (sortBy != null)
			dto.setSortBy(sortBy);
		if (status != null)
			dto.setStatus(status);
		if (sortType != null)
			dto.setSortType(sortType);

		dto.setPageSize(validPageSize);
		Pageable pageable = PageRequest.of(pageNo, validPageSize);

		Page<ServiceTypesHeader> pagingServiceHeader = serviceTypeCustRepository.fetchPaginationList(dto, pageable);

		Map<String, Object> map = new HashMap<>();

		map.put("serviceTypeHeader", pagingServiceHeader.getContent());
		map.put("currentPage", pagingServiceHeader.getNumber());
		map.put("count", pagingServiceHeader.getTotalElements());
		map.put("totalPages", pagingServiceHeader.getTotalPages());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(map));
	}*/

	public APIResponse fetchGroupsPagination(String organizationId, String departmentId, String serviceTypeGroup,
			Status status, int pageNo, int pageSize, String sortBy, SortType sortType) {
		PaginationFetchGroupDto dto = new PaginationFetchGroupDto();

		if (organizationId != null && !organizationId.isEmpty())
			dto.setOrganizationId(organizationId);
		if (departmentId != null && !departmentId.isEmpty())
			dto.setDepartmentId(departmentId);
		if (serviceTypeGroup != null && !serviceTypeGroup.isEmpty())
			dto.setServiceTypeGroup(serviceTypeGroup);
		dto.setPageNo(Objects.isNull(pageNo) ? 0 : pageNo);

		int validPageSize = pageSize != 0 ? pageSize : 1;
		if (sortBy != null)
			dto.setSortBy(sortBy);
		if (status != null)
			dto.setStatus(status);
		if (sortType != null)
			dto.setSortType(sortType);

		dto.setPageSize(validPageSize);
		Pageable pageable = PageRequest.of(pageNo, validPageSize);

		Page<ServiceTypesHeader> pagingServiceHeader = serviceTypeCustRepository.fetchPaginationGroupList(dto,
				pageable);

		Map<String, Object> map = new HashMap<>();

		map.put("serviceTypeHeader", pagingServiceHeader.getContent());
		map.put("currentPage", pagingServiceHeader.getNumber());
		map.put("count", pagingServiceHeader.getTotalElements());
		map.put("totalPages", pagingServiceHeader.getTotalPages());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(map));
	}

	public APIResponse fetchSearch(String organizationId, List<String> departmentId) {
		try {
			List<ServiceTypesHeader> results;

			if (departmentId == null) {
				// Only search by organization ID
				results = serviceTypeHeaderRepository.findByOrganizationId(organizationId);
			} else {
				// Search by both organization and department IDs
				results = serviceTypeHeaderRepository.findByOrganizationIdAndDepartmentIdIn(organizationId,
						departmentId);
			}

			// Return successful response with search results
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), results);
		} catch (Exception ex) {
			// Log exception and return error response with empty results
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getServiceTypeLinesFormData(Long headerId) {
		List<ServiceTypeLines> serviceLines = serviceLineRepository.findAllByHeaderIdAndStatus(headerId, Status.Active);
		if (!serviceLines.isEmpty()) {
			List<String> collect = serviceLines.stream().map(model -> model.getFormData()).collect(Collectors.toList());

			List<Map<String, Object>> mapList = new ArrayList<>();
			collect.forEach(model -> {

				try {
					@SuppressWarnings("unchecked")
					Map<String, Object> map = new ObjectMapper().readValue(model, Map.class);
					logger.info("convert-string-to-json");
					System.out.println(map.get("service"));

					String serviceId = map.get("service").toString();
					if (serviceId.isEmpty() == false) {
						Optional<EServiceRegister> urlInfo = eServiceRegisterRepository
								.getServiceRegisterInfoById(serviceId);
						if (urlInfo.isPresent()) {
							map.put("serviceUrl ", urlInfo.get().getServiceUrl());
							map.put("isExternalUrl ", urlInfo.get().getIsExternalUrl());
						}
					} else {
						map.put("serviceUrl ", "");
						map.put("isExternalUrl ", "No");
					}
					mapList.add(map);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), mapList);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}

	}

	public APIResponse getServiceTypeLines(Long headerId) {
		List<ServiceTypeLinesFetchModel> collect = serviceLineRepository
				.findAllByHeaderIdAndStatus(headerId, Status.Active).stream()
				.map(ServiceTypeConveter::convertServiceTypeModelToJson).peek(model -> {
					model.setConigModel(fetchInputConfigWithType(model.getField()));

				}).collect(Collectors.toList());

		if (!collect.isEmpty()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}
	}

	public APIResponse getServiceTypeLinesByIsPricing(Long headerId, Long isPricing) {
		List<ServiceTypeLinesFetchModel> collect = serviceLineRepository
				.findAllByHeaderIdAndStatusAndIsPricing(headerId, Status.Active, isPricing).stream()
				.map(ServiceTypeConveter::convertServiceTypeModelToJson).peek(model -> {
					model.setConigModel(fetchInputConfigWithType(model.getField()));

				}).collect(Collectors.toList());

		if (!collect.isEmpty()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}
	}

	public MessageStatusResponse serviceTypeLines(List<ServiceLineRequest> requestModels) {
		serviceLineRepository.saveAll(requestModels.stream().map(ServiceTypeConveter::convertLineRequestToModel)
				.collect(Collectors.toList()));
		logger.info("lines-created");
		return new MessageStatusResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
	}

	public APIResponse modifyServiceTypeLines(List<ServiceLineRequest> requestModels) {
		List<ServiceTypeLines> saveAll = serviceLineRepository.saveAll(requestModels.stream()
				.map(ServiceTypeConveter::convertLineRequestToModel).collect(Collectors.toList()));
		logger.info("lines-modified");

		List<ServiceTypeLinesFetchModel> collect = saveAll.stream()
				.map(ServiceTypeConveter::convertServiceTypeModelToJson).peek(model -> {
					model.setConigModel(fetchInputConfigWithType(model.getField()));

				}).collect(Collectors.toList());

		logger.info("lines-resposne-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
	}

	public ConfigResponse fetchInputConfigWithType(Integer configId) {
		ConfigResponse response = new ConfigResponse();
		InputTypeConfig configModel = configRepository.findByConfigId(configId != null ? configId : 0);
		response = InputTypeConfigConverter
				.convertModelToResponse(configModel != null ? configModel : new InputTypeConfig());
		String findByTypeId = configRepository.findByTypeId(response.getType() != null ? response.getType() : 0);
		response.setTypeName(findByTypeId != null ? findByTypeId : null);
		Optional<String> serviceUrl = configRepository.findByServiceUrl(response.getServiceId());
		Optional<Boolean> isExternalUrl = configRepository.findByIsExternalUrl(response.getServiceId());
		if (serviceUrl.isPresent()) {
			response.setService(serviceUrl.get());
		}
		if (isExternalUrl.isPresent()) {
			response.setIsExternalUrl(isExternalUrl.get());
		}

		return response;
	}

	public APIResponse getMenuItems(Long organizationId) {
		List<MenuItemsResponse> menuResponse = new ArrayList<>();
		List<Departments> departments = departmentsRepository.findByOrganizationIdAndStatus(organizationId,
				Status.Active);
		if (departments.size() > 0) {
			for (Departments department : departments) {
				System.out.println(department.getName());
				List<ServiceTypesHeader> serviceTypes = serviceTypeHeaderRepository
						.findByOrganizationIdAndDepartmentIdAndStatus(String.valueOf(department.getOrganizationId()),
								String.valueOf(department.getDepartmentId()), Status.Active);

				if (serviceTypes.size() > 0) {
					MenuItemsResponse menuItem = MenuItemConverter.departmentAndServiceTypesConverter(department,
							serviceTypes);
					menuResponse.add(menuItem);
				}

			}
		}
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), menuResponse);
	}

	@Deprecated
	public List<MenuItemsResponse> getMenuByOrgAndMenuType(Long organizationId, Long serviceMenuType, String langCode) {
		List<MenuItemsResponse> menuResponse = new ArrayList<>();
		List<MenuItemsResponse> menuFinalResponse = new ArrayList<>();
		List<ServiceMenu> serviceMenus = ServiceMenuRepository
				.findByServiceMenuTypeAndOrganizationAndStatus(serviceMenuType, organizationId, Status.Active);
		for (ServiceMenu menu : serviceMenus) {

			Optional<ServiceTypesHeader> serviceTypeHeader = serviceTypeHeaderRepository
					.findById(menu.getServiceTypeHeader());

			if (serviceTypeHeader.isPresent()) {

				Optional<Departments> department = departmentsRepository
						.findById(Long.parseLong(serviceTypeHeader.get().getDepartmentId()));
				MenuItemsResponse menuItemRes = new MenuItemsResponse();

				menuItemRes.setDepartmentId(department.get().getDepartmentId());
				menuItemRes.setDepartmentName(department.get().getName());

				List<MenuOfServiceResponse> services = new ArrayList<>();

				MenuOfServiceResponse serviceItem = new MenuOfServiceResponse();

				serviceItem.setServiceTypeId(serviceTypeHeader.get().getId());
				serviceItem.setServiceTypeName(serviceTypeHeader.get().getName());
				serviceItem.setServiceTypeUrl(serviceTypeHeader.get().getFormUrl());
				serviceItem.setIsServiceDynamic(serviceTypeHeader.get().getIsDynamicForm());
				serviceItem.setServiceTypeClass(serviceTypeHeader.get().getServiceClass());
				serviceItem.setIsProcess(serviceTypeHeader.get().getIsProcess());
				serviceItem.setIsParent(serviceTypeHeader.get().getIsParent());
				services.add(serviceItem);
				menuItemRes.setServices(services);
				menuResponse.add(menuItemRes);
			}
		}
		for (MenuItemsResponse menuItem : menuResponse) {
			if (menuFinalResponse.stream().anyMatch(p -> p.getDepartmentId().equals(menuItem.getDepartmentId()))) {
				menuFinalResponse = menuFinalResponse.stream().map(v -> {
					List<MenuOfServiceResponse> services = new ArrayList<>();
					services = v.getServices();
					if (v.getDepartmentId() == menuItem.getDepartmentId()) {
						for (MenuOfServiceResponse menuService : menuItem.getServices()) {
							services.add(menuService);
						}
					}
					v.setServices(services);
					return v;
				}).collect(Collectors.toList());
				continue;
			} else {
				menuFinalResponse.add(menuItem);
			}
		}

		/*
		 * integrating LangCode
		 * 
		 */

		if (langCode.equalsIgnoreCase("en")) {
			// return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
			// menuFinalResponse);
			return menuFinalResponse;
		} else {

			List<MenuItemsResponse> collectedMenuResponseInfo = menuFinalResponse.stream().map(response -> {

				Optional<FieldLanguageDepartments> feildDeptInfo = feildLangDeptRepository
						.findByOrgIdAndDepartmentIdAndLangCode(organizationId.intValue(),
								response.getDepartmentId().intValue(), langCode);
				if (feildDeptInfo.isPresent()) {

					response.setDepartmentName(feildDeptInfo.get().getName());

				}
				List<MenuOfServiceResponse> collectedMenuTypeResponse = response.getServices().stream().map(menu -> {

					Optional<FieldLanguageServiceTypes> fieldSrTypeInfo = feildLangSrTypeRepository
							.findByOrgIdAndServiceTypeIdAndLangCode(organizationId.intValue(),
									menu.getServiceTypeId().intValue(), langCode);

					if (fieldSrTypeInfo.isPresent()) {
						menu.setServiceTypeName(fieldSrTypeInfo.get().getName());
					}

					return menu;

				}).collect(Collectors.toCollection(() -> new ArrayList<>()));

				response.setServices(collectedMenuTypeResponse);

				return response;

			}).collect(Collectors.toCollection(ArrayList::new));

			// return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
			// collectedMenuResponseInfo);
			return collectedMenuResponseInfo;

		}
	}

	public APIResponse getServiceTypeHeaderByDeptId(String id) {
		List<ServiceTypesHeader> serviceHeaderByDeptId = serviceTypeHeaderRepository.getServiceHeaderByDeptId(id);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceHeaderByDeptId);
	}

	/**
	 * Get Header data and lines info by passing header Id
	 * 
	 * @param headerId
	 * @return
	 */
	public APIResponse getServiceTypeHeaderAndLinesFromDataByHeadeId(Long headerId, String langCode) {

		// Map<String, Object> response = new HashMap<String, Object>();

		FinalServiceTypesHeaderFormDataResponse response = new FinalServiceTypesHeaderFormDataResponse();

		Optional<ServiceTypeHeaderResponse> headerInfo = serviceTypeHeaderRepository.findByServiceTypeId(headerId);

		if (!headerInfo.isPresent()) {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), "No data found in the system.",
					Collections.EMPTY_LIST);
		} else {

			Optional<FieldLanguageServiceTypes> srFeildTypeInfo = feildLangSrTypeRepository
					.findByOrgIdAndServiceTypeIdAndLangCode(Integer.valueOf(headerInfo.get().getOrganizationId()),
							headerInfo.get().getId().intValue(), langCode);
			Optional<String> serviceUrl = Optional.empty();
			Optional<Boolean> isExternalUrl = Optional.empty();
			if (serviceTypeHeaderRepository != null && response.getLinesData() != null
					&& !response.getLinesData().isEmpty()) {
				String serviceData = response.getLinesData().get(0).getService();
				serviceUrl = serviceTypeHeaderRepository.findByServiceUrl(serviceData);
				isExternalUrl = serviceTypeHeaderRepository.findByIsExternalUrl(serviceData);
			}
			if (serviceUrl.isPresent()) {
				response.getLinesData().get(0).setServiceUrl(serviceUrl.get());
			}
			if (isExternalUrl.isPresent() && response.getLinesData().size() > 1) {
				response.getLinesData().get(1).setIsExternalUrl(isExternalUrl.get());
			}

			if (srFeildTypeInfo.isPresent() && !langCode.equalsIgnoreCase("en")) {
				headerInfo.get().setName(srFeildTypeInfo.get().getName());
				headerInfo.get().setInstructions(srFeildTypeInfo.get().getInstructions());
			}
			response.setHeaderInfo(headerInfo.get());
		}

		List<ServiceTypeLines> serviceLines = serviceLineRepository.findAllByHeaderIdAndStatus(headerId, Status.Active);
		if (!serviceLines.isEmpty()) {
			List<FeildFormDataRequest> collectedJsonInfo = serviceLines.stream()
					.map(model -> new FeildFormDataRequest(model.getFormData(), model.getFieldOrder()))
					.collect(Collectors.toList());

			List<FeildLineMappedResponseDto> jsonResponse = new ArrayList<>();

			collectedJsonInfo.stream().forEach(json -> {

				FeildLineMappedResponseDto mappedJson = null;
				try {
					mappedJson = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
							.readValue(json.getJson(), FeildLineMappedResponseDto.class);
					Optional<FeildLanguageLinesModel> feildLineInfo = feildLangLinesRepository
							.findByOrgIdAndLangCodeAndFieldId(mappedJson.getOrganizationId(), langCode,
									mappedJson.getConfigId());
					mappedJson.setFeildOrder(json.getJsonOrder());

					if (feildLineInfo.isPresent() && !langCode.equalsIgnoreCase("en")) {
						mappedJson.getUi().setHint(feildLineInfo.get().getHint());
						mappedJson.getUi().setInfo(feildLineInfo.get().getInfo());
						mappedJson.getUi().setPlaceholder(feildLineInfo.get().getPlaceHolder());
						mappedJson.getUi().setLabel(feildLineInfo.get().getLabel());
					}

				} catch (JsonMappingException e) {

					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				jsonResponse.add(mappedJson);
			});
			response.setLinesData(jsonResponse);
		}

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(response));
		// List<Map<String, Object>> mapList = new ArrayList<>();

//		collect.forEach(model -> {
//
//			try {
//				@SuppressWarnings("unchecked")
//				Map<String, Object> map = new ObjectMapper().readValue(model, Map.class);
//				logger.info("convert-string-to-json");
//
//				/*
//				 * getting config id from map object
//				 */
//				Object configObject = map.get("configId");
//				Integer feildId = Integer.valueOf(configObject.toString());
//				Optional<FeildLanguageLinesModel> feildLineInfo = feildLangLinesRepository
//						.findByOrgIdAndLangCodeAndFieldId(Integer.valueOf(headerInfo.get().getOrganizationId()),
//								langCode, feildId);
//
//				if (feildLineInfo.isPresent()) {
//
//				//	FeildUiResponse mappedUi = new ObjectMapper().readValue(String.valueOf(map.get("ui")),
//					//		FeildUiResponse.class);
////					mappedUi.setHint(feildLineInfo.get().getHint());
////					mappedUi.setPlaceholder(feildLineInfo.get().getPlaceHolder());
////					mappedUi.setInfo(feildLineInfo.get().getInfo());
////					mappedUi.setLabel(feildLineInfo.get().getLabel());
//					// map.put(map.get("ui").toString(), mappedUi);
//
//				}
//
//				mapList.add(map);
//			} catch (JsonMappingException e) {
//				e.printStackTrace();
//			} catch (JsonProcessingException e) {
//				e.printStackTrace();
//			}
//
//		});
//		if (response.size() == 0) {
//			return new APIResponse(HttpStatus.NOT_FOUND.value(), "No data found in the system.",
//					Collections.EMPTY_LIST);
//		} else {
//			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(response));
//		}
	}

	public APIResponse serviceTypeHeaderRelation(String organizationId, String departmentId, Boolean isParent) {
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
				serviceTypeHeaderRepository.findByHeaderRelation(organizationId, departmentId, isParent));
	}

	public APIResponse getServiceTypeHeaderLocalization(Long id, String langCode) {
		Optional<ServiceTypesHeader> validatedModel = serviceTypeHeaderRepository.findById(id);
		if (validatedModel.isEmpty())
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.EMPTY_LIST);
		else {
			logger.info("header-fetched-successfully");

			if (!langCode.equalsIgnoreCase("en")) {
				Optional<FieldLanguageServiceTypes> srTypeHeader = feildLangugaeServiceTypesRepository
						.findByOrgIdAndServiceTypeIdAndLangCode(
								Integer.valueOf(validatedModel.get().getOrganizationId()), id.intValue(), langCode);

				validatedModel.get().setName(
						srTypeHeader.isPresent() ? srTypeHeader.get().getName() : validatedModel.get().getName());
				validatedModel.get().setInstructions(srTypeHeader.isPresent() ? srTypeHeader.get().getInstructions()
						: validatedModel.get().getInstructions());
			}

			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(validatedModel));
		}
	}

	public APIResponse getServiceTypesForMenu(String organizationId) {
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
				serviceTypeHeaderRepository.getServiceTypeForMenu(organizationId));
	}

	public APIResponse getServiceTypeHeaderAndLinesFromDataByHeadeIdLead() {

		List<ServiceTypesHeader> srTypeClassInfo = serviceTypeHeaderRepository.findByServiceTypeIconClass();

		if (CollectionUtils.isEmpty(srTypeClassInfo)) {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), " lead  service information was not  found");
		} else if (srTypeClassInfo.size() > 1) {
			return new APIResponse(HttpStatus.CONFLICT.value(), "lead has more than one service information");
		} else {
			List<FinalServiceTypesHeaderFormDataResponse> responseInfo = new ArrayList<>();
			srTypeClassInfo.stream().forEach(t -> {

				FinalServiceTypesHeaderFormDataResponse e = getServiceTypeHeaderAndLinesFromDataByHeadeId(t.getId(),
						"en").getData().stream().filter(FinalServiceTypesHeaderFormDataResponse.class::isInstance)
								.map(FinalServiceTypesHeaderFormDataResponse.class::cast).findFirst().get();
				responseInfo.add(e);
			});
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), responseInfo);
		}
	}

	public List<MenuItemsResponse> getMenuByOrgAndMenuTypeInfo(Long organizationId, Long serviceMenuType,
			String langCode) {

		List<ServiceTypeMenuEntity> srTypeMenuInfo = serviceTypeMenuEntityRepository
				.findByServiceMenuTypeAndOrganization(serviceMenuType, organizationId);

		// group serviceTypes by deptInfo

		Map<String, List<MenuOfServiceResponse>> collectedMenuResponse = srTypeMenuInfo.stream()
				.collect(Collectors.groupingBy(sr -> sr.getDepartmentId() + "-" + sr.getDepartmentName(),

						Collectors.mapping(ServiceTypeConveter::convertServiceMenuEntityToDto,

								Collectors.toList())));
		List<MenuItemsResponse> menuFinalResponse = ServiceTypeConveter
				.convertGroupDeptSrTypesToJson(collectedMenuResponse);

		/*
		 * integrating LangCode
		 * 
		 */

		if (langCode.equalsIgnoreCase("en")) {
			return menuFinalResponse;
		} else {
			List<MenuItemsResponse> collectedMenuResponseInfo = menuFinalResponse.stream().map(response -> {

				Optional<FieldLanguageDepartments> feildDeptInfo = feildLangDeptRepository
						.findByOrgIdAndDepartmentIdAndLangCode(organizationId.intValue(),
								response.getDepartmentId().intValue(), langCode);
				if (feildDeptInfo.isPresent()) {

					response.setDepartmentName(feildDeptInfo.get().getName());

				}
				List<MenuOfServiceResponse> collectedMenuTypeResponse = response.getServices().stream().map(menu -> {

					Optional<FieldLanguageServiceTypes> fieldSrTypeInfo = feildLangSrTypeRepository
							.findByOrgIdAndServiceTypeIdAndLangCode(organizationId.intValue(),
									menu.getServiceTypeId().intValue(), langCode);

					if (fieldSrTypeInfo.isPresent()) {
						menu.setServiceTypeName(fieldSrTypeInfo.get().getName());
					}

					return menu;

				}).collect(Collectors.toCollection(() -> new ArrayList<>()));

				response.setServices(collectedMenuTypeResponse);

				return response;

			}).collect(Collectors.toCollection(ArrayList::new));

			return collectedMenuResponseInfo;
		}

	}

	public Map<String, Object> getMenuByOrgAndMenuType(Long organizationId, Long serviceMenuTypeId, String langCode,
			Integer bizId) {

		Boolean isOffline = false;
		Boolean isOnline = false;

		String userType = getUserTypeFromAuthToken();

		if (!userType.isBlank()) {

			if (userType.equals("feUser"))
				isOnline = true;
			if (userType.equals("beUser"))
				isOffline = true;
		}

		System.out.println("isOnline - " + isOnline + "isOffline - " + isOffline);

		List<SanctionConfigDto> sanctionsInfo = serviceTypeMenuEntityRepository.findAllSanctions(bizId, organizationId,
				isOnline, isOffline);
		/*
		 * predicate to check sanctions
		 */

		Predicate<SanctionConfigDto> sanctionPredicate = p -> p.getSanctionTypeName().equalsIgnoreCase("Sanction");

		List<MenuItemsResponse> menuByOrgAndMenuTypeInfo = new ArrayList<>();
		if (sanctionsInfo.isEmpty() || sanctionsInfo.stream().noneMatch(sanctionPredicate)) {
			menuByOrgAndMenuTypeInfo = getMenuByOrgAndMenuTypeInfo(organizationId, serviceMenuTypeId, langCode);
			// System.out.println("came if");
		} else {

			/** filter srTypes with sanction type Sanction ***/

			Set<Long> collectedSanctionSrTypes = sanctionsInfo.stream()
					.collect(Collectors.filtering(sanctionPredicate, Collectors.mapping(SanctionConfigDto::getSrTypeId,
							Collectors.collectingAndThen(Collectors.toSet(), innerList -> innerList.stream().map(i -> {
								String[] splitSr = i.split(",");

								Set<Long> collectedSrInfo = Arrays.asList(splitSr).stream().map(Long::valueOf)
										.collect(Collectors.toSet());
								return collectedSrInfo;
							}).flatMap(Set::stream).collect(Collectors.toSet())))));
			// .get(true);
			// collectedSanctionSrTypes.forEach(System.out::println);

			List<MenuItemsResponse> menuResponse = getMenuByOrgAndMenuTypeInfo(organizationId, serviceMenuTypeId,
					langCode);

			menuResponse.stream().forEach(menu -> {

				List<MenuOfServiceResponse> srEliminatedArray = menu.getServices();

				/*
				 * eliminate sanction srTypes if which are not available
				 */
				srEliminatedArray.removeIf(m -> !collectedSanctionSrTypes.contains(m.getServiceTypeId()));

				menu.setServices(srEliminatedArray);
			});

			menuByOrgAndMenuTypeInfo.addAll(menuResponse.stream()
					.collect(Collectors.filtering(mr -> !mr.getServices().isEmpty(), Collectors.toList())));

			System.out.println("came else");
		}

		Map<String, Object> responseInfo = new LinkedHashMap<>();
		responseInfo.put("message", "OK");

		responseInfo.put("status", 200);
		responseInfo.put("data", menuByOrgAndMenuTypeInfo);
		responseInfo.put("errors", Collections.emptyList());
		responseInfo.put("sanctions", sanctionsInfo);
		return responseInfo;
	}

	public String getUserTypeFromAuthToken() {

		String userType = "";

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null && authentication.getPrincipal() instanceof KeycloakPrincipal) {
			@SuppressWarnings("unchecked")
			KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) authentication
					.getPrincipal();
			// userName = kp.getKeycloakSecurityContext().getToken().getName();
			Map<String, Object> otherClaims = kp.getKeycloakSecurityContext().getToken().getOtherClaims();

			if (otherClaims.containsKey("userType")) {

				userType = StringUtils.substringBetween(String.valueOf(otherClaims.get("userType")), "[", "]");
			}
		}

		// logger.info("------------" + userType + "----------------------------");
		return userType;

	}

	public APIResponse getProducts() {
		List<Map<String, Object>> productList = serviceTypeHeaderRepository.findAllProducts();
		List<ProductsResponse> responseList = new ArrayList<>();

		if (!productList.isEmpty()) {
			for (Map<String, Object> product : productList) {
				Long serviceHeaderId = ((BigInteger) product.get("id")).longValue(); // Get the service header ID
				Integer pricingType = 3; // Replace with the actual pricing type

				APIResponse priceResponse = servicePricingService.getSrPriceRangeInfo(serviceHeaderId, pricingType);
				List<Map<String, Object>> priceDataList = (List<Map<String, Object>>) priceResponse.getData();

				ProductsResponse response = new ProductsResponse();
				response.setId(serviceHeaderId);
				response.setName((String) product.get("name"));
				response.setDescription((String) product.get("description"));

				Object urlObj = product.get("urls");
				if (urlObj != null && !urlObj.toString().isEmpty()) {
					String[] strArray = urlObj.toString().split(",");
					List<String> urlsList = Arrays.asList(strArray);
					response.setUrl(urlsList);
				}

				if (!priceDataList.isEmpty()) {
					Map<String, Object> priceData = priceDataList.get(0);
					Double minPrice = (Double) priceData.get("minprice");
					Double maxPrice = (Double) priceData.get("maxprice");
					response.setMinprice(minPrice);
					response.setMaxprice(maxPrice);
				} else {
					// Set default values if no price data is available
					response.setMinprice(0.0);
					response.setMaxprice(0.0);
				}

				responseList.add(response);
			}

			return new APIResponse(HttpStatus.OK.value(), "Success", responseList);

		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), "No data found in the system.",
					Collections.emptyList());
		}
	}

	public APIResponse getProductsByOrgId(Long organizationId) {
		List<Map<String, Object>> productList = serviceTypeHeaderRepository.findByOrgId(organizationId);
		List<ProductsResponse> responseList = new ArrayList<>();

		if (!productList.isEmpty()) {
			for (Map<String, Object> product : productList) {
				Long serviceHeaderId = ((BigInteger) product.get("id")).longValue(); // Get the service header ID
				Integer pricingType = 3; // Replace with the actual pricing type

				APIResponse priceResponse = servicePricingService.getSrPriceRangeInfo(serviceHeaderId, pricingType);
				List<Map<String, Object>> priceDataList = (List<Map<String, Object>>) priceResponse.getData();

				ProductsResponse response = new ProductsResponse();
				response.setId(serviceHeaderId);
				response.setName((String) product.get("name"));
				response.setDescription((String) product.get("description"));
				response.setOrganizationName((String) product.get("organizationName"));
				response.setServiceTypeId(((BigInteger) product.get("serviceTypeId")).longValue());
				response.setServiceTypeName((String) product.get("serviceTypeName"));
				response.setServiceTypeCode((String) product.get("serviceTypeCode"));

				Object urlObj = product.get("urls");
				if (urlObj != null && !urlObj.toString().isEmpty()) {
					String[] strArray = urlObj.toString().split(",");
					List<String> urlsList = Arrays.asList(strArray);
					response.setUrl(urlsList);
				}

				if (!priceDataList.isEmpty()) {
					Map<String, Object> priceData = priceDataList.get(0);
					Double minPrice = (Double) priceData.get("minprice");
					Double maxPrice = (Double) priceData.get("maxprice");
					response.setMinprice(minPrice);
					response.setMaxprice(maxPrice);
				} else {
					// Set default values if no price data is available
					response.setMinprice(0.0);
					response.setMaxprice(0.0);
				}

				responseList.add(response);
			}

			return new APIResponse(HttpStatus.OK.value(), "Success", responseList);

		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), "No data found in the system.",
					Collections.emptyList());
		}
	}

	public APIResponse fetchPagination(String organizationId, String departmentId, String parentId, Status status,
			Long serviceClass, Long serviceCategory, Long serviceType, Boolean isProcess, Boolean isStage,
			Boolean isPricing, Long isDynamicForm, String name, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		PaginationFetchDto dto = new PaginationFetchDto();

		if (organizationId != null && !organizationId.isEmpty())
			dto.setOrganizationId(organizationId);
		if (departmentId != null && !departmentId.isEmpty())
			dto.setDepartmentId(departmentId);
		if (parentId != null && !parentId.isEmpty())
			dto.setParentId(parentId);
		if (serviceClass != null)
			dto.setServiceClass(serviceClass);
		if (serviceCategory != null)
			dto.setServiceCategory(serviceCategory);
		if (serviceType != null)
			dto.setServiceType(serviceType);
		if (isProcess != null && isProcess)
			dto.setIsProcess(isProcess);
		if(isStage != null && isStage)
			dto.setIsStage(isStage);
		if(isPricing != null && isPricing)
			dto.setIsPricing(isPricing);
		if (isDynamicForm != null)
			dto.setIsDynamicForm(isDynamicForm);
		if (name != null && !name.isEmpty())
			dto.setName(name);
			
		dto.setPageNo(Objects.isNull(pageNo) ? 0 : pageNo);

		int validPageSize = pageSize != 0 ? pageSize : 1;
		if (sortBy != null)
			dto.setSortBy(sortBy);
		if (status != null)
			dto.setStatus(status);
		if (sortType != null)
			dto.setSortType(sortType);

		dto.setPageSize(validPageSize);
		Pageable pageable = PageRequest.of(pageNo, validPageSize);

		Page<ServiceTypesHeader> pagingServiceHeader = serviceTypeCustRepository.fetchPaginationList(dto, pageable);

		Page<ServiceTypesHeaderResponse> item = pagingServiceHeader.map(model -> {
			
			ServiceTypesHeaderResponse response = ServiceTypeConveter.convertModelTOResponse(model);
			Optional<String> dept = serviceTypeHeaderRepository.getDepartmentName(response.getDepartmentId());
			Optional<String> className = serviceTypeHeaderRepository.getClassName(response.getServiceClass());
			Optional<String> typeName = serviceTypeHeaderRepository.getTypeName(response.getServiceType());
			
			if(dept.isPresent())
				response.setDepartmentName(dept.get());
			
			if(className.isPresent())
				response.setClassName(className.get());
			
			if(typeName.isPresent())
				response.setTypeName(typeName.get());
			
			return response;
		});
		Map<String, Object> map = new HashMap<>();

//		map.put("serviceTypeHeader", pagingServiceHeader.getContent());
		map.put("currentPage", pagingServiceHeader.getNumber());
		map.put("count", pagingServiceHeader.getTotalElements());
		map.put("totalPages", pagingServiceHeader.getTotalPages());
		map.put("serviceTypeHeader", item.getContent());

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(map));
	}


}
