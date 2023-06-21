package com.travel.travtronics.converter;

import com.travel.travtronics.model.WarrantyExclusion;
import com.travel.travtronics.model.WarrantyInclusion;
import com.travel.travtronics.response.WarrantyExclusionResponse;
import com.travel.travtronics.response.WarrantyInclusionResponse;

public class WarrantyExclusionConverter {


	public static WarrantyExclusionResponse convertWarrantyExclusionToResponse(WarrantyExclusion model) {
		WarrantyExclusionResponse respones = new WarrantyExclusionResponse();
		respones.setAgreementId(model.getAgreementId());
		respones.setCostAsOnDate(model.getCostAsOnDate());
		respones.setCreatedBy(model.getCreatedBy());
		respones.setCreatedDate(model.getCreatedDate());
		respones.setId(model.getId());
		respones.setItem(model.getItem());
		respones.setLabor(model.getLabor());
		respones.setLaborAmount(model.getLaborAmount());
		respones.setOrganizationId(model.getOrganizationId());
		respones.setParts(model.getParts());
		respones.setPartsAmount(model.getPartsAmount());
		respones.setReplaces(model.getReplaces());
		respones.setUpdatedBy(model.getUpdatedBy());
		respones.setUpdatedDate(model.getUpdatedDate());
		respones.setwDays(model.getwDays());
		respones.setwMeter(model.getwMeter());
		respones.setNotes(model.getNotes());
		return respones;
	}

	public static WarrantyInclusionResponse convertWarrantyInclusionToResponse(WarrantyInclusion model) {
		WarrantyInclusionResponse  responses = new WarrantyInclusionResponse();
		responses.setAgreementId(model.getAgreementId());
		responses.setCostAsOnDate(model.getCostAsOnDate());
		responses.setCreatedBy(model.getCreatedBy());
		responses.setCreatedDate(model.getCreatedDate());
		responses.setId(model.getId());
		responses.setItem(model.getItem());
		responses.setLabor(model.getLabor());
		responses.setNotes(model.getNotes());
		responses.setLaborAmount(model.getLaborAmount());
		responses.setOrganizationId(model.getOrganizationId());
		responses.setParts(model.getParts());
		responses.setPartsAmount(model.getPartsAmount());
		responses.setReplaces(model.getReplaces());
		responses.setUpdatedBy(model.getUpdatedBy());
		responses.setUpdatedDate(model.getUpdatedDate());
		responses.setwDays(model.getwDays());
		responses.setwMeter(model.getwMeter());
		return responses;
	}

}
