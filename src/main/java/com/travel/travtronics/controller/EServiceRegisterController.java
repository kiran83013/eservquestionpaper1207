package com.travel.travtronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.EServiceRegisterService;

@RestController
public class EServiceRegisterController {

	@Autowired
	EServiceRegisterService esrService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse create(@RequestBody EServiceRegister eservice) {
		return esrService.create(eservice);
	}

	@GetMapping(value = "/id", produces = "application/json")
	public APIResponse getId(@RequestParam Long id) {
		return esrService.getId(id);
	}

	@PutMapping(value = "/edit", consumes = "application/json", produces = "application/json")
	public APIResponse edit(@RequestBody EServiceRegister eservice) {
		return esrService.edit(eservice);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAllByOrganization(@RequestParam Long organizationId) {
		return esrService.getAllByOrganization(organizationId);
	}

	

	@GetMapping(value = "/get")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId,
			@RequestParam(required = false) String serviceName, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return esrService.getPagenationByOrganization(organizationId, serviceName, pageNo, pageSize, sortBy, sortType);
	}

}
