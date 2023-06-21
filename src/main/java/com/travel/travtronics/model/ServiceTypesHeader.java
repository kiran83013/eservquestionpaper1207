package com.travel.travtronics.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.travel.travtronics.dto.ServiceTypeHeaderResponse;
import com.travel.travtronics.enums.Query;
import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "service_types_header")
@SqlResultSetMapping(name = "service_type_mapping", classes = @ConstructorResult(targetClass = ServiceTypeHeaderResponse.class, columns = {
		@ColumnResult(name = "ID", type = Long.class), @ColumnResult(name = "CreatedBy", type = Long.class),@ColumnResult(name = "CreatedDate", type = String.class),
		@ColumnResult(name = "UpdatedBy", type = Long.class), @ColumnResult(name = "UpdatedDate", type = String.class),@ColumnResult(name = "OrganizationId", type = String.class),
		@ColumnResult(name = "DepartmentId", type = String.class),@ColumnResult(name = "ServiceTypeGroup", type = String.class),@ColumnResult(name = "Name", type = String.class),
		@ColumnResult(name = "DesktopEnabled", type = Long.class),@ColumnResult(name = "MobileEnabled", type = Long.class),@ColumnResult(name = "IsDynamicForm", type = Long.class),
		@ColumnResult(name = "FormUrl", type = String.class),@ColumnResult(name = "Status", type = String.class),@ColumnResult(name = "Description", type = String.class),
		@ColumnResult(name = "PreValidations", type = String.class),@ColumnResult(name = "Instructions", type = String.class),@ColumnResult(name = "IsProcess", type = Boolean.class),
		@ColumnResult(name = "IsParent", type = Boolean.class),@ColumnResult(name = "ServiceClass", type = Long.class),@ColumnResult(name = "ServiceCategory", type = Long.class),
		@ColumnResult(name = "ServiceType", type = Long.class),@ColumnResult(name = "is_stage", type = Boolean.class),@ColumnResult(name = "stages", type = String.class),
		@ColumnResult(name = "ServiceTypeIconClass", type = String.class),@ColumnResult(name = "Is_Pricing", type = Boolean.class),@ColumnResult(name = "Receipt_Confirm_Template", type = Long.class),
		@ColumnResult(name = "service_type_details", type = String.class)}))
@NamedNativeQuery(name = "ServiceTypesHeader.findByServiceTypeId", resultClass = ServiceTypeHeaderResponse.class, resultSetMapping = "service_type_mapping", query = Query.GET_SERVICE_TYPE_INFO_DETAILS)
public class ServiceTypesHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "CreatedBy", updatable = false)
	private Long createdBy;

	@Column(name = "CreatedDate", updatable = false)
	private String createdDate = LocalDateTime.now().toString();

	@Column(name = "UpdatedBy")
	private Long updatedBy;

	@Column(name = "UpdatedDate")
	private String updatedDate = LocalDateTime.now().toString();

	@Column(name = "OrganizationId")
	private String organizationId;

	@Column(name = "DepartmentId")
	private String departmentId;

	@Column(name = "ServiceTypeGroup")
	private String serviceTypeGroup;

	@Column(name = "name")
	private String name;

	@Column(name = "DesktopEnabled")
	private Long desktopEnabled;

	@Column(name = "MobileEnabled")
	private Long mobileEnabled;

	@Column(name = "IsDynamicForm")
	private Long isDynamicForm;

	@Column(name = "FormUrl")
	private String formUrl;

	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private Status status;

	@Column(name = "Description", columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "PreValidations", columnDefinition = "LONGTEXT")
	private String preValidations;

	@Column(name = "Instructions", columnDefinition = "LONGTEXT")
	private String instructions;

	@Column(name = "IsProcess")
	private Boolean isProcess;

	@Column(name = "IsParent")
	private Boolean isParent;

	@Column(name = "ServiceClass")
	private Long serviceClass;

	@Column(name = "ServiceCategory")
	private Long serviceCategory;

	@Column(name = "ServiceType")
	private Long serviceType;

	@Column(name = "is_stage")
	private Boolean isStage;

	@JsonRawValue
	@Column(name = "stages")
	private String stages;

	@Column(name = "ServiceTypeIconClass")
	private String serviceTypeIconClass;

	@Column(name = "Is_Pricing")
	private Boolean isPricing;

	@Column(name = "Receipt_Confirm_Template", columnDefinition = "LONGTEXT")
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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