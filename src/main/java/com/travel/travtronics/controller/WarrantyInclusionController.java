package com.travel.travtronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.WarrantyInclusion;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.WarrantyInclusionService;

@RestController
@RequestMapping("/warranty_inclusion")
public class WarrantyInclusionController {

	@Autowired
	WarrantyInclusionService warrantyInclusionService;

	@PostMapping(value = "/create-warranty-inclusion", consumes = "application/json", produces = "application/json")
	public APIResponse createWarrantyInclusion(@RequestBody WarrantyInclusion inclusion) {
		return warrantyInclusionService.createWarrantyInclusion(inclusion);
	}

	@GetMapping(value = "/grt-by-id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return warrantyInclusionService.GetById(id);
	}

	@PutMapping(value = "/edit-warranty-inclusion", consumes = "application/json", produces = "application/json")
	public APIResponse editWarrantyInclusion(@RequestBody WarrantyInclusion inclusion) {
		return warrantyInclusionService.editWarrantyInclusion(inclusion);
	}

	@GetMapping(value = "/list-by-org-id", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return warrantyInclusionService.getAll(organizationId);
	}

	@GetMapping(value = "/warranty-inclusion-pagination")
	public APIResponsePaging getWarrantyInclusionPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, 
			@RequestParam(required = false) Long agreementId,@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return warrantyInclusionService.getPagenationByOrganization(organizationId,agreementId, pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping(value = "/list-by-inclusion-agreement-id", produces = "application/json")
	public APIResponse getAllByAgreementId(Long agreementId) {
		return warrantyInclusionService.getAllByAgreementId(agreementId);
	}

}
