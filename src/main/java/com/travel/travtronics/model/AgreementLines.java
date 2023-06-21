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
@Table(name = "agreement_lines")
public class AgreementLines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Agreement_Line_Id")
	private Long agreementLineId;
	
	@Column(name = "Agreement_Id")
	private Long agreementId;
	
	@Column(name = "Service_Agreement_Line")
	private String serviceAgreementLine;
	
	@Column(name = "Line_Name")
	private String lineName;
	
	@Column(name = "Metered_Min")
	private Long meteredMin;
	
	@Column(name = "Metered_Max")
	private Long meteredMax;
	
	@Column(name = "Srtype_Id")
	private Long srtype;
	
	@Column(name = "Days_Min")
	private Long daysMin;
	
	@Column(name = "Days_Max")
	private Long daysMax;
	
	@Column(name = "On_Site")
	private Boolean onSite;
	
	@Column(name = "Category")
	private String category;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "Organization_Id")
	private Long organizationId;
	
	@Column(name = "Created_By", updatable = false)
	private Long createdBy;

	@Column(name = "Updated_By")
	private Long updatedBy;
	
	@Column(name = "Updated_Date")
	private Date updatedDate;

	@Column(name = "Created_Date", updatable = false)
	private Date createdDate;
	
	@Column(name="Status")
	@Enumerated(EnumType.STRING)
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

	public Long getSrtype() {
		return srtype;
	}

	public void setSrtype(Long srtype) {
		this.srtype = srtype;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
