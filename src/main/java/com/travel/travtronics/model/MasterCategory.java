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
@Table(name = "master_category")
public class MasterCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long categoryId;

	@Column(name = "category_type_id")
	private Long categorTypeId;
	
	@Column(name = "organization_id")
	private Long organizationId;
	
	@Column(name = "code")
	private String code;

	@CreationTimestamp
	@Column(name = "created_date",updatable = false)
	private Date createddate;

	@Column(name = "created_by",updatable = false)
	private String createdBy;

	@Column(name = "description", columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "name",updatable = false)
	private String name;

	@Column(name = "tn_key",updatable = false)
	private String schemaKey;

	@Column(name = "module_id")
	private Long moduleId;

	@Column(name = "start_date")
	private Date startdate;

	@Column(name = "end_date")
	private Date enddate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private Status status;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "updated_by")
	private String updatedBy;

	
	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getSchemaKey() {
		return schemaKey;
	}

	public void setSchemaKey(String schemaKey) {
		this.schemaKey = schemaKey;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getCategorTypeId() {
		return categorTypeId;
	}

	public void setCategorTypeId(Long categorTypeId) {
		this.categorTypeId = categorTypeId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
