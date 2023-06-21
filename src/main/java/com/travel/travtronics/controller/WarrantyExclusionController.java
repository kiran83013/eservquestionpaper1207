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
import com.travel.travtronics.model.WarrantyExclusion;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.WarrantyExclusionService;

@RestController
@RequestMapping("/warranty_exclusion")
public class WarrantyExclusionController {

	@Autowired
	WarrantyExclusionService warrantyExclusionService;

	@PostMapping(value = "/create-warranty-exclusion", consumes = "application/json", produces = "application/json")
	public APIResponse createWarrantyInclusion(@RequestBody WarrantyExclusion exclusion) {
		return warrantyExclusionService.createWarrantyExclusion(exclusion);
	}

	@GetMapping(value = "/get-by-id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return warrantyExclusionService.GetById(id);
	}

	@PutMapping(value = "/edit-warranty-exclusion", consumes = "application/json", produces = "application/json")
	public APIResponse editWarrantyInclusion(@RequestBody WarrantyExclusion exclusion) {
		return warrantyExclusionService.editWarrantyExclusion(exclusion);
	}

	@GetMapping(value = "/list-by-org-id", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return warrantyExclusionService.getAll(organizationId);
	}

	@GetMapping(value = "/warranty-exclusion-pagination")
	public APIResponsePaging getWarrantyExclusionPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(required = false) Long agreementId,
			@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return warrantyExclusionService.getPagenationByOrganization(organizationId,agreementId, pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping(value = "/list-by-exclusion-agreement-id", produces = "application/json")
	public APIResponse getAllByAgreementId(Long agreementId) {
		return warrantyExclusionService.getAllByAgreementId(agreementId);
	}
}
