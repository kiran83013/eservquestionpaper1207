package com.travel.travtronics.converter;

import com.travel.travtronics.model.CountryMaster;
import com.travel.travtronics.model.GenerateSetupMaster;
import com.travel.travtronics.request.CountryMasterRequest;
import com.travel.travtronics.request.GenerateSetupMasterRequest;

public class CountryMasterConverter {

	public static CountryMaster convertRequestToModel(CountryMasterRequest request) {

		CountryMaster cm = new CountryMaster();
		if (request.getId() != null && request.getId() != 0)
			cm.setId(request.getId());

		if (request.getOrganizationId() != null && request.getOrganizationId() != 0)
			cm.setOrganizationId(request.getOrganizationId());

		if (request.getName() != null && !request.getName().isEmpty())
			cm.setName(request.getName());

		if (request.getDescription() != null && !request.getDescription().isEmpty())
			cm.setDescription(request.getDescription());

		if (request.getCode() != null && !request.getCode().isEmpty())
			cm.setCode(request.getCode());

		if (request.getIso2() != null && !request.getIso2().isEmpty())
			cm.setIso2(request.getIso2());

		if (request.getIso3() != null && !request.getIso3().isEmpty())
			cm.setIso3(request.getIso3());

		if (request.getTimeZone() != null && !request.getTimeZone().isEmpty())
			cm.setTimeZone(request.getTimeZone());

		if (request.getCurrency() != null && !request.getCurrency().isEmpty())
			cm.setCurrency(request.getCurrency());

		if (request.getCreatedBy() != null)
			cm.setCreatedBy(request.getCreatedBy());

		if (request.getUpdatedBy() != null)
			cm.setUpdatedBy(request.getUpdatedBy());

		if (request.getCreatedDate() != null)
			cm.setCreatedDate(request.getCreatedDate());

		if (request.getUpdatedDate() != null)
			cm.setUpdatedDate(request.getUpdatedDate());

		if (request.getStatus() != null)
			cm.setStatus(request.getStatus());

		return cm;
	}

	public static GenerateSetupMaster convertGeneralSetUpRequestToModel(GenerateSetupMasterRequest model) {

		GenerateSetupMaster cm = new GenerateSetupMaster();
		if (model.getId() != null && model.getId() != 0)
			cm.setId(model.getId());

		if (model.getCategoryId() != null && model.getCategoryId() != 0)
			cm.setCategoryId(model.getCategoryId());

		if (model.getOrgId() != null && model.getOrgId() != 0)
			cm.setOrgId(model.getOrgId());

		if (model.getName() != null && !model.getName().isEmpty())
			cm.setName(model.getName());

		if (model.getDescription() != null && !model.getDescription().isEmpty())
			cm.setDescription(model.getDescription());

		if (model.getCode() != null && !model.getCode().isEmpty())
			cm.setCode(model.getCode());

		if (model.getCreatedBy() != null && model.getCreatedBy() != 0)
			cm.setCreatedBy(model.getCreatedBy());

		if (model.getUpdatedBy() != null)
			cm.setUpdatedBy(model.getUpdatedBy());

		if (model.getCreatedDate() != null)
			cm.setCreatedDate(model.getCreatedDate());

		if (model.getUpdatedDate() != null)
			cm.setUpdatedDate(model.getUpdatedDate());

		if (model.getStatus() != null)
			cm.setStatus(model.getStatus());

		return cm;
	}
}
