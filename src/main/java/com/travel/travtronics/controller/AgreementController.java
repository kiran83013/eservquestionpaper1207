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
import com.travel.travtronics.model.Agreement;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.AgreementService;

@RestController
@RequestMapping("/agreement")
public class AgreementController {

	@Autowired
	AgreementService agreementService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createAgreement(@RequestBody Agreement agreement) {
		return agreementService.createAgreement(agreement);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return agreementService.GetById(id);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editAgreement(@RequestBody Agreement agreement) {
		return agreementService.editAgreement(agreement);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return agreementService.getAll(organizationId);
	}
	
	@GetMapping(value = "/agreement-pagination")
	public APIResponsePaging getFieldProcessPagenationByOrganization(
			@RequestParam(required = false) Long organizationId,@RequestParam(required = false)  String name, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "agreementId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return agreementService.getPagenationByOrganization(organizationId,name, pageNo, pageSize, sortBy,sortType);
	}

}
