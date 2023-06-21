package com.travel.travtronics.converter;

import com.travel.travtronics.model.Agreement;
import com.travel.travtronics.response.AgreementResponse;

public class AgreementConverter {

	public static AgreementResponse convertAgreementToResponse(Agreement model) {
		AgreementResponse response = new AgreementResponse();
		response.setAgreementId(model.getAgreementId());
		response.setCategory(model.getCategory());
		response.setCreatedBy(model.getCreatedBy());
		response.setCreatedDate(model.getCreatedDate());
		response.setDescription(model.getDescription());
		response.setName(model.getName());
		response.setOrganizationId(model.getOrganizationId());
		response.setRecordStatus(model.getRecordStatus());
		response.setType(model.getType());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		response.setValidFrom(model.getValidFrom());
		response.setValidTo(model.getValidTo());
		response.setWfstatus(model.getWfstatus());
		return response;
	}

}
