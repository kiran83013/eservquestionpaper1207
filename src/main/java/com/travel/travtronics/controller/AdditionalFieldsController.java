package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.request.AdditionalFieldsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.service.AdditionalFieldsService;

@RestController
@RequestMapping("/AdditionalFields")
public class AdditionalFieldsController {

	@Autowired
	AdditionalFieldsService additionalFieldsService;
	
	@PutMapping(path = "/additional-fields")
	public APIResponse additionalFields(@RequestBody List<AdditionalFieldsRequest> requestModels) {
		return additionalFieldsService.additionalFields(requestModels);
	}
	
	@GetMapping(path = "/additional-fields/{headerId}")
	public APIResponse getadditionalFieldsByHeaderId(@PathVariable Long headerId,
			@RequestParam(name = "isPricing", required = false) Long isPricing) {
				return additionalFieldsService.getadditionalFieldsByHeaderId(headerId, isPricing);
		
	}
	
	@GetMapping(path = "/additional-fields/{headerId}/transitionId")
	public APIResponse getadditionalFieldsByHeaderIdAndTransitionId(@PathVariable Long headerId,
			@RequestParam(name = "transitionId", required = false) Long transitionId) {
				return additionalFieldsService.getadditionalFieldsByHeaderIdAndTransitionId(headerId, transitionId);
		
	}
}
