package com.travel.travtronics.converter;

import com.travel.travtronics.model.CustomerSubActivity;
import com.travel.travtronics.request.CustomerSubActivityRequest;

public class CustomerSubActivitiyConverter {

	public static CustomerSubActivity convertSubActivityToModel(CustomerSubActivityRequest request) {

		CustomerSubActivity service = new CustomerSubActivity();

		if (request.getId() != null && request.getId() != 0)
			service.setId(request.getId());
		
		if(request.getOrganizationId()!=null && request.getOrganizationId()!=0)
			service.setOrganizationId(request.getOrganizationId());

		if (request.getActivityId() != null && request.getActivityId() != 0)
			service.setActivityId(request.getActivityId());

		if (request.getSubActivityName() != null && !request.getSubActivityName().isEmpty())
			service.setSubActivityName(request.getSubActivityName());

		if (request.getDescription() != null && !request.getDescription().isEmpty())
			service.setDescription(request.getDescription());

		if (request.getLanguage() != null && request.getLanguage() != 0)
			service.setLanguage(request.getLanguage());

		if (request.getStartDate() != null)
			service.setStartDate(request.getStartDate());

		if (request.getEndDate() != null)
			service.setEndDate(request.getEndDate());

		if (request.getCreatedBy() != null)
			service.setCreatedBy(request.getCreatedBy());

		if (request.getUpdatedBy() != null)
			service.setUpdatedBy(request.getUpdatedBy());

		if (request.getCreatedDate() != null)
			service.setCreatedDate(request.getCreatedDate());

		if (request.getUpdatedDate() != null)
			service.setUpdatedDate(request.getUpdatedDate());

		if (request.getStatus() != null)
			service.setStatus(request.getStatus());

		return service;
	}
	
	public static CustomerSubActivityRequest convertCustomerSubActivitiyModelToRequest(CustomerSubActivity model) {
		CustomerSubActivityRequest request = new CustomerSubActivityRequest();
		request.setId(model.getId());
		request.setDescription(model.getDescription());;
		request.setLanguage(model.getLanguage());
		request.setActivityId(model.getActivityId());
		request.setCreatedBy(model.getCreatedBy());
		request.setCreatedDate(model.getCreatedDate());
		request.setUpdatedBy(model.getUpdatedBy());
		request.setUpdatedDate(model.getUpdatedDate());
		request.setSubActivityName(model.getSubActivityName());
		request.setOrganizationId(model.getOrganizationId());
		request.setStartDate(model.getStartDate());
		request.setEndDate(model.getEndDate());
		request.setStatus(model.getStatus());
		return request;
	}
}
