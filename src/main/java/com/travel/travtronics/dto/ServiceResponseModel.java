package com.travel.travtronics.dto;

import java.util.List;

import com.travel.travtronics.model.ServiceTypesHeader;

public class ServiceResponseModel {
	
	private ServiceTypesHeader serviceTypesHeader;
	
	private List<ServiceTypeLinesFetchModel> serviceTypesLines;

	public ServiceTypesHeader getServiceTypesHeader() {
		return serviceTypesHeader;
	}

	public void setServiceTypesHeader(ServiceTypesHeader serviceTypesHeader) {
		this.serviceTypesHeader = serviceTypesHeader;
	}

	public List<ServiceTypeLinesFetchModel> getServiceTypesLines() {
		return serviceTypesLines;
	}

	public void setServiceTypesLines(List<ServiceTypeLinesFetchModel> serviceTypesLines) {
		this.serviceTypesLines = serviceTypesLines;
	}
	
	

}
