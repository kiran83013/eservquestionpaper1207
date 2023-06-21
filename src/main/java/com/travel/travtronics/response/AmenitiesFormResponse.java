package com.travel.travtronics.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.travel.travtronics.enums.Status;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AmenitiesFormResponse {

	private Long amenitiesFormId;

	private String name;

	private String description;

	private Long categoryId;

	private Long organizationId;

	private Long typeId;

	private Status status;

	private String createdBy;

	private String updatedBy;

	private Date createdDate;

	private Date updatedDate;

	private String categoryName;

	private String typeName;

	public Long getAmenitiesFormId() {
		return amenitiesFormId;
	}

	public void setAmenitiesFormId(Long amenitiesFormId) {
		this.amenitiesFormId = amenitiesFormId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



}
