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
import com.travel.travtronics.model.Departments;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.DepartmentsService;

@RestController
@RequestMapping("/Departments/")
public class DepartmentsController {

	@Autowired
	DepartmentsService departmentsService;
	
	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse create(@RequestBody Departments model) {
		return departmentsService.create(model);
	}
	
	@GetMapping(value = "list", produces = "application/json")
	public APIResponse list(@RequestParam Long organizationId) {
		return departmentsService.list(organizationId);
	}
	
	@GetMapping(value = "id", produces = "application/json")
	public APIResponse getById(@RequestParam Long departmentId) {
		return departmentsService.getById(departmentId);
	}
	
	@PutMapping(value = "update", consumes = "application/json", produces = "application/json")
	public APIResponse update(@RequestBody Departments model) {
		return 	departmentsService.update(model);	
	}
	
	@GetMapping(value = "organizationId", produces = "application/json")
	public APIResponse getByOrganizationId(@RequestParam Long id) {
		return departmentsService.getByOrganizationId(id);
	}
	
	@GetMapping(value = "/list-department-pagination")
	public APIResponsePaging getDepartmentPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "departmentId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return departmentsService.getDepartmentPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}
}
