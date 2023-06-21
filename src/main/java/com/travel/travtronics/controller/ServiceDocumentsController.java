package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.ServiceDocuments;
import com.travel.travtronics.request.ServiceDocumentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.ServiceDocumentsService;

@RestController
@RequestMapping("/service_documents")
public class ServiceDocumentsController {

	@Autowired
	ServiceDocumentsService serviceDocumentsService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse createDocument(@RequestBody List<ServiceDocuments> documents) {
		return serviceDocumentsService.createDocument(documents);
	}

	@GetMapping(value = "/headerId", produces = "application/json")
	public APIResponse GetById(@RequestParam Long headerId) {
		return serviceDocumentsService.GetById(headerId);
	}

	@PostMapping(path = "/saveAndUpdate")
	public APIResponse saveAndUpdate(@RequestBody List<ServiceDocumentsRequest> documents) {
		return serviceDocumentsService.saveAndUpdate(documents);
	}

	@GetMapping(value = "/get")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return serviceDocumentsService.getPagenationByOrganization(organizationId, pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping(value = "/feild-docs-localization", produces = "application/json")
	public APIResponse feildLocalizationDocs(@RequestParam Long headerId, @RequestParam String langCode) {
		return serviceDocumentsService.feildLocalizationDocs(headerId,langCode);
	}
}
