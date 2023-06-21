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
import com.travel.travtronics.model.Location;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	LocationService locationService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createlocation(@RequestBody Location location) {
		return locationService.createLocation(location);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long locationId) {
		return locationService.GetById(locationId);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editLocation(@RequestBody Location location) {
		return locationService.editLocation(location);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return locationService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-by-costcenter", produces = "application/json")
	public APIResponse getAllByCostCenter(@RequestParam Long costCenterId) {
		return locationService.getAllByCostCenter(costCenterId);
	}
	
	@GetMapping(value = "/list-location-pagination")
	public APIResponsePaging getLocationPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "locationId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return locationService.getLocationPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

}
