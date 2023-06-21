package com.travel.travtronics.response;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.travel.travtronics.enums.Status;

public class ServiceTypesHeaderResponse {

	private Long id;

	private Long createdBy;

	private String createdDate = LocalDateTime.now().toString();

	private Long updatedBy;

	private String updatedDate = LocalDateTime.now().toString();

	private String organizationId;

	private String departmentId;

	private String serviceTypeGroup;

	private String name;

	private Long desktopEnabled;

	private Long mobileEnabled;

	private Long isDynamicForm;

	private String formUrl;

	@Enumerated(EnumType.STRING)
	private Status status;

	private String description;

	private String preValidations;

	private String instructions;

	private Boolean isProcess;

	private Boolean isParent;

	private Long serviceClass;

	private Long serviceCategory;

	private Long serviceType;

	private Boolean isStage;

	@JsonRawValue
	private String stages;

	private String serviceTypeIconClass;

	private Boolean isPricing;

	private Long receiptConfirmTemplate;
	
	private String departmentName;
	private String className;
	private String TypeName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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
	public String getServiceTypeIconClass() {
		return serviceTypeIconClass;
	}
	public void setServiceTypeIconClass(String serviceTypeIconClass) {
		this.serviceTypeIconClass = serviceTypeIconClass;
	}
	public Boolean getIsPricing() {
		return isPricing;
	}
	public void setIsPricing(Boolean isPricing) {
		this.isPricing = isPricing;
	}
	public Long getReceiptConfirmTemplate() {
		return receiptConfirmTemplate;
	}
	public void setReceiptConfirmTemplate(Long receiptConfirmTemplate) {
		this.receiptConfirmTemplate = receiptConfirmTemplate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	
	
}
