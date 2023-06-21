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
import com.travel.travtronics.model.CostCenter;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.CostCenterService;

@RestController
@RequestMapping("/costcenter")
public class CostCenterController {

	@Autowired
	CostCenterService ccService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createCostCenter(@RequestBody CostCenter costcenter) {
		return ccService.createCostCenter(costcenter);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long costCenterId) {
		return ccService.GetById(costCenterId);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editCostCenter(@RequestBody CostCenter costcenter) {
		return ccService.editCostCenter(costcenter);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizatioinId) {
		return ccService.getAll(organizatioinId);
	}
	
	@GetMapping(value = "/list-by-businessUnitId", produces = "application/json")
	public APIResponse getAllByBusinessUnitId(@RequestParam Long businessUnitId) {
		return ccService.getAllByBusinessUnitId(businessUnitId);
	}
	
	@GetMapping(value = "/list-cost-center-pagination")
	public APIResponsePaging getCostCenterPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "costCenterId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return ccService.getCostCenterPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

}
