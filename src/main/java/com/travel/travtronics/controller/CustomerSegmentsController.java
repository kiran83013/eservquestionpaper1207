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
import com.travel.travtronics.model.CustomerSegments;
import com.travel.travtronics.request.CustomerSegmentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.CustomerSegmentsService;

@RestController
@RequestMapping("/customer_segments")
public class CustomerSegmentsController {

	@Autowired
	CustomerSegmentsService csService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse Create(@RequestBody List<CustomerSegments> segments) {
		return csService.Create(segments);
	}

	@GetMapping(value = "/id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return csService.GetById(id);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editSegments(@RequestBody List<CustomerSegmentsRequest> segments) {
		return csService.editSegments(segments);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return csService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-customersegments-pagination")
	public APIResponsePaging getCustomerSegmentsPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return csService.getCustomerSegmentsPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}
}
