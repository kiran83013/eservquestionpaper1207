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
import com.travel.travtronics.model.ServiceAttachments;
import com.travel.travtronics.request.ServiceAttachmentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.ServiceAttachmentsService;

@RestController
@RequestMapping("/service_attachments")
public class ServiceAttachmentsController {

	@Autowired
	ServiceAttachmentsService serviceAttachmentsService;

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public APIResponse createAttachments(@RequestBody List<ServiceAttachments> attachments) {
		return serviceAttachmentsService.createAttachments(attachments);
	}

//	@PutMapping(value = "/saveAndUpdate", consumes = "application/json", produces = "application/json")
//	public ResponseEntity<?> saveAndUpdate(@RequestBody ServiceAttachments attachments) {
//		return serviceAttachmentsService.saveAndUpdate(attachments);
//	}

	@GetMapping(value = "headerId", produces = "application/json")
	public APIResponse GetById(@RequestParam Long headerId) {
		return serviceAttachmentsService.GetById(headerId);
	}

	@GetMapping(value = "get-attachments", produces = "application/json")
	public APIResponse GetFeAttachmentsByHeaderId(@RequestParam Long headerId) {
		return serviceAttachmentsService.getAttachmentsById(headerId);
	}

	@PostMapping(path = "/saveAndUpdate")
	public APIResponse saveAndUpdate(@RequestBody List<ServiceAttachmentsRequest> attachments) {
		return serviceAttachmentsService.saveAndUpdate(attachments);
	}

	@GetMapping(value = "/get")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "attachmentsId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return serviceAttachmentsService.getPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}

	@GetMapping(value = "feild-attachments-localization", produces = "application/json")
	public APIResponse getlocalizationInfo(@RequestParam Long headerId, @RequestParam String langCode) {
		return serviceAttachmentsService.getlocalizationInfo(headerId, langCode);
	}
}
