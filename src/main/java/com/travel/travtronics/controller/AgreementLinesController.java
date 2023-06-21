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
import com.travel.travtronics.model.AgreementLines;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.AgreementLinesService;

@RestController
@RequestMapping("/agreement_lines")
public class AgreementLinesController {

	@Autowired
	AgreementLinesService agreementLinesService;

	@PostMapping(value = "create-agreement-lines", consumes = "application/json", produces = "application/json")
	public APIResponse createAgreementLines(@RequestBody AgreementLines agreement) {
		return agreementLinesService.createAgreementLines(agreement);
	}

	@GetMapping(value = "get-id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long agreementLineId) {
		return agreementLinesService.GetById(agreementLineId);
	}

	@PutMapping(value = "edit-agreement", consumes = "application/json", produces = "application/json")
	public APIResponse editAgreement(@RequestBody AgreementLines agreement) {
		return agreementLinesService.editAgreement(agreement);
	}

	@GetMapping(value = "/list-by-org", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return agreementLinesService.getAll(organizationId);
	}

	/**@GetMapping(value = "/list-by-agreemnt-Id", produces = "application/json")
	public APIResponse getAllByAgreementId(Long agreementId) {
		return agreementLinesService.getAllByAgreementId(agreementId);
	}**/

	@GetMapping(value = "/agreementlines-pagination")
	public APIResponsePaging getFieldProcessPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(required = false) Long agreementId,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "agreementLineId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return agreementLinesService.getPagenationByOrganizationAndAgreementId(organizationId,agreementId, pageNo, pageSize, sortBy, sortType);
	}

}
