package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.LineCharges;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.LineChargeService;

@RestController
@RequestMapping("/lines_charges")
public class LineChargeController {

	@Autowired
	LineChargeService lineChargeService;

	@PostMapping(value = "create-lines-charges", consumes = "application/json", produces = "application/json")
	public APIResponse createCharges(@RequestBody List<LineCharges> line) {
		return lineChargeService.createCharges(line);
	}

	@GetMapping(value = "get-id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return lineChargeService.GetById(id);
	}

	@PostMapping(value = "save-and-update", consumes = "application/json", produces = "application/json")
	public APIResponse saveAndEdit(@RequestBody List<LineCharges> line) {
		return lineChargeService.saveAndEdit(line);
	}

	@GetMapping(value = "/list-by-organization", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return lineChargeService.getAll(organizationId);
	}

	@GetMapping(value = "/linecharges-pagination")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId, 
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "lineChargeId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return lineChargeService.getPagenationByOrganization(organizationId, pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping(value = "/list-by-agreementId", produces = "application/json")
	public APIResponse getAllByAgreementId(Long agreementId) {
		return lineChargeService.getAllByAgreementId(agreementId);
	}

	@GetMapping(value = "/list-by-agreementlineId", produces = "application/json")
	public APIResponse getAllByAgreementLineId(Long agreementLineId) {
		return lineChargeService.getAllByAgreementLineId(agreementLineId);
	}

}
