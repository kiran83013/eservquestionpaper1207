package com.travel.travtronics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.travel.travtronics.enums.Status;

@Entity
@Table(name = "service_attachments")
public class ServiceAttachments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AttachmentsId")
	private Long attachmentsId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description",columnDefinition = "LONGTEXT")
	private String description;
	
    @Column(name = "OrganizationId")
    private Long organizationId;
	
	@Column(name = "Language")
	private String language;
	
	@Column(name = "AllowedExtensions")
	private Long allowedExtensions;
	
	@Column(name = "Mandatory")
	private Boolean mandatory;
	
	@Column(name = "Conditional")
	private Boolean conditional;
	
	@Column(name = "Field")
	private Long field;
	
	@Column(name = "Operator")
	private String operator;
	
	@Column(name = "Value")
	private String value;
	
	@Column(name = "HeaderId")
	private Long headerId;
	
	@Column(name = "CreatedBy", updatable = false)
	private String createdBy;
	
	@Column(name = "UpdatedBy")
	private String updatedBy;
	
	@CreationTimestamp
	@Column(name = "CreatedDate", updatable = false)
	private Date createdDate;
	
	@UpdateTimestamp
	@Column(name = "UpdatedDate")
	private Date updatedDate;
	
	@Column(name="Status")
	@Enumerated(EnumType.STRING)
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
