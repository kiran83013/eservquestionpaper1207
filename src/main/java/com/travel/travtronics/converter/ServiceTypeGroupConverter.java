package com.travel.travtronics.converter;

import com.travel.travtronics.model.ServiceTypeGroup;
import com.travel.travtronics.response.ServiceTypeGroupResponse;

public class ServiceTypeGroupConverter {
	
public static ServiceTypeGroupResponse convertServiceTypeGroupModelToResponse(ServiceTypeGroup model) {
	
	ServiceTypeGroupResponse response =new ServiceTypeGroupResponse();
	
	response.setCreatedBy(model.getCreatedBy());
	response.setCreatedDate(model.getCreatedDate());
	response.setDepartment(model.getDepartment());
	response.setDescription(model.getDescription());
	response.setId(model.getId());
	response.setName(model.getName());
	response.setOrganizationId(model.getOrganizationId());
	response.setStatus(model.getStatus());
	response.setUpdatedBy(model.getUpdatedBy());
	response.setUpdatedDate(model.getUpdatedDate());
	return response;
}
}
