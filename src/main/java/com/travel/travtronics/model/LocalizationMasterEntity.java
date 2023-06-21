package com.travel.travtronics.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;

import org.hibernate.annotations.Immutable;

import com.travel.travtronics.enums.Query;

@SqlResultSetMappings(value = { @SqlResultSetMapping(name = "getCountInfo", columns = {
		@ColumnResult(name = "count_info", type = Long.class) }) })
@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "LocalizationMasterEntity.getNewLangMasterFeilds", query = Query.GET_NEW_LANG_MASTER_FEILDS, resultClass = LocalizationMasterEntity.class),
		@NamedNativeQuery(name = "LocalizationMasterEntity.getNewLangMasterFeilds.count", resultSetMapping = "getCountInfo", query = Query.GET_NEW_LANG_MASTER_FEILDS_COUNT),
		@NamedNativeQuery(name = "LocalizationMasterEntity.getALLangMasterFeilds", query = Query.BASE_GET_LANG_MASTER_FEILDS_QUERY, resultClass = LocalizationMasterEntity.class),
		@NamedNativeQuery(name = "LocalizationMasterEntity.getALLangMasterFeilds.count", resultSetMapping = "getCountInfo", query = Query.BASE_NEW_LANG_MASTER_FEILDS_COUNT),
		@NamedNativeQuery(name = "LocalizationMasterEntity.getNonNewangMasterFeilds", query = Query.GET_NON_NEW_LANG_MASTER_FEILDS, resultClass = LocalizationMasterEntity.class),
		@NamedNativeQuery(name = "LocalizationMasterEntity.getNonNewangMasterFeilds.count", resultSetMapping = "getCountInfo", query = Query.GET_NON_NEW_LANG_MASTER_FEILDS_COUNT) })
@Immutable
@Entity

public class LocalizationMasterEntity {

	@Id
	@Column(name = "master_id", insertable = false, updatable = false)
	private Integer masterId;

	@Column(name = "actual_name", insertable = false, updatable = false)
	private String actualName;

	@Column(name = "actual_code", insertable = false, updatable = false)
	private String actualCode;

	@Column(name = "actual_description", insertable = false, updatable = false)
	private String actualDescription;

	@Column(name = "lang_name", insertable = false, updatable = false)
	private String langName;

	@Column(name = "master_name", insertable = false, updatable = false)
	private String masterName;

	@Column(name = "master_code", insertable = false, updatable = false)
	private String masterCode;

	@Column(name = "master_description", insertable = false, updatable = false)
	private String masterDescription;

	@Column(name = "created_by", insertable = false, updatable = false)
	private Integer createdBy;

	@Column(name = "created_date", insertable = false, updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_by", insertable = false, updatable = false)
	private Integer updatedBy;

	@Column(name = "updated_date", insertable = false, updatable = false)
	private LocalDateTime updatedDate;

	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "header_id", insertable = false, updatable = false)
	private Integer headerId;

	@Column(name = "category_id", insertable = false, updatable = false)
	private Integer categoryId;

	
	
	public String getActualCode() {
		return actualCode;
	}

	public void setActualCode(String actualCode) {
		this.actualCode = actualCode;
	}

	public String getActualDescription() {
		return actualDescription;
	}

	public void setActualDescription(String actualDescription) {
		this.actualDescription = actualDescription;
	}

	public String getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(String masterCode) {
		this.masterCode = masterCode;
	}

	public String getMasterDescription() {
		return masterDescription;
	}

	public void setMasterDescription(String masterDescription) {
		this.masterDescription = masterDescription;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public String getActualName() {
		return actualName;
	}

	public void setActualName(String actualName) {
		this.actualName = actualName;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHeaderId() {
		return headerId;
	}

	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
