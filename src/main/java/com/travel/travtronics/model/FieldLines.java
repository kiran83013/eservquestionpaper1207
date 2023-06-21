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
@Table(name = "stages")
public class FieldLines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Line_Id")
	private Long lineId;
	
	@Column(name = "Prc_Id")
	private Long prcId;
	
	@Column(name = "Department_Id")
	private Long department;
	
	@Column(name = "Seq_No")
	private Long seqNo;
	
	@Column(name = "Stage_Name",columnDefinition = "TEXT")
	private String stageName;
	
	@Column(name = "Description", columnDefinition = "LONGTEXT")
	private String description;
	
	@Column(name = "Sr_Type")
	private Long srType;
	
	@Column(name = "Parent_Sr_Type")
	private Long ParentSrType;
	
	@Column(name = "WF_Status")
	private Long wfstatus;
	
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
