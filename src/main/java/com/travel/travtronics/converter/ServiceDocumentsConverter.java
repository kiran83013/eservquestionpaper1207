package com.travel.travtronics.converter;

import com.travel.travtronics.model.ServiceDocuments;
import com.travel.travtronics.request.ServiceDocumentsRequest;

public class ServiceDocumentsConverter {
	
	public static ServiceDocuments convertDocumentsToModel(ServiceDocumentsRequest request) {
		
		ServiceDocuments service = new ServiceDocuments();
		
		if(request.getId()!=null&&request.getId()!=0) 
			service.setId(request.getId());
		
		if(request.getName()!=null && !request.getName().isEmpty())
			service.setName(request.getName());
		
		if(request.getDescription()!=null && !request.getDescription().isEmpty())
			service.setDescription(request.getDescription());
		
		if(request.getLanguage()!=null && !request.getLanguage().isEmpty())
			service.setLanguage(request.getLanguage());
		
		if(request.getUrl()!=null && !request.getUrl().isEmpty())
			service.setUrl(request.getUrl());
		
		if(request.getHeaderId()!=null && request.getHeaderId()!=0)
			service.setHeaderId(request.getHeaderId());
		
		if(request.getOrganizationId()!=null && request.getOrganizationId()!=0)
			service.setOrganizationId(request.getOrganizationId());
		
		if(request.getCreatedBy()!=null)
			service.setCreatedBy(request.getCreatedBy());
		
		if(request.getUpdatedBy()!=null)
			service.setUpdatedBy(request.getUpdatedBy());
		
		if(request.getCreatedDate()!=null)
			service.setCreatedDate(request.getCreatedDate());
		
		if(request.getUpdatedDate()!=null)
			service.setUpdatedDate(request.getUpdatedDate());
		
		if(request.getStatus()!=null)
			service.setStatus(request.getStatus());
		
		return service;
		
	}
}
