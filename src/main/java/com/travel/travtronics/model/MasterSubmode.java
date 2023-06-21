package com.travel.travtronics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_submode")
public class MasterSubmode extends BaseModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "ModeID")
	private Long modeID;
	
	@Column(name = "OrganizationId")
	private Long organizationId;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "Code")
	private String code;

	@Column(name = "Description", columnDefinition = "LONGTEXT")
	private String description;
	
	
	@Column(name = "Status")
	private Boolean status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getModeID() {
		return modeID;
	}

	public void setModeID(Long modeID) {
		this.modeID = modeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	
}
