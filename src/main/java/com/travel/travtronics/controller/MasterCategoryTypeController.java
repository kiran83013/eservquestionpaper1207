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
import com.travel.travtronics.model.MasterCategoryType;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.MasterCategoryTypeService;



@RestController
@RequestMapping("/master_category_type")
public class MasterCategoryTypeController {

	@Autowired
	MasterCategoryTypeService masterCategoryTypeService;

	@PostMapping(value = "/createCategoryType", consumes = "application/json", produces = "application/json")
	public APIResponse createCategoryType(@RequestBody MasterCategoryType model) {

		return masterCategoryTypeService.createCategoryType(model);
	}

	@GetMapping(value = "/getById", produces = "application/json")
	public APIResponse getCategoryById(@RequestParam Long categoryId) {
		return masterCategoryTypeService.getCategoryById(categoryId);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public APIResponse getCategory(@RequestParam Long organizationId) {
		return masterCategoryTypeService.getCategory(organizationId);
	}

	@PutMapping(value = "/updateModule", consumes = "application/json", produces = "application/json")
	public APIResponse editCategoryType(@RequestBody MasterCategoryType model) {
		return masterCategoryTypeService.editCategoryType(model);
	}
	
	@GetMapping(value = "/list-master-categorytype-pagination")
	public APIResponsePaging getMasterCategoryTypePagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "categoryId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return masterCategoryTypeService.getMasterCategoryTypePagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

}
