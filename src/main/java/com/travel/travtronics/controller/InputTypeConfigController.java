package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.dto.InputTypeConfigRequest;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.service.InputTypeConfigService;

@RestController
public class InputTypeConfigController {

	@Autowired
	InputTypeConfigService configService;

	@PostMapping(value = "/create-config")
	public MessageStatusResponse createConfig(@RequestBody List<InputTypeConfigRequest> models) {
		return configService.createConfig(models);
	}

	@PutMapping(value = "/modify-config/{id}")
	public MessageStatusResponse modifyConfig(@RequestBody InputTypeConfigRequest model, @PathVariable Integer id) {
		return configService.modifyConfig(model, id);
	}

	@GetMapping(value = "/get-config/{id}")
	public APIResponse getConfig(@PathVariable Integer id) {
		return configService.getConfig(id);
	}
	@GetMapping(value = "/get-all-config")
	public APIResponse getConfig(@RequestParam Long organizationId) {
		return configService.getConfig(organizationId);
	}
	
	@GetMapping(value = "/get-pagination-by-orgnizationId")
	public APIResponsePaging getPaginationByOrganizationId(@RequestParam(required = false) Long organizationId, @RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "configId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return configService.getPaginationByOrganizationId(organizationId, name, pageNo, pageSize, sortBy, sortType);
	}
}
