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
import com.travel.travtronics.model.FieldProcessHeader;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.FieldProcessHeaderService;

@RestController
@RequestMapping("/FieldProcessHeader")
public class FieldProcessHeaderController {

	@Autowired
	FieldProcessHeaderService fieldProcessHeaderService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createFieldProcess(@RequestBody FieldProcessHeader field) {
		return fieldProcessHeaderService.createFieldProcess(field);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return fieldProcessHeaderService.GetById(id);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editFieldProcess(@RequestBody FieldProcessHeader field) {
		return fieldProcessHeaderService.editFieldProcess(field);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return fieldProcessHeaderService.getAll(organizationId);
	}

	@GetMapping(value = "/list-field-process-pagination")
	public APIResponsePaging getFieldProcessPagenationByOrganization(
			@RequestParam(required = false) Long organizationId,@RequestParam(required = false) String processName, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "prcId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return fieldProcessHeaderService.getFieldProcessPagenationByOrganization(organizationId,processName, pageNo, pageSize,sortBy, sortType);
	}

	@GetMapping(value = "/get-sr-type-stages", produces = "application/json")
	public APIResponse getSRTypeStatges(@RequestParam Integer srTypeId) {
		return fieldProcessHeaderService.getSRTypeStatges(srTypeId);
	}

	@GetMapping(value = "/get-sr-type-stages-info", produces = "application/json")
	public APIResponse getSRTypeStatgesInfo(@RequestParam Long srTypeId) {
		return fieldProcessHeaderService.getSRTypeStatgesInfo(srTypeId);
	}

}
