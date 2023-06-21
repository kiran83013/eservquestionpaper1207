package com.travel.travtronics.response;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.travel.travtronics.enums.Status;


public class AgreementResponse {

	private Long agreementId;

	private String name;

	private String description;

	private String category;

	private String Type;

	private Long organizationId;

	private Date validFrom;

	private Date validTo;

	private Long wfstatus;
	
	@Enumerated(EnumType.STRING)
	private Status recordStatus;

	private Long createdBy;

	private Long updatedBy;

	private Date updatedDate;

	private Date createdDate;
	
	private String categoryName;
	private String organizationName;
	private String statusName;
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Long getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(Long agreementId) {
		this.agreementId = agreementId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Long getWfstatus() {
		return wfstatus;
	}

	public void setWfstatus(Long wfstatus) {
		this.wfstatus = wfstatus;
	}



	public Status getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Status recordStatus) {
		this.recordStatus = recordStatus;
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

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
