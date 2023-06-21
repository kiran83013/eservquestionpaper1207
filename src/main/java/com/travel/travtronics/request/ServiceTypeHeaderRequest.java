package com.travel.travtronics.request;

import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
public class ServiceTypeHeaderRequest {

	private Long createdBy;

	private Long updatedBy;

	private String organizationId;

	private String departmentId;

	private String serviceTypeGroup;

	private String name;

	private Long desktopEnabled;

	private Long mobileEnabled;

	private Long isDynamicForm;

	private String formUrl;

	private Boolean isProcess;

	private Boolean isParent;

	private Long serviceClass;

	private Long serviceCategory;

	private Long serviceType;

	private Boolean isStage;

	private String stages;
	
	private String serviceTypeIconClass;

	private Boolean isPricing;

	private Long receiptConfirmTemplate;

	public Boolean getIsStage() {
		return isStage;
	}

	public void setIsStage(Boolean isStage) {
		this.isStage = isStage;
	}

	public String getStages() {
		return stages;
	}

	public void setStages(String stages) {
		this.stages = stages;
	}

	public Boolean getIsProcess() {
		return isProcess;
	}

	public void setIsProcess(Boolean isProcess) {
		this.isProcess = isProcess;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Long getDesktopEnabled() {
		return desktopEnabled;
	}

	public void setDesktopEnabled(Long desktopEnabled) {
		this.desktopEnabled = desktopEnabled;
	}

	public Long getMobileEnabled() {
		return mobileEnabled;
	}

	public void setMobileEnabled(Long mobileEnabled) {
		this.mobileEnabled = mobileEnabled;
	}

	public Long getIsDynamicForm() {
		return isDynamicForm;
	}

	public void setIsDynamicForm(Long isDynamicForm) {
		this.isDynamicForm = isDynamicForm;
	}

	public String getFormUrl() {
		return formUrl;
	}

	public void setFormUrl(String formUrl) {
		this.formUrl = formUrl;
	}

	private Status status;

	private String description;

	private String preValidations;

	private String instructions;

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
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

	public String getServiceTypeGroup() {
		return serviceTypeGroup;
	}

	public void setServiceTypeGroup(String serviceTypeGroup) {
		this.serviceTypeGroup = serviceTypeGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPreValidations() {
		return preValidations;
	}

	public void setPreValidations(String preValidations) {
		this.preValidations = preValidations;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

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

}
