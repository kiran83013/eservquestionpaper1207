package com.travel.travtronics.response;

import java.util.Date;

public class WarrantyExclusionResponse {

	private Long id;

	private Long agreementId;

	private String item;

	private Long wDays;

	private String wMeter;

	private Long parts;

	private Long partsAmount;

	private Long labor;

	private Long laborAmount;

	private Boolean costAsOnDate;

	private Boolean replaces;
	
	private String notes;

	private Long organizationId;

	private Long createdBy;

	private Long updatedBy;

	private Date updatedDate;

	private Date createdDate;

	private String agreementName;

	private String itemName;

	private String organizationName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getwDays() {
		return wDays;
	}

	public void setwDays(Long wDays) {
		this.wDays = wDays;
	}

	public String getwMeter() {
		return wMeter;
	}

	public void setwMeter(String wMeter) {
		this.wMeter = wMeter;
	}

	public Long getParts() {
		return parts;
	}

	public void setParts(Long parts) {
		this.parts = parts;
	}

	public Long getPartsAmount() {
		return partsAmount;
	}

	public void setPartsAmount(Long partsAmount) {
		this.partsAmount = partsAmount;
	}

	public Long getLabor() {
		return labor;
	}

	public void setLabor(Long labor) {
		this.labor = labor;
	}

	public Long getLaborAmount() {
		return laborAmount;
	}

	public void setLaborAmount(Long laborAmount) {
		this.laborAmount = laborAmount;
	}

	public Boolean getCostAsOnDate() {
		return costAsOnDate;
	}

	public void setCostAsOnDate(Boolean costAsOnDate) {
		this.costAsOnDate = costAsOnDate;
	}

	public Boolean getReplaces() {
		return replaces;
	}

	public void setReplaces(Boolean replaces) {
		this.replaces = replaces;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
