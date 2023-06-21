package com.travel.travtronics.converter;

import com.travel.travtronics.model.CustomerActivity;
import com.travel.travtronics.request.CustomerActivitiyRequest;

public class CustomerActivitiyConverter {

	public static CustomerActivity convertActivityToModel(CustomerActivitiyRequest request) {
		CustomerActivity service = new CustomerActivity();

		if (request.getId() != null && request.getId() != 0)
			service.setId(request.getId());
		
		if(request.getOrganizationId()!=null && request.getOrganizationId()!=0)
			service.setOrganizationId(request.getOrganizationId());
		
		if (request.getSegmentId() != null && request.getSegmentId() != 0)
			service.setSegmentId(request.getSegmentId());

		if (request.getActivityName() != null && !request.getActivityName().isEmpty())
			service.setActivityName(request.getActivityName());

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
	
	public static CustomerActivitiyRequest  convertCustomerActivitiyModelToRequest(CustomerActivity model) {
		CustomerActivitiyRequest request = new CustomerActivitiyRequest();
		request.setId(model.getId());
		request.setCreatedBy(model.getCreatedBy());
		request.setCreatedDate(model.getCreatedDate());
		request.setDescription(model.getDescription());
		request.setActivityName(model.getActivityName());
		request.setEndDate(model.getEndDate());
		request.setStartDate(model.getStartDate());
		request.setLanguage(model.getLanguage());
		request.setSegmentId(model.getSegmentId());
		request.setUpdatedBy(model.getUpdatedBy());
		request.setUpdatedDate(model.getUpdatedDate());
		request.setOrganizationId(model.getOrganizationId());
		request.setStatus(model.getStatus());
		return request;
	}
}
