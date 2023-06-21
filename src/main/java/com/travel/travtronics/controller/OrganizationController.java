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
import com.travel.travtronics.model.Organization;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.OrganizationService;


@RestController
@RequestMapping("/organization/")
public class OrganizationController {

	@Autowired
	OrganizationService organizationservice;
	
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createOrganization(@RequestBody Organization model) {
		return organizationservice.createOrganization(model);
	}
	
	@GetMapping(value = "list", produces = "application/json")
	public APIResponse getOrganizationlist() {
		return organizationservice.getOrganizationlist();
	}
	
	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetByOrganization(@RequestParam Long organizationId) {
		return organizationservice.GetByOrganization(organizationId);
	}
	
	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editOrganization(@RequestBody Organization model) {
		return organizationservice.editOrganization(model);
	}
	
	@GetMapping(value = "orgList", produces = "application/json")
	public APIResponse getOrganizationList() {
		return organizationservice.getOrganizationList();
	}
	
	@GetMapping(value = "/list-organization-pagination")
	public APIResponsePaging getOrganizationPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "organizationId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return organizationservice.getOrganizationPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,sortType);
	}
}
