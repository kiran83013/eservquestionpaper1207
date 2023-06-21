package com.travel.travtronics.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "field_language_header")
@DynamicUpdate
public class FeildLanguageHeaderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "language_id")
	private Integer languageId;

	@Column(name = "language_name")
	private String languageName;

	@Column(name = "language_code")
	private String languageCode;

	@Column(name = "required_message")
	private String requiredMessage;

	@Column(name = "required_minimum_message")
	private String requiredMinimumMessage;

	@Column(name = "required_maximum_message")
	private String requiredMaximumMessage;

	@Column(name = "required_maximum_date_message")
	private String requiredMaximumDateMessage;

	@Column(name = "required_minimum_date_message")
	private String requiredMinimumDateMessage;

	@Column(name = "required_number_only_message")
	private String requiredNumberOnlyMessage;

	@Column(name = "required_alphanumeric_only_message")
	private String requiredAlphanumericOnlyMessage;

	@Column(name = "status")
	private String status;

	@Column(name = "created_by", updatable = false)
	private String createdBy;

	@Column(name = "updated_by")
	private String updatedBy;

	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getRequiredMessage() {
		return requiredMessage;
	}

	public void setRequiredMessage(String requiredMessage) {
		this.requiredMessage = requiredMessage;
	}

	public String getRequiredMinimumMessage() {
		return requiredMinimumMessage;
	}

	public void setRequiredMinimumMessage(String requiredMinimumMessage) {
		this.requiredMinimumMessage = requiredMinimumMessage;
	}

	public String getRequiredMaximumMessage() {
		return requiredMaximumMessage;
	}

	public void setRequiredMaximumMessage(String requiredMaximumMessage) {
		this.requiredMaximumMessage = requiredMaximumMessage;
	}

	public String getRequiredMaximumDateMessage() {
		return requiredMaximumDateMessage;
	}

	public void setRequiredMaximumDateMessage(String requiredMaximumDateMessage) {
		this.requiredMaximumDateMessage = requiredMaximumDateMessage;
	}

	public String getRequiredMinimumDateMessage() {
		return requiredMinimumDateMessage;
	}

	public void setRequiredMinimumDateMessage(String requiredMinimumDateMessage) {
		this.requiredMinimumDateMessage = requiredMinimumDateMessage;
	}

	public String getRequiredNumberOnlyMessage() {
		return requiredNumberOnlyMessage;
	}

	public void setRequiredNumberOnlyMessage(String requiredNumberOnlyMessage) {
		this.requiredNumberOnlyMessage = requiredNumberOnlyMessage;
	}

	public String getRequiredAlphanumericOnlyMessage() {
		return requiredAlphanumericOnlyMessage;
	}

	public void setRequiredAlphanumericOnlyMessage(String requiredAlphanumericOnlyMessage) {
		this.requiredAlphanumericOnlyMessage = requiredAlphanumericOnlyMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}
