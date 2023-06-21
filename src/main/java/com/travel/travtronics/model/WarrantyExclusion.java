package com.travel.travtronics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warranty_exclusion")
public class WarrantyExclusion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Agreement_Id")
	private Long agreementId;
	
	@Column(name = "Item")
	private String item;
	
	@Column(name = "W_Days")
	private Long wDays;
	
	@Column(name = "W_Meter")
	private String wMeter;
	
	@Column(name = "Parts")
	private Long parts;
	
	@Column(name = "Parts_Amount")
	private Long partsAmount;
	
	@Column(name = "Labor")
	private Long labor;
	
	@Column(name = "Labor_Amount")
	private Long laborAmount;
	
	@Column(name = "Cost_As_ON_Date")
	private Boolean costAsOnDate;
	
	@Column(name = "Notes", columnDefinition = "LONGTEXT")
	private String notes;
	
	@Column(name = "Replaces")
	private Boolean replaces;
	
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	
}
