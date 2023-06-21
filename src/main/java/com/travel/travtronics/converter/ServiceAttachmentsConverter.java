package com.travel.travtronics.converter;

import com.travel.travtronics.model.ServiceAttachments;
import com.travel.travtronics.request.ServiceAttachmentsRequest;

public class ServiceAttachmentsConverter {

//	public static Collection<ServiceAttachmentsFetchModel> convertServiceTypeModelToJson(List<ServiceAttachmentsResponse> getAll) {
//		return getAll.stream().map(model -> {
//			ServiceAttachmentsFetchModel dto = new ServiceAttachmentsFetchModel();
//			
//			dto.setAttachmentsId(model.getAttachmentsId());
//			dto.setName(model.getName());
//			dto.setDescription(model.getDescription());
//			dto.setLanguage(model.getLanguage());
//			dto.setAllowedExtensions(model.getAllowedExtensions());
//			dto.setMandatory(model.getMandatory());
//			dto.setConditional(model.getConditional());
//			dto.setField(model.getField());
//			dto.setOperator(model.getOperator());
//			dto.setValue(model.getValue());
//			dto.setHeaderId(model.getHeaderId());
//			dto.setCreatedBy(model.getCreatedBy());
//			dto.setUpdatedBy(model.getUpdatedBy());
//			dto.setCreatedDate(model.getCreatedDate());
//			dto.setUpdatedDate(model.getUpdatedDate());
//			dto.setStatus(model.getStatus());
//			return dto;
//		}).collect(Collectors.toList());
//	}
	public static ServiceAttachments convertAttachmentsToModel(ServiceAttachmentsRequest request) {

		ServiceAttachments service = new ServiceAttachments();
		if (request.getAttachmentsId() != null && request.getAttachmentsId() != 0)
			service.setAttachmentsId(request.getAttachmentsId());
		
		if(request.getOrganizationId() != null && request.getOrganizationId() !=0)
			service.setOrganizationId(request.getOrganizationId());

		if (request.getName() != null && !request.getName().isEmpty())
			service.setName(request.getName());

		if (request.getDescription() != null && !request.getDescription().isEmpty())
			service.setDescription(request.getDescription());

		if (request.getLanguage() != null && !request.getLanguage().isEmpty())
			service.setLanguage(request.getLanguage());

		if (request.getAllowedExtensions() != null && request.getAllowedExtensions() != 0)
			service.setAllowedExtensions(request.getAllowedExtensions());

		if (request.getMandatory() != null)
			service.setMandatory(request.getMandatory());

		if (request.getConditional() != null)
			service.setConditional(request.getConditional());

		if (request.getField() != null && request.getField() != 0)
			service.setField(request.getField());

		if (request.getOperator() != null && !request.getOperator().isEmpty())
			service.setOperator(request.getOperator());

		if (request.getValue() != null && !request.getValue().isEmpty())
			service.setValue(request.getValue());

		if (request.getHeaderId() != null && request.getHeaderId() != 0)
			service.setHeaderId(request.getHeaderId());

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
