package com.travel.travtronics.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.request.ServiceLineRequest;
import com.travel.travtronics.request.ServiceTypeHeaderRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.service.ServiceTypesService;

@RestController
public class ServiceTypesController {

	@Autowired
	ServiceTypesService serviceTypeService;

	/**
	 * Get Header data and lines info by passing header Id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/service-type-header-lines-form-data/{id}/{langCode}")
	public APIResponse getServiceTypeHeaderAndLinesFromData(@PathVariable Long id, @PathVariable String langCode) {
		return serviceTypeService.getServiceTypeHeaderAndLinesFromDataByHeadeId(id, langCode);
	}

	@GetMapping(path = "lead/service-type-header-lines-form-data")
	public APIResponse getServiceTypeHeaderAndLinesFromDataLead() {
		return serviceTypeService.getServiceTypeHeaderAndLinesFromDataByHeadeIdLead();
	}

	// ===================================================================================================

	@PostMapping(path = "/service-type-header")
	public APIResponse serviceTypeHeader(@RequestBody ServiceTypeHeaderRequest model) {
		return serviceTypeService.serviceTypeHedaer(model);
	}

	@PutMapping(path = "modify/service-type-header/{id}")
	public MessageStatusResponse modifyServiceTypeHeader(@RequestBody ServiceTypeHeaderRequest model,
			@PathVariable Long id) {
		return serviceTypeService.modifyServiceTypeHeader(model, id);
	}

	@GetMapping(path = "/service-type-header/{id}")
	public APIResponse getServiceTypeHeader(@PathVariable Long id) {
		return serviceTypeService.getServiceTypeHeader(id);
	}

	@GetMapping(path = "/service-type-header-localization")
	public APIResponse getServiceTypeHeaderLocalization(@RequestParam Long id, @RequestParam String langCode) {
		return serviceTypeService.getServiceTypeHeaderLocalization(id, langCode);
	}

	@GetMapping(path = "/get-service-type-header-by-dept-id/{id}")
	public APIResponse getServiceTypeHeaderByDeptId(@PathVariable String id) {
		return serviceTypeService.getServiceTypeHeaderByDeptId(id);
	}

	@GetMapping(path = "/service-type-headers")
	public APIResponse getServiceHeaderTypes(@RequestParam String organizationId) {
		return serviceTypeService.getServiceHeaderTypes(organizationId);
	}

	/*@GetMapping(path = "/service-type-header-pagination", produces = "application/json")
	public APIResponse fetchPagination(@RequestParam(required = false) String organizationId,
			@RequestParam(required = false) String departmentId, @RequestParam(required = false) String parentId,
			@RequestParam(required = false) Status status, @RequestParam int pageNo, @RequestParam int pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(required = false) SortType sortType) {
		return serviceTypeService.fetchPagination(organizationId, departmentId, parentId, status, pageNo, pageSize,
				sortBy, sortType);
	}*/
	
	@GetMapping(path = "/service-type-header-pagination", produces = "application/json")
	public APIResponse fetchPagination(@RequestParam(required = false) String organizationId,
			@RequestParam(required = false) String departmentId, @RequestParam(required = false) String parentId,
			@RequestParam(required = false) Status status, @RequestParam(required = false)  Long serviceClass,
			@RequestParam(required = false)  Long serviceCategory, @RequestParam(required = false)  Long serviceType,
			@RequestParam(required = false)  Boolean isProcess, @RequestParam(required = false)  Boolean isStage,
			@RequestParam(required = false)  Boolean isPricing,@RequestParam(required = false)  Long isDynamicForm,
			@RequestParam(required = false) String name,@RequestParam int pageNo, @RequestParam int pageSize,
			@RequestParam(defaultValue = "id") String sortBy, @RequestParam(required = false) SortType sortType) {
		return serviceTypeService.fetchPagination(organizationId, departmentId, parentId, status, serviceClass, serviceCategory, 
				serviceType, isProcess, isStage, isPricing, isDynamicForm, name, pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping(path = "/service-type-groups-pagination", produces = "application/json")
	public APIResponse fetchGroupsPagination(@RequestParam String organizationId,
			@RequestParam(required = false) String departmentId,
			@RequestParam(required = false) String serviceTypeGroup, @RequestParam(required = false) Status status,
			@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(required = false) SortType sortType) {
		return serviceTypeService.fetchGroupsPagination(organizationId, departmentId, serviceTypeGroup, status, pageNo,
				pageSize, sortBy, sortType);
	}

	@GetMapping(path = "/search-service-types", produces = "application/json")
	public APIResponse fetchSearch(@RequestParam String organizationId,
			@RequestParam(required = false) List<String> departmentId) {
		return serviceTypeService.fetchSearch(organizationId, departmentId);
	}

	@GetMapping(path = "/service-type-parent-relation", produces = "application/json")
	public APIResponse serviceTypeHeaderRelation(@RequestParam String organizationId, @RequestParam String departmentId,
			@RequestParam Boolean isParent) {
		return serviceTypeService.serviceTypeHeaderRelation(organizationId, departmentId, isParent);
	}
//===============================================
	/*
	 * service-type-line-apis
	 */

	@GetMapping(path = "/service-type-lines-form-data/{headerId}")
	public APIResponse getServiceTypeLineFormData(@PathVariable Long headerId) {
		return serviceTypeService.getServiceTypeLinesFormData(headerId);
	}

	@GetMapping(path = "/service-type-lines/{headerId}")
	public APIResponse getServiceTypeLine(@PathVariable Long headerId,
			@RequestParam(name = "isPricing", required = false) Long isPricing) {

		// return serviceTypeService.getServiceTypeLines(headerId);
		return isPricing != null ? serviceTypeService.getServiceTypeLinesByIsPricing(headerId, isPricing)
				: serviceTypeService.getServiceTypeLines(headerId);
	}

	@PostMapping(path = "/service-type-lines")
	public MessageStatusResponse serviceTypeLines(@RequestBody List<ServiceLineRequest> requestModels) {
		return serviceTypeService.serviceTypeLines(requestModels);
	}

	@PutMapping(path = "modify/service-type-lines")
	public APIResponse modifyServiceTypeLines(@RequestBody List<ServiceLineRequest> requestModels) {
		return serviceTypeService.modifyServiceTypeLines(requestModels);
	}

	@GetMapping(path = "/get-menu-items/{organizationId}")
	public APIResponse getMenuItems(@PathVariable Long organizationId) {
		return serviceTypeService.getMenuItems(organizationId);
	}

	@GetMapping(path = "/get-menu/{organizationId}/{serviceMenuTypeId}/{langCode}/{bizId}")
	public Map<String, Object> getMenuBasedOnMenuType(@PathVariable Long organizationId,
			@PathVariable Long serviceMenuTypeId, @PathVariable String langCode, @PathVariable Integer bizId) {
		return serviceTypeService.getMenuByOrgAndMenuType(organizationId, serviceMenuTypeId, langCode, bizId);
	}

	@GetMapping(path = "/get-service-types-for-menu")
	public APIResponse getServiceTypesForMenu(@RequestParam String organizationId) {
		return serviceTypeService.getServiceTypesForMenu(organizationId);
	}
	
	@GetMapping(path = "/all-service-products")
	public APIResponse getProducts() {
		return serviceTypeService.getProducts();
	}
	
	@GetMapping(path = "/all-service-products-by-orgId")
	public APIResponse getProductsByOrgId(@RequestParam Long organizationId) {
		return serviceTypeService.getProductsByOrgId(organizationId);
	}
}
