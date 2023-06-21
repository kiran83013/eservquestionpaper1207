package com.travel.travtronics.converter;

import com.travel.travtronics.model.CostCenter;
import com.travel.travtronics.response.CostCenterResponse;

public class CostCenterConverter {

	public static CostCenterResponse convertCostCenterModelToResponse(CostCenter model) {
		CostCenterResponse	response = new CostCenterResponse();
		response.setCostCenterId(model.getCostCenterId());
		response.setOrganizationId(model.getOrganizationId());
		response.setBusinessUnitId(model.getBusinessUnitId());
		response.setCode(model.getCode());
		response.setName(model.getName());
		response.setDescription(model.getDescription());
		response.setAccCode(model.getAccCode());
		response.setStartDate(model.getStartDate());
		response.setEndDate(model.getEndDate());
		response.setStatus(model.getStatus());
		response.setAttr1(model.getAttr1());
		response.setAttr2(model.getAttr2());
		response.setAttr3(model.getAttr3());
		response.setAttr4(model.getAttr4());
		response.setAttr5(model.getAttr5());
		response.setAttr6(model.getAttr6());
		response.setAttr7(model.getAttr7());
		response.setAttr8(model.getAttr8());
		response.setAttr9(model.getAttr9());
		response.setAttr10(model.getAttr10());
		response.setAttr11(model.getAttr11());
		response.setAttr12(model.getAttr12());
		response.setAttr13(model.getAttr13());
		response.setAttr14(model.getAttr14());
		response.setAttr15(model.getAttr15());
		response.setAttr16(model.getAttr16());
		response.setAttr17(model.getAttr17());
		response.setAttr18(model.getAttr18());		
		response.setAttr19(model.getAttr19());
		response.setAttr20(model.getAttr20());
		return response;
	}

}
