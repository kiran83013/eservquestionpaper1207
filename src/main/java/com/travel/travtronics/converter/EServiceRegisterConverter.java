package com.travel.travtronics.converter;

import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.response.EServiceRegisterResponse;

public class EServiceRegisterConverter {

	public static EServiceRegisterResponse convertEServiceRegisterToModel(EServiceRegister model) {
		EServiceRegisterResponse response = new EServiceRegisterResponse();
		response.setCreatedBy(model.getCreatedBy());
		response.setCreatedDate(model.getCreatedDate());
		response.setDescription(model.getDescription());
		response.setEndDate(model.getEndDate());
		response.setId(model.getId());
		response.setModuleId(model.getModuleId());
		response.setOrganizationId(model.getOrganizationId());
		response.setServiceName(model.getServiceName());
		response.setServiceUrl(model.getServiceUrl());
		response.setStartDate(model.getStartDate());
		response.setStatus(model.getStatus());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		response.setIsBpf(model.getIsBpf());
		response.setIsServiceUrl(model.getIsServiceUrl());
		response.setIsQuartz(model.getIsQuartz());
		response.setOutput(model.getOutput());
		response.setTemplate(model.getTemplate());
		response.setIsExternalUrl(model.getIsExternalUrl());
		return response;
	}
}
