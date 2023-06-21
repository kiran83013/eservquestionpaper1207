package com.travel.travtronics.response;

import com.travel.travtronics.model.ServiceTypesHeader;

public class ServiceHeaderResponse extends ServiceTypesHeader {

	private String organizationName;

	private String departmentName;

	private String serviceTypeGroupName;

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getServiceTypeGroupName() {
		return serviceTypeGroupName;
	}

	public void setServiceTypeGroupName(String serviceTypeGroupName) {
		this.serviceTypeGroupName = serviceTypeGroupName;
	}

}
