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
import com.travel.travtronics.model.CustomerActivity;
import com.travel.travtronics.request.CustomerActivitiyRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.CustomerActivityService;

@RestController
@RequestMapping("/customer_activity")
public class CustomerActivityController {

	@Autowired
	CustomerActivityService caService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse Create(@RequestBody List<CustomerActivity> activity) {
		return caService.Create(activity);
	}

	@GetMapping(value = "/id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return caService.GetById(id);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editActivity(@RequestBody List<CustomerActivitiyRequest> activity) {
		return caService.editActivity(activity);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return caService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-customer-activity-pagination")
	public APIResponsePaging getCustomerActivityPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return caService.getCustomerActivityPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}
}
