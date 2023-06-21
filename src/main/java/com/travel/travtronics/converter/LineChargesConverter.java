package com.travel.travtronics.converter;

import com.travel.travtronics.model.LineCharges;
import com.travel.travtronics.request.LineChargesRequest;
import com.travel.travtronics.response.LineChargesResponse;

public class LineChargesConverter {

	public static LineCharges convertLineChargesToModel(LineChargesRequest request) {
		LineCharges charges = new LineCharges();
		if(request.getLineChargeId()!=null && request.getLineChargeId()!=0)
			charges.setLineChargeId(request.getLineChargeId());
		if(request.getAgreementId()!=null && request.getAgreementId()!=0)
			charges.setAgreementId(request.getAgreementId());
		if(request.getAgreementLineId()!=null && request.getAgreementLineId()!=0)
			charges.setAgreementLineId(request.getAgreementLineId());
		if(request.getCharge()!=null && !request.getCharge().isEmpty())
			charges.setCharge(request.getCharge());
		if(request.getChargeAmount()!=null && request.getChargeAmount()!=0)
			charges.setChargeAmount(request.getChargeAmount());
		if(request.getCostOnDate()!=null )
			charges.setCostOnDate(request.getCostOnDate());
		if(request.getCreatedBy()!=null && request.getCreatedBy()!=0)
			charges.setCreatedBy(request.getCreatedBy());
		if(request.getCreatedDate()!=null)
			charges.setCreatedDate(request.getCreatedDate());
		if(request.getItem()!=null && !request.getItem().isEmpty())
			charges.setItem(request.getItem());
		if(request.getOnSite()!=null && !request.getOnSite().isEmpty())
			charges.setOnSite(request.getOnSite());
		if(request.getOrganizationId()!=null && request.getOrganizationId()!=0)
			charges.setOrganizationId(request.getOrganizationId());
		if(request.getUpdatedBy()!=null && request.getUpdatedBy()!=0)
			charges.setUpdatedBy(request.getUpdatedBy());
		if(request.getUpdatedDate()!=null)
			charges.setUpdatedDate(request.getUpdatedDate());
		return charges;
	}

	public static LineChargesResponse convertLineChargesToResponse(LineCharges model) {
		LineChargesResponse response = new LineChargesResponse();
		response.setLineChargeId(model.getLineChargeId());
		response.setAgreementId(model.getAgreementId());
		response.setAgreementLineId(model.getAgreementLineId());
		response.setCharge(model.getCharge());
		response.setChargeAmount(model.getChargeAmount());
		response.setCostOnDate(model.getCostOnDate());
		response.setCreatedBy(model.getCreatedBy());
		response.setCreatedDate(model.getCreatedDate());
		response.setItem(model.getItem());
		response.setOnSite(model.getOnSite());
		response.setOrganizationId(model.getOrganizationId());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		response.setStatus(model.getStatus());
		return response;
	}
}
