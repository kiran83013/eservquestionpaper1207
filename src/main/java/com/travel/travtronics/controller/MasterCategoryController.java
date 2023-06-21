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
import com.travel.travtronics.model.MasterCategory;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.MasterCategoryService;



@RestController
@RequestMapping("/master_category")
public class MasterCategoryController {

	@Autowired
	MasterCategoryService masterCategoryService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse createMasterCategory(@RequestBody MasterCategory model) {

		return masterCategoryService.createMasterCategory(model);
	}

	@GetMapping(value = "/getById", produces = "application/json")
	public APIResponse getById(@RequestParam Long categoryId) {
		return masterCategoryService.getById(categoryId);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public APIResponse getCategory(@RequestParam Long organizationId) {
		return masterCategoryService.getCategory(organizationId);
	}

	@PutMapping(value = "/updateModule", consumes = "application/json", produces = "application/json")
	public APIResponse editCategoryType(@RequestBody MasterCategory model) {
		return masterCategoryService.editCategoryType(model);
	}
	
	@GetMapping(value = "/list-mastercategory-pagination")
	public APIResponsePaging getMasterCategoryPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "categoryId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return masterCategoryService.getMasterCategoryPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

}
