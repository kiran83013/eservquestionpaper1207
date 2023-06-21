package com.travel.travtronics.dto;


import javax.validation.constraints.NotNull;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;

public class PaginationFetchDto {
	
	private String organizationId;
	
	private String  departmentId;
	
	private String  parentId;
	
	private Status status;	
	
	private Long serviceClass; 	
	private Long serviceCategory; 	
	private Long serviceType; 	
	private Boolean isProcess; 	
	private Boolean isStage;
	private Boolean isPricing; 	
	private Long isDynamicForm; 	
	private String name;
	
	@NotNull
	private  int pageNo;
	
	@NotNull
	private int pageSize;
	
	private String  sortBy;
	
	
	private SortType sortType;

	

	public Long getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(Long serviceClass) {
		this.serviceClass = serviceClass;
	}

	public Long getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(Long serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public Long getServiceType() {
		return serviceType;
	}

	public void setServiceType(Long serviceType) {
		this.serviceType = serviceType;
	}

	public Boolean getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Boolean isProcess) {
		this.isProcess = isProcess;
	}

	public Boolean getIsStage() {
		return isStage;
	}

	public void setIsStage(Boolean isStage) {
		this.isStage = isStage;
	}

	public Boolean getIsPricing() {
		return isPricing;
	}

	public void setIsPricing(Boolean isPricing) {
		this.isPricing = isPricing;
	}

	public Long getIsDynamicForm() {
		return isDynamicForm;
	}

	public void setIsDynamicForm(Long isDynamicForm) {
		this.isDynamicForm = isDynamicForm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}

	
	
	

}
