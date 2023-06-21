package com.travel.travtronics.converter;

import com.travel.travtronics.model.FieldProcessHeader;
import com.travel.travtronics.response.FieldProcessHeaderResponse;

public class FieldProcessHeaderConverter {

	public static FieldProcessHeaderResponse convertFieldProcessHeaderModelToResponse(FieldProcessHeader model) {
		FieldProcessHeaderResponse process = new FieldProcessHeaderResponse();
		process.setCategory(model.getCategory());
		process.setCreatedBy(model.getCreatedBy());
		process.setCreatedDate(model.getCreatedDate());
		process.setDepartment(model.getDepartment());
		process.setDescription(model.getDescription());
		process.setOrganizationId(model.getOrganizationId());
		process.setOwner(model.getOwner());
		process.setPrcId(model.getPrcId());
		process.setProcessName(model.getProcessName());
		process.setSrTypeId(model.getSrTypeId());
		process.setStatus(model.getStatus());
		process.setTeam(model.getTeam());
		process.setType(model.getType());
		process.setUpdatedBy(model.getUpdatedBy());
		process.setUpdatedDate(model.getUpdatedDate());
		process.setWfstatus(model.getWfstatus());
		return process;
	}

}
