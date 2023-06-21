package com.travel.travtronics.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InputTypeConfigResponse {

	private Integer configId;

	private String name;

	@JsonProperty("typeId")
	private Integer type;

	private Long organizationId;

	@JsonRawValue
	private String source;

	@JsonRawValue
	private String ui;

	@JsonRawValue
	private String validators;

	private Integer createdBy;

	private Integer updatedBy;

	private String updatedDate;

	private String createdDate;

	private Status status;

	private String category;

	private Boolean multiselect;

	private Boolean defaultType;

	private Long serviceId;

	private String dafaultValue;

	private Boolean oce;

	private String dependentField;

	private String options;

	private String typeName;

	public Integer getConfigId() {
		return configId;
	}

	public void setConfigId(Integer configId) {
		this.configId = configId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUi() {
		return ui;
	}

	public void setUi(String ui) {
		this.ui = ui;
	}

	public String getValidators() {
		return validators;
	}

	public void setValidators(String validators) {
		this.validators = validators;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getMultiselect() {
		return multiselect;
	}

	public void setMultiselect(Boolean multiselect) {
		this.multiselect = multiselect;
	}

	public Boolean getDefaultType() {
		return defaultType;
	}

	public void setDefaultType(Boolean defaultType) {
		this.defaultType = defaultType;
	}

	public String getDafaultValue() {
		return dafaultValue;
	}

	public void setDafaultValue(String dafaultValue) {
		this.dafaultValue = dafaultValue;
	}

	public Boolean getOce() {
		return oce;
	}

	public void setOce(Boolean oce) {
		this.oce = oce;
	}

	public String getDependentField() {
		return dependentField;
	}

	public void setDependentField(String dependentField) {
		this.dependentField = dependentField;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
