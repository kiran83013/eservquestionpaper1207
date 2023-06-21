package com.travel.travtronics.converter;

import com.travel.travtronics.model.CustomerSegments;
import com.travel.travtronics.request.CustomerSegmentsRequest;

public class ServiceSegmentsConverter {

	public static CustomerSegments convertSegmentsToModel(CustomerSegmentsRequest request) {
		CustomerSegments service = new CustomerSegments();

		if (request.getId() != null && request.getId() != 0)
			service.setId(request.getId());
		
		if(request.getOrganizationId()!=null && request.getOrganizationId()!=0)
			service.setOrganizationId(request.getOrganizationId());

		if (request.getSegmentName() != null && !request.getSegmentName().isEmpty())
			service.setSegmentName(request.getSegmentName());

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
}
