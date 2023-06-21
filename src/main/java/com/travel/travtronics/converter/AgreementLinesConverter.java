package com.travel.travtronics.converter;


import com.travel.travtronics.model.AgreementLines;
import com.travel.travtronics.response.AgreementLinesResponse;


public class AgreementLinesConverter {
	
	public static final AgreementLinesResponse convertModelToResponse(AgreementLines model) {
		AgreementLinesResponse response = new AgreementLinesResponse();
		response.setAgreementId(model.getAgreementId());
		response.setAgreementLineId(model.getAgreementLineId());
		response.setCategory(model.getCategory());
		response.setCreatedBy(model.getCreatedBy());
		response.setCreatedDate(model.getCreatedDate());
		response.setDaysMax(model.getDaysMax());
		response.setDaysMin(model.getDaysMin());
		response.setLineName(model.getLineName());
		response.setMeteredMax(model.getMeteredMax());
		response.setMeteredMin(model.getMeteredMin());
		response.setOnSite(model.getOnSite());
		response.setOrganizationId(model.getOrganizationId());
		response.setServiceAgreementLine(model.getServiceAgreementLine());
		response.setSrtype(model.getSrtype());
		response.setType(model.getType());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		response.setStatus(model.getStatus());
		return response;
	}
}
