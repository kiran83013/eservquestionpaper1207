package com.travel.travtronics.converter;

import com.travel.travtronics.model.ServiceContractToItem;
import com.travel.travtronics.response.ServiceContractToItemResponse;

public class ServiceContractToItemConverter {

	public static ServiceContractToItemResponse convertServiceContractToItemModelToResponse(ServiceContractToItem model) {
		ServiceContractToItemResponse response = new ServiceContractToItemResponse();
		response.setAgreement(model.getAgreement());
		response.setBusinessUnit(model.getBusinessUnit());
		response.setCostCenter(model.getCostCenter());
		response.setCreatedBy(model.getCreatedBy());
		response.setCreatedDate(model.getCreatedDate());
		response.setId(model.getId());
		response.setItem(model.getItem());
		response.setLocality(model.getLocality());
		response.setOrganization(model.getOrganization());
		response.setRecordStatus(model.getRecordStatus());
		response.setTerritory(model.getTerritory());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		response.setValidFrom(model.getValidFrom());
		response.setValidTo(model.getValidTo());
		response.setWfstatus(model.getWfstatus());
		return response;
	}

}
