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
import com.travel.travtronics.model.BusinessUnit;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.BusinessUnitService;

@RestController
@RequestMapping("/businessUnit")
public class BusinessUnitController {
	
	@Autowired
	BusinessUnitService		bunitService;
	
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createBusiness(@RequestBody BusinessUnit  bunit) {
		return bunitService.createBusiness(bunit);
	}
	
	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long businessUnitId) {
		return bunitService.GetById(businessUnitId);
	}
	
	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editBusiness(@RequestBody BusinessUnit  bunit) {
		return bunitService.editBusiness(bunit);
	}
	
	@GetMapping(value ="/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return bunitService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-businessunit-pagination")
	public APIResponsePaging getBusinessUnitPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "businessUnitId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return bunitService.getBusinessUnitPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}
	
}
