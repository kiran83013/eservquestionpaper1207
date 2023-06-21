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
import com.travel.travtronics.model.ServiceMenu;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.ServiceMenuService;

@RestController
@RequestMapping("/service-menu-type-lines")
public class ServiceMenuController {

	@Autowired
	ServiceMenuService serviceMenuService;

	/*
	 * Create ServiceMenu Data
	 */
	@PostMapping(value = "/create-or-update", consumes = "application/json", produces = "application/json")
	public APIResponse createOrUpdate(@RequestBody List<ServiceMenu> serviceMenuType) {
		return serviceMenuService.create(serviceMenuType);
	}

	/*
	 * Update ServiceMenu Data
	 */
	@PutMapping(value = "/update")
	public APIResponse update(@RequestBody ServiceMenu serviceMenuType) {
		return serviceMenuService.update(serviceMenuType);
	}

	/*
	 * Get ServiceMenu Data based given id
	 */
	@GetMapping(value = "/get-by-id")
	public APIResponse getById(@RequestParam Long serviceMenuTypeId) {
		return serviceMenuService.getById(serviceMenuTypeId);
	}

	/*
	 * Get ServiceMenu Data based given ServiceMenuType
	 */
	@GetMapping(value = "/get-by-service-menu-type")
	public APIResponse getByServiceMenuType(@RequestParam Long serviceMenuType) {
		return serviceMenuService.getByServiceMenuType(serviceMenuType);
	}
	
	   @GetMapping(value = "/get")
	    public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organization,
	                                                @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
	                                                @RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
	        return  serviceMenuService.getPagenationByOrganization(organization, pageNo, pageSize, sortBy, sortType);
	    }

	/*
	 * Get All ServiceMenu Data
	 */
	/*
	 * @GetMapping(value = "/get") public APIResponsePaging
	 * getServiceMenuType(@RequestParam(required = false) String name,
	 * 
	 * @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue =
	 * "10") int pageSize,
	 * 
	 * @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue
	 * = "asc", required = false) SortType sortType) { return
	 * serviceMenuService.getServiceMenu(name, pageNo, pageSize, sortBy, sortType);
	 * }
	 */
}
