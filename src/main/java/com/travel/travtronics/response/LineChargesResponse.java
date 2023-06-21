package com.travel.travtronics.response;

import java.util.Date;

import com.travel.travtronics.enums.Status;

public class LineChargesResponse {

	private Long lineChargeId;

	private Long agreementLineId;

	private Long agreementId;

	private String item;

	private String charge;

	private Long chargeAmount;

	private Boolean costOnDate;

	private String onSite;

	private Long organizationId;

	private Long createdBy;

	private Long updatedBy;

	private Date updatedDate;

	private Date createdDate;

	private String agreementLineName;

	private String agreementName;

	private String itemName;

	private String organizationName;
	
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

	public String getAgreementLineName() {
		return agreementLineName;
	}

	public void setAgreementLineName(String agreementLineName) {
		this.agreementLineName = agreementLineName;
	}

	public String getAgreementName() {
		return agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
}
