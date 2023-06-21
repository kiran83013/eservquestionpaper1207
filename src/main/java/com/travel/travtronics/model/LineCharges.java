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

import com.travel.travtronics.enums.Status;

@Entity
@Table(name = "lines_charges")
public class LineCharges {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long lineChargeId;
	
	@Column(name = "Agreement_Line_Id")
	private Long agreementLineId;
	
	@Column(name = "Agreement_Id")
	private Long agreementId;
	
	@Column(name = "Item")
	private String item;
	
	@Column(name = "Charge")
	private String charge;
	
	@Column(name = "Charge_Amount")
	private Long chargeAmount;
	
	@Column(name = "Cost_On_Date")
	private Boolean costOnDate;
	
	@Column(name = "On_Site")
	private String onSite;
	
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

	public Long getLineChargeId() {
		return lineChargeId;
	}

	public void setLineChargeId(Long lineChargeId) {
		this.lineChargeId = lineChargeId;
	}

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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public Long getChargeAmount() {
		return chargeAmount;
	}

	public void setChargeAmount(Long chargeAmount) {
		this.chargeAmount = chargeAmount;
	}

	public Boolean getCostOnDate() {
		return costOnDate;
	}

	public void setCostOnDate(Boolean costOnDate) {
		this.costOnDate = costOnDate;
	}

	public String getOnSite() {
		return onSite;
	}

	public void setOnSite(String onSite) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
