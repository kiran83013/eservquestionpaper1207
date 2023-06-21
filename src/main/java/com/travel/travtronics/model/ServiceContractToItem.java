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
@Table(name = "service_contract_to_item")
public class ServiceContractToItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "Item")
	private String item;
	
	@Column(name = "Agreement")
	private String agreement;
	
	@Column(name = "Territory")
	private String territory;
	
	@Column(name = "Business_Unit")
	private String businessUnit;
	
	@Column(name = "Cost_Center")
	private String costCenter;
	
	@Column(name = "Organization_Id")
	private Long organization;
	
	@Column(name = "Locality")
	private String locality;
	
	@Column(name = "Valid_From")
	private Date validFrom;
	
	@Column(name = "Valid_To")
	private Date validTo;
	
	@Column(name = "WF_Status")
	private String wfstatus;
	
	@Column(name = "Record_Status")
	@Enumerated(EnumType.STRING)
	private Status recordStatus;
	
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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public Long getOrganization() {
		return organization;
	}

	public void setOrganization(Long organization) {
		this.organization = organization;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
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

	public String getWfstatus() {
		return wfstatus;
	}

	public void setWfstatus(String wfstatus) {
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
