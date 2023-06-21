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

import com.travel.travtronics.model.GenerateSetupMaster;
import com.travel.travtronics.request.GenerateSetupMasterRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.service.GenerateSetupMasterService;

@RestController
@RequestMapping("/master_general_setup")
public class GenerateSetupMasterController {

	@Autowired
	GenerateSetupMasterService generateSetupMasterService;

	@PostMapping(value = "/create-setup-master", consumes = "application/json", produces = "application/json")
	public APIResponse createSetUpMaster(@RequestBody List<GenerateSetupMasterRequest> model) {
		return generateSetupMasterService.createSetUpMaster(model);
	}

	@GetMapping(value = "/get-id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return generateSetupMasterService.GetById(id);
	}

	@PutMapping(value = "/edit-setup-master", consumes = "application/json", produces = "application/json")
	public APIResponse editSetUpMaster(@RequestBody GenerateSetupMaster model) {
		return generateSetupMasterService.editSetUpMaster(model);
	}

	@GetMapping(value = "/list-by-orgId", produces = "application/json")
	public APIResponse getAll(@RequestParam Long orgId) {
		return generateSetupMasterService.getAll(orgId);
	}

//	@GetMapping(value = "/list-by-category-Id", produces = "application/json")
//	public APIResponse getAllByCategory(@RequestParam Long categoryId) {
//		return generateSetupMasterService.getAllByCategory(categoryId);
//	}

	@GetMapping(value = "/list-by-orgId-category", produces = "application/json")
	public APIResponse getAllByOrgAndCategory(@RequestParam Long orgId, @RequestParam Long categoryId) {
		return generateSetupMasterService.getAllByOrgAndCategory(orgId, categoryId);
	}

	@GetMapping(value = "/list-by-orgId-category-localization", produces = "application/json")
	public APIResponse getAllByOrgAndCategoryLocalization(@RequestParam Long orgId, @RequestParam Long categoryId,
			@RequestParam(required = false, defaultValue = "en") String langCode) {
		return generateSetupMasterService.getAllByOrgAndCategoryLocalization(orgId, categoryId, langCode);
	}
}
