package com.travel.travtronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.model.CommunicationModuleLink;
import com.travel.travtronics.request.CommunicationDto;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.service.CommunicationLinkService;



@RestController
public class CommunicationLinkController {
	
	@Autowired
	CommunicationLinkService communicationLinkService;


	@PostMapping("create-communication-module-link")
	public MessageStatusResponse createCommunication(@Valid @RequestBody CommunicationModuleLink link) {
		return communicationLinkService.createCommunication(link);
	}

	@PostMapping("get-communication-module-link")
	public APIResponse getCommunications(@RequestBody CommunicationDto dto) {

		return communicationLinkService.getCommunications(dto);
	}

}
