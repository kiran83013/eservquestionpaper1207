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
import com.travel.travtronics.model.MasterSubmode;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.MasterSubmodeService;

@RestController
@RequestMapping("/master_submode")
public class MasterSubmodeController {

	@Autowired
	MasterSubmodeService msmServices;

	@PostMapping(value = "/createModule", consumes = "application/json", produces = "application/json")
	public APIResponse createSubMode(@RequestBody MasterSubmode subMode) {

		return msmServices.createSubMode(subMode);
	}

	@GetMapping(value = "/getById", produces = "application/json")
	public APIResponse getSubModeById(@RequestParam Long id) {
		return msmServices.getSubModeById(id);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public APIResponse getAllSubMode(@RequestParam Long organizationId) {
		return msmServices.getAllSubMode(organizationId);
	}

	@PutMapping(value = "/updateModule", consumes = "application/json", produces = "application/json")
	public APIResponse editSubMode(@RequestBody MasterSubmode subMode) {
		return msmServices.editSubMode(subMode);
	}
	
	@GetMapping(value = "/list-master-submode-pagination")
	public APIResponsePaging getMasterSubModePagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return msmServices.getMasterSubModePagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

}
