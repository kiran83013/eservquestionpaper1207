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
import com.travel.travtronics.model.MasterModule;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.MasterModuleService;

@RestController
@RequestMapping("/master_module")
public class MasterModuleController {

	@Autowired
	MasterModuleService masterModuleService;

	@PostMapping(value = "/createModule", consumes = "application/json", produces = "application/json")
	public APIResponse createModule(@RequestBody MasterModule model) {

		return masterModuleService.createModule(model);
	}

	@GetMapping(value = "/getById", produces = "application/json")
	public APIResponse getModuleById(@RequestParam Long id) {
		return masterModuleService.getModuleById(id);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public APIResponse getMasterModules(@RequestParam Long organizationId) {
		return masterModuleService.getMasterModules(organizationId);
	}
	
	@GetMapping(value = "/list-master-modul-pagination")
	public APIResponsePaging getMasterModulePagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return masterModuleService.getMasterModulePagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

	@PutMapping(value = "/updateModule", consumes = "application/json", produces = "application/json")
	public APIResponse editMasterModule(@RequestBody MasterModule model) {
		return masterModuleService.editMasterModule(model);
	}

}
