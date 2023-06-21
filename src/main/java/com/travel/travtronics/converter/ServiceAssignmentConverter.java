package com.travel.travtronics.converter;

import com.travel.travtronics.model.ServiceAssignment;
import com.travel.travtronics.request.ServiceAssignmentRequest;

public class ServiceAssignmentConverter {
	public static ServiceAssignment convertAssignmentToModel(ServiceAssignmentRequest request) {

		ServiceAssignment service = new ServiceAssignment();

		if (request.getId() != null && request.getId() != 0)
			service.setId(request.getId());

		if (request.getTeam() != null && request.getTeam() != 0)
			service.setTeam(request.getTeam());

		if (request.getOrganizationId() != null && request.getOrganizationId() != 0)
			service.setOrganizationId(request.getOrganizationId());

		if (request.getDefaultStatus() != null && request.getDefaultStatus() != 0)
			service.setDefaultStatus(request.getDefaultStatus());

		if (request.getHeaderId() != null && request.getHeaderId() != 0)
			service.setHeaderId(request.getHeaderId());

		if (request.getStartDate() != null)
			service.setStartDate(request.getStartDate());

		if (request.getEndDate() != null)
			service.setEndDate(request.getEndDate());

		if (request.getCreatedBy() != null)
			service.setCreatedBy(request.getCreatedBy());

		if (request.getUpdatedBy() != null)
			service.setUpdatedBy(request.getUpdatedBy());

//        if (request.getCreatedDate() != null)
//            service.setCreatedDate(request.getCreatedDate());
//
//        if (request.getUpdatedDate() != null)
//            service.setUpdatedDate(request.getUpdatedDate());

		if (request.getStatus() != null)
			service.setStatus(request.getStatus());
		return service;
	}
}
