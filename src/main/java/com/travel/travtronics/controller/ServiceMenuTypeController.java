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
import com.travel.travtronics.model.ServiceMenuType;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.ServiceMenuTypeService;

@RestController
@RequestMapping("/service_menu_type")
public class ServiceMenuTypeController {

	@Autowired
	ServiceMenuTypeService serviceMenuTypeService;

	/*
	 * Create ServiceMenuType Data
	 */
	@PostMapping(value = "/create")
	public APIResponse create(@RequestBody ServiceMenuType serviceMenuType) {
		return serviceMenuTypeService.create(serviceMenuType);
	}

	/*
	 * Update ServiceMenuType Data
	 */
	@PutMapping(value = "/update")
	public APIResponse update(@RequestBody ServiceMenuType serviceMenuType) {
		return serviceMenuTypeService.update(serviceMenuType);
	}

	/*
	 * Get ServiceMenuType Data based given id
	 */
	@GetMapping(value = "/get-by-id")
	public APIResponse getById(@RequestParam Long serviceMenuTypeId) {
		return serviceMenuTypeService.getById(serviceMenuTypeId);
	}

	/*
	 * Get ServiceMenuType Data based given organization
	 */
	@GetMapping(value = "/get-by-organization")
	public APIResponse getByOrganization(@RequestParam Long org) {
		return serviceMenuTypeService.getByOrganization(org);
	}

	/*
	 * Get All ServiceMenuType Data
	 */
	@GetMapping(value = "/get-pagnation")
	public APIResponsePaging getServiceMenuType(@RequestParam(required = false) String name,@RequestParam(required = false) Long organization,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return serviceMenuTypeService.getServiceTypeMenu(name,organization, pageNo, pageSize, sortBy, sortType);
	}
}
