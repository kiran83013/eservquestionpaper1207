package com.travel.travtronics.converter;

import com.travel.travtronics.model.CustomerSegments;
import com.travel.travtronics.request.CustomerSegmentsRequest;

public class CustomerSegmentsRequestConverter {

	public static CustomerSegmentsRequest convertCustomerActivitiyModelToRequest(CustomerSegments model) {
		CustomerSegmentsRequest request = new CustomerSegmentsRequest();
		request.setId(model.getId());
		request.setCreatedBy(model.getCreatedBy());
		request.setCreatedDate(model.getCreatedDate());
		request.setUpdatedBy(model.getUpdatedBy());
		request.setUpdatedDate(model.getUpdatedDate());
		request.setEndDate(model.getEndDate());
		request.setStartDate(model.getStartDate());
		request.setLanguage(model.getLanguage());
		request.setOrganizationId(model.getOrganizationId());
		request.setDescription(model.getDescription());
		request.setStatus(model.getStatus());
		request.setSegmentName(model.getSegmentName());
		return request;
	}
}
