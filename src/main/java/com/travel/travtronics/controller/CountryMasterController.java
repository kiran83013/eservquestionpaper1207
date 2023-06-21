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

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CountryMaster;
import com.travel.travtronics.request.CountryMasterRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.CountryMasterService;

@RestController
@RequestMapping("/country_master")
public class CountryMasterController {

	@Autowired
	CountryMasterService cmService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse createCountry(@RequestBody List<CountryMaster> country) {
		return cmService.createCountry(country);
	}

	@GetMapping(value = "/id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long id) {
		return cmService.GetById(id);
	}

//	@PutMapping(value = "/edit", consumes = "application/json", produces = "application/json")
//	public APIResponse editCostCenter(@RequestBody  List<CountryMaster> country) {
//		return cmService.editCountry(country);
//	}

	@PutMapping(value = "/edit", consumes = "application/json", produces = "application/json")
	public APIResponse editCountry(@RequestBody List<CountryMasterRequest> country) {
		return cmService.editCountry(country);
	}

	@PostMapping(value = "save-and-update", consumes = "application/json", produces = "application/json")
	public APIResponse saveAndEdit(@RequestBody List<CountryMaster> line) {
		return cmService.saveAndEdit(line);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return cmService.getAll(organizationId);
	}

	@GetMapping(value = "/list-country-master-pagination")
	public APIResponsePaging getCountryMasterPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return cmService.getCountryMasterPagenationByOrganization(organizationId, pageNo, pageSize, sortBy, sortType);
	}
}
