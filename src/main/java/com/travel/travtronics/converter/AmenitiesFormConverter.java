package com.travel.travtronics.converter;

import com.travel.travtronics.model.AmenitiesForm;
import com.travel.travtronics.response.AmenitiesFormResponse;

public class AmenitiesFormConverter {

	public static AmenitiesFormResponse convertAmenitiesModelToResponse(AmenitiesForm model) {
		AmenitiesFormResponse response = new AmenitiesFormResponse();
		response.setAmenitiesFormId(model.getAmenitiesFormId());
		response.setCategoryId(model.getCategoryId());
		response.setCreatedBy(model.getCreatedBy());
		response.setCreatedDate(model.getCreatedDate());
		response.setDescription(model.getDescription());
		response.setName(model.getName());
		response.setStatus(model.getStatus());
		response.setOrganizationId(model.getOrganizationId());
		response.setTypeId(model.getTypeId());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		return response;
	}

}
