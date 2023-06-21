package com.travel.travtronics.request;

import java.util.Date;

import com.travel.travtronics.enums.Status;

public class FieldLinesRequest {

	private Long lineId;

	private Long prcId;
	
	private Long seqNo;
	
	private Long department;
	
	private String stageName;
	
	private String description;
	
	private Long srType;
	
	private Long ParentSrType;

	private Long wfstatus;

	private Long organizationId;
	
	private Long createdBy;
	
	private Long updatedBy;
	
	private Date updatedDate;
	
	private Date createdDate;
	
	private Status status;

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Long getPrcId() {
		return prcId;
	}

	public void setPrcId(Long prcId) {
		this.prcId = prcId;
	}

	public Long getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSrType() {
		return srType;
	}

	public void setSrType(Long srType) {
		this.srType = srType;
	}

	public Long getParentSrType() {
		return ParentSrType;
	}

	public void setParentSrType(Long parentSrType) {
		ParentSrType = parentSrType;
	}

	public Long getWfstatus() {
		return wfstatus;
	}

	public void setWfstatus(Long wfstatus) {
		this.wfstatus = wfstatus;
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

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
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
