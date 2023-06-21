package com.travel.travtronics.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
public class InputTypeConfigRequest {

	private Long organizationId;

	private String name;

	@JsonProperty("typeId")
	private Integer type;

	private String source;

	private String ui;

	private Integer createdBy;

	private Integer updatedBy;

	@JsonIgnore
	private String updatedDate;

	@JsonIgnore
	private String createdDate;

	private Status status;

	private String category;

	private String validators;

	private Boolean multiselect;

	@JsonProperty("default")
	private Boolean defaultType;

	private Long serviceId;

	@JsonProperty("defaultValue")
	private String dafaultValue;

	private Boolean oce;

	private String dependentField;

	private String options;

	private String typeName;

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

	public String getValidators() {
		return validators;
	}

	public void setValidators(String validators) {
		this.validators = validators;
	}

	public Boolean getMultiselect() {
		return multiselect;
	}

	public void setMultiselect(Boolean multiselect) {
		this.multiselect = multiselect;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
