package com.travel.travtronics.request;

import java.util.Date;

import com.travel.travtronics.enums.Status;

public class ServiceAttachmentsRequest {

	private Long attachmentsId;

	private String name;

	private String description;

	private Long organizationId;

	private String language;

	private Long allowedExtensions;

	private Boolean mandatory;

	private Boolean conditional;

	private Long field;

	private String operator;

	private String value;

	private Long headerId;

	private String createdBy;

	private String updatedBy;

	private Date createdDate;

	private Date updatedDate;

	private Status status;

	public Long getAttachmentsId() {
		return attachmentsId;
	}

	public void setAttachmentsId(Long attachmentsId) {
		this.attachmentsId = attachmentsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getAllowedExtensions() {
		return allowedExtensions;
	}

	public void setAllowedExtensions(Long allowedExtensions) {
		this.allowedExtensions = allowedExtensions;
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}

	public Boolean getConditional() {
		return conditional;
	}

	public void setConditional(Boolean conditional) {
		this.conditional = conditional;
	}

	public Long getField() {
		return field;
	}

	public void setField(Long field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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

}
