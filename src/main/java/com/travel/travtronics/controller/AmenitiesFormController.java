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
import com.travel.travtronics.model.AmenitiesForm;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.AmenitiesFormService;

@RestController
@RequestMapping("/amenities")
public class AmenitiesFormController {

	@Autowired
	AmenitiesFormService amenitiesformService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createAmenities(@RequestBody AmenitiesForm amenities) {
		return amenitiesformService.createAmenities(amenities);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long amenitiesFormId) {
		return amenitiesformService.GetById(amenitiesFormId);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editLocation(@RequestBody AmenitiesForm amenities) {
		return amenitiesformService.editLocation(amenities);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(Long organizationId) {
		return amenitiesformService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-amenitiesform-pagination")
	public APIResponsePaging getAmenitiesFormPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "amenitiesFormId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return amenitiesformService.getAmenitiesFormPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

}
