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
import com.travel.travtronics.model.ServiceContractToItem;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.ServiceContractToItemService;

@RestController
@RequestMapping("/service_contract_to_item")
public class ServiceContractToItemController {

	@Autowired
	ServiceContractToItemService serviceContractToItemService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse create(@RequestBody ServiceContractToItem item) {
		return serviceContractToItemService.create(item);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return serviceContractToItemService.GetById(id);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse edit(@RequestBody ServiceContractToItem item) {
		return serviceContractToItemService.edit(item);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(Long organization) {
		return serviceContractToItemService.getAll(organization);
	}

	@GetMapping(value = "/list-pagination")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organization,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return serviceContractToItemService.getPagenationByOrganization(organization, pageNo, pageSize, sortBy,
				sortType);
	}
}
