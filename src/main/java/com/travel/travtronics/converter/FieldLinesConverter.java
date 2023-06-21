package com.travel.travtronics.converter;

import com.travel.travtronics.model.FieldLines;
import com.travel.travtronics.request.FieldLinesRequest;

public class FieldLinesConverter {
	
	public static FieldLines convertFieldLinesToModel(FieldLinesRequest request) {
		FieldLines lines = new FieldLines();
		if(request.getLineId()!= null && request.getLineId()!=0)
			lines.setLineId(request.getLineId());
		if(request.getDescription() != null && !request.getDescription().isEmpty())
			lines.setDescription(request.getDescription());
		if(request.getStageName()!=null && !request.getStageName().isEmpty())
			lines.setStageName(request.getStageName());
		if(request.getOrganizationId()!=null && request.getOrganizationId()!=0)
			lines.setOrganizationId(request.getOrganizationId());
		if(request.getParentSrType()!=null && request.getParentSrType()!=0)
			lines.setParentSrType(request.getParentSrType());
		if(request.getPrcId()!=null && request.getPrcId()!=0)
			lines.setPrcId(request.getPrcId());
		if(request.getSeqNo()!=null && request.getSeqNo()!=0)
			lines.setSeqNo(request.getSeqNo());
		if(request.getSrType()!=null && request.getSrType()!=0)
			lines.setSrType(request.getSrType());
		if(request.getDepartment()!=null && request.getDepartment()!=0)
			lines.setDepartment(request.getDepartment());
		if(request.getCreatedBy()!=null && request.getCreatedBy()!=0)
			lines.setCreatedBy(request.getCreatedBy());
		if(request.getCreatedDate()!=null)
			lines.setCreatedDate(request.getCreatedDate());
		if(request.getUpdatedBy()!=null && request.getUpdatedBy()!=0)
			lines.setUpdatedBy(request.getUpdatedBy());
		if(request.getUpdatedDate()!=null)
			lines.setUpdatedDate(request.getUpdatedDate());
		if(request.getStatus()!=null)
			lines.setStatus(request.getStatus());
		return lines;
		
	}
}
