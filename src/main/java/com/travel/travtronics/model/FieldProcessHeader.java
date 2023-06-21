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
@Table(name = "process")
public class FieldProcessHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long prcId;
	
	@Column(name = "Process_Name",columnDefinition = "TEXT")
	private String processName;
	
	@Column(name = "Description", columnDefinition = "LONGTEXT")
	private String description;
	
	@Column(name = "Sr_Type_Id")
	private Long srTypeId;
	
	@Column(name = "Category")
	private Long category;
	
	@Column(name = "Department_Id")
	private Long department;
	
	@Column(name = "Type")
	private Long Type;
	
	@Column(name = "WF_Status")
	private Long wfstatus;
	
	@Column(name = "Team")
	private Long team;
	
	@Column(name = "Owner")
	private Long owner;
	
	@Column(name = "Organization_Id")
	private Long organizationId;
	
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "Created_By", updatable = false)
	private Long createdBy;

	@Column(name = "Updated_By")
	private Long updatedBy;

	@Column(name = "Updated_Date")
	private Date updatedDate;

	@Column(name = "Created_Date", updatable = false)
	private Date createdDate;

	public Long getPrcId() {
		return prcId;
	}

	public void setPrcId(Long prcId) {
		this.prcId = prcId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSrTypeId() {
		return srTypeId;
	}

	public void setSrTypeId(Long srTypeId) {
		this.srTypeId = srTypeId;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getType() {
		return Type;
	}

	public void setType(Long type) {
		Type = type;
	}

	public Long getWfstatus() {
		return wfstatus;
	}

	public void setWfstatus(Long wfstatus) {
		this.wfstatus = wfstatus;
	}

	public Long getTeam() {
		return team;
	}

	public void setTeam(Long team) {
		this.team = team;
	}

	public Long getOwner() {
		return owner;
	}

	public void setOwner(Long owner) {
		this.owner = owner;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}
	
	
}
