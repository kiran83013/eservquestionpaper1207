package com.travel.travtronics.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.travel.travtronics.model.MasterLanguage;

public class FeildLanguageHeaderRequestModel {

	private Integer id;

	/*
	 * @NotNull(message = "languageid-should-not-be-null") private Integer
	 * languageId;
	 * 
	 * @NotBlank(message = "languageName-should-not-be-blank or null") private
	 * String languageName;
	 * 
	 * @NotBlank(message = "languagecode-should not be null or empty") private
	 * String languageCode;
	 */

	@NotNull
	private MasterLanguage langInfo;

	@NotBlank(message = "message-should-not-be null or empty")
	private String requiredMessage;

	@NotBlank(message = "minimum-message-should-not-be null or empty")
	private String requiredMinimumMessage;

	@NotBlank(message = "maximum message should not be null or empty ")
	private String requiredMaximumMessage;

	private String requiredMaximumDateMessage;

	private String requiredMinimumDateMessage;

	@NotBlank(message = "required-no-only-message should not be null or empty ")
	private String requiredNumberOnlyMessage;

	@NotBlank(message = "required_alphanumeric_only_message should not be null or empty")
	private String requiredAlphanumericOnlyMessage;

	@NotBlank(message = "status should not be null or empty")
	private String status;

	private String createdBy;

	private String updatedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	
	public MasterLanguage getLangInfo() {
		return langInfo;
	}

	public void setLangInfo(MasterLanguage langInfo) {
		this.langInfo = langInfo;
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

}
