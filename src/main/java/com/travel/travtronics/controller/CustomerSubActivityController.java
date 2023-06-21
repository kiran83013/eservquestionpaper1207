package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CustomerSubActivity;
import com.travel.travtronics.request.CustomerSubActivityRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.CustomerSubActivityService;

@RestController
@RequestMapping("/customer_sub_activity")
public class CustomerSubActivityController {

	@Autowired
	CustomerSubActivityService csaService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse Create(@RequestBody List<CustomerSubActivity> subactivity) {
		return csaService.Create(subactivity);
	}

	@GetMapping(value = "/id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return csaService.GetById(id);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editSubActivity(@RequestBody List<CustomerSubActivityRequest> subactivity) {
		return csaService.editSubActivity(subactivity);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return csaService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-customer-sub-activity-pagination")
	public APIResponsePaging getCustomerSubActivityPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return csaService.getCustomerSubActivityPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}
}
