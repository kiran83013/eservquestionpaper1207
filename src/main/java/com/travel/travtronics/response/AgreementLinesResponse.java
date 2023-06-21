package com.travel.travtronics.response;

import java.util.Date;

import com.travel.travtronics.enums.Status;

public class AgreementLinesResponse {

	private Long agreementLineId;

	private Long agreementId;

	private String serviceAgreementLine;

	private String lineName;

	private Long meteredMin;

	private Long meteredMax;

	private Long srtype;

	private Long daysMin;

	private Long daysMax;

	private Boolean onSite;

	private String category;

	private String type;

	private Long organizationId;

	private Long createdBy;

	private Long updatedBy;

	private Date updatedDate;

	private Date createdDate;

	private String categoryName;

	private String orgName;

	private String agreementName;

	private String srTypeName;
	
	private Status status;

	public Long getAgreementLineId() {
		return agreementLineId;
	}

	public void setAgreementLineId(Long agreementLineId) {
		this.agreementLineId = agreementLineId;
	}

	public Long getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(Long agreementId) {
		this.agreementId = agreementId;
	}

	public String getServiceAgreementLine() {
		return serviceAgreementLine;
	}

	public void setServiceAgreementLine(String serviceAgreementLine) {
		this.serviceAgreementLine = serviceAgreementLine;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public Long getMeteredMin() {
		return meteredMin;
	}

	public void setMeteredMin(Long meteredMin) {
		this.meteredMin = meteredMin;
	}

	public Long getMeteredMax() {
		return meteredMax;
	}

	public void setMeteredMax(Long meteredMax) {
		this.meteredMax = meteredMax;
	}

	public Long getSrtype() {
		return srtype;
	}

	public void setSrtype(Long srtype) {
		this.srtype = srtype;
	}

	public Long getDaysMin() {
		return daysMin;
	}

	public void setDaysMin(Long daysMin) {
		this.daysMin = daysMin;
	}

	public Long getDaysMax() {
		return daysMax;
	}

	public void setDaysMax(Long daysMax) {
		this.daysMax = daysMax;
	}

	public Boolean getOnSite() {
		return onSite;
	}

	public void setOnSite(Boolean onSite) {
		this.onSite = onSite;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAgreementName() {
		return agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	public String getSrTypeName() {
		return srTypeName;
	}

	public void setSrTypeName(String srTypeName) {
		this.srTypeName = srTypeName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
