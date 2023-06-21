package com.travel.travtronics.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.travel.travtronics.enums.Status;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FieldProcessHeaderResponse {

	private Long prcId;

	private String processName;

	private String description;

	private Long srTypeId;

	private Long category;

	private Long department;

	private Long Type;

	private Long wfstatus;

	private Long team;

	private Long owner;

	private Long organizationId;

	private Status status;

	private Long createdBy;

	private Long updatedBy;

	private Date updatedDate;

	private Date createdDate;
	
	private String srTypeName;

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

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
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

	public String getSrTypeName() {
		return srTypeName;
	}

	public void setSrTypeName(String srTypeName) {
		this.srTypeName = srTypeName;
	}

}
