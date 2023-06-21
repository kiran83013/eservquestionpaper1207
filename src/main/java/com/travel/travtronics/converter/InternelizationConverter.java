package com.travel.travtronics.converter;

import java.time.LocalDateTime;

import com.travel.travtronics.model.FeildLangFaq;
import com.travel.travtronics.model.FeildLangGenMaster;
import com.travel.travtronics.model.FeildLangPriceItem;
import com.travel.travtronics.model.FeildLanguageAttachments;
import com.travel.travtronics.model.FeildLanguageHeaderModel;
import com.travel.travtronics.model.FeildLanguageLinesModel;
import com.travel.travtronics.model.FieldLangDocuments;
import com.travel.travtronics.model.FieldLangPriceTaxCategory;
import com.travel.travtronics.model.FieldLangQuestions;
import com.travel.travtronics.model.FieldLanguageDepartments;
import com.travel.travtronics.model.FieldLanguageServiceTypes;
import com.travel.travtronics.model.MasterLanguage;
import com.travel.travtronics.request.FeildLanguageHeaderRequestModel;
import com.travel.travtronics.request.FeildLanguageLinesRequestModel;
import com.travel.travtronics.request.FieldLangLineServieTypeReq;
import com.travel.travtronics.request.FieldLanguageDepartmentRequest;
import com.travel.travtronics.response.FeildLangPriceItemReqResModel;
import com.travel.travtronics.response.FeildLanguageHeaderResponseModel;
import com.travel.travtronics.response.FeildLanguageLinesResponseModel;
import com.travel.travtronics.response.FieldLangAttchmentRequestResponseModel;
import com.travel.travtronics.response.FieldLangDocReqResModel;
import com.travel.travtronics.response.FieldLangQuestionsRequestResponseModel;
import com.travel.travtronics.response.FieldLangFaqReqResponseModel;
import com.travel.travtronics.response.FieldLangMasterReqResponseModel;
import com.travel.travtronics.response.FieldLangTaxCategoryReqResModel;

public class InternelizationConverter {

	public static FeildLanguageHeaderModel convertDtoToEntityModel(FeildLanguageHeaderRequestModel model) {
		FeildLanguageHeaderModel entity = new FeildLanguageHeaderModel();
		if (model.getLangInfo() != null) {
			entity.setLanguageId(model.getLangInfo().getId());
			entity.setLanguageCode(model.getLangInfo().getCode());
			entity.setLanguageName(model.getLangInfo().getName());
		}
		entity.setRequiredMessage(model.getRequiredMessage());
		entity.setRequiredAlphanumericOnlyMessage(model.getRequiredAlphanumericOnlyMessage());
		entity.setRequiredMaximumMessage(model.getRequiredMaximumMessage());
		entity.setRequiredMinimumMessage(model.getRequiredMinimumMessage());
		entity.setRequiredMaximumDateMessage(model.getRequiredMaximumDateMessage());
		entity.setRequiredMinimumDateMessage(model.getRequiredMaximumDateMessage());
		entity.setRequiredMinimumDateMessage(model.getRequiredMinimumDateMessage());
		entity.setRequiredNumberOnlyMessage(model.getRequiredNumberOnlyMessage());
		entity.setRequiredAlphanumericOnlyMessage(model.getRequiredAlphanumericOnlyMessage());
		entity.setStatus(model.getStatus());
		entity.setCreatedBy(model.getCreatedBy());
		entity.setCreatedDate(LocalDateTime.now());
		return entity;
	}

	public static FeildLanguageHeaderModel modifyDtoToEntityModel(FeildLanguageHeaderRequestModel model) {
		FeildLanguageHeaderModel entity = new FeildLanguageHeaderModel();
		entity.setId(model.getId());
		/*
		 * entity.setLanguageId(model.getLanguageId());
		 * entity.setLanguageCode(model.getLanguageCode());
		 * entity.setLanguageName(model.getLanguageName());
		 */
		if (model.getLangInfo() != null) {
			entity.setLanguageId(model.getLangInfo().getId());
			entity.setLanguageCode(model.getLangInfo().getCode());
			entity.setLanguageName(model.getLangInfo().getName());
		}
		entity.setRequiredMessage(model.getRequiredMessage());
		entity.setRequiredAlphanumericOnlyMessage(model.getRequiredAlphanumericOnlyMessage());
		entity.setRequiredMaximumMessage(model.getRequiredMaximumMessage());
		entity.setRequiredMinimumMessage(model.getRequiredMinimumMessage());
		entity.setRequiredMaximumDateMessage(model.getRequiredMaximumDateMessage());
		entity.setRequiredMinimumDateMessage(model.getRequiredMaximumDateMessage());
		entity.setRequiredMinimumDateMessage(model.getRequiredMinimumDateMessage());
		entity.setRequiredNumberOnlyMessage(model.getRequiredNumberOnlyMessage());
		entity.setRequiredAlphanumericOnlyMessage(model.getRequiredAlphanumericOnlyMessage());
		entity.setStatus(model.getStatus());
		entity.setUpdatedBy(model.getUpdatedBy());
		entity.setUpdatedDate(LocalDateTime.now());
		return entity;
	}

	public static FeildLanguageHeaderResponseModel convertEntityToDtoModel(FeildLanguageHeaderModel entity,
			MasterLanguage master) {
		FeildLanguageHeaderResponseModel model = new FeildLanguageHeaderResponseModel();
		model.setId(entity.getId());
		model.setLangInfo(master);
		model.setRequiredMessage(entity.getRequiredMessage());
		model.setRequiredAlphanumericOnlyMessage(entity.getRequiredAlphanumericOnlyMessage());
		model.setRequiredMaximumMessage(entity.getRequiredMaximumMessage());
		model.setRequiredMinimumMessage(entity.getRequiredMinimumMessage());
		model.setRequiredMaximumDateMessage(entity.getRequiredMaximumDateMessage());
		model.setRequiredMinimumDateMessage(entity.getRequiredMaximumDateMessage());
		model.setRequiredMinimumDateMessage(entity.getRequiredMinimumDateMessage());
		model.setRequiredNumberOnlyMessage(entity.getRequiredNumberOnlyMessage());
		model.setRequiredAlphanumericOnlyMessage(entity.getRequiredAlphanumericOnlyMessage());
		model.setStatus(entity.getStatus());
		model.setCreatedBy(entity.getCreatedBy());
		model.setUpdatedBy(entity.getUpdatedBy());
		model.setCreatedDate(entity.getCreatedDate());
		model.setUpdatedDate(entity.getUpdatedDate());
		return model;
	}

	public static FeildLanguageLinesModel convertLinesDtoToEntityModel(FeildLanguageLinesRequestModel model) {
		FeildLanguageLinesModel entity = new FeildLanguageLinesModel();

		entity.setStatus(model.getStatus());
		entity.setCreatedBy(model.getCreatedBy());
		entity.setCreatedDate(LocalDateTime.now());
		entity.setHeaderId(model.getHeaderId());
		entity.setName(model.getName());
		entity.setLangId(model.getLangId());
		entity.setLangCode(model.getLangCode());
		entity.setLangName(model.getLangName());
		entity.setFieldId(model.getFieldId());
		entity.setLabel(model.getLabel());
		entity.setPlaceHolder(model.getPlaceHolder());
		entity.setHint(model.getHint());
		entity.setOrgId(model.getOrgId());
		entity.setInfo(model.getInfo());
		return entity;
	}

	public static FeildLanguageLinesModel modifyLinesDtoToEntityModel(FeildLanguageLinesRequestModel model) {
		FeildLanguageLinesModel entity = new FeildLanguageLinesModel();

		entity.setStatus(model.getStatus());
		entity.setHeaderId(model.getHeaderId());
		entity.setName(model.getName());
		entity.setLangId(model.getLangId());
		entity.setLangCode(model.getLangCode());
		entity.setLangName(model.getLangName());
		entity.setFieldId(model.getFieldId());
		entity.setLabel(model.getLabel());
		entity.setPlaceHolder(model.getPlaceHolder());
		entity.setHint(model.getHint());
		entity.setOrgId(model.getOrgId());
		entity.setInfo(model.getInfo());
		entity.setUpdatedBy(model.getUpdatedBy());
		entity.setUpdatedDate(LocalDateTime.now());
		entity.setId(model.getId());
		return entity;
	}

	public static FeildLanguageLinesResponseModel convertEntityToDto(FeildLanguageLinesModel entity) {
		FeildLanguageLinesResponseModel model = new FeildLanguageLinesResponseModel();
		model.setStatus(entity.getStatus());
		model.setHeaderId(entity.getHeaderId());
		model.setName(entity.getName());
		model.setLangId(entity.getLangId());
		model.setLangCode(entity.getLangCode());
		model.setLangName(entity.getLangName());
		model.setFieldId(entity.getFieldId());
		model.setLabel(entity.getLabel());
		model.setPlaceHolder(entity.getPlaceHolder());
		model.setHint(entity.getHint());
		model.setOrgId(entity.getOrgId());
		model.setInfo(entity.getInfo());
		model.setUpdatedBy(entity.getUpdatedBy());
		model.setUpdatedDate(entity.getUpdatedDate());
		model.setId(entity.getId());
		model.setCreatedBy(entity.getCreatedBy());
		model.setCreatedDate(entity.getCreatedDate());
		return model;
	}

	public static FieldLanguageDepartments convertDeptReqToModel(FieldLanguageDepartmentRequest request) {
		FieldLanguageDepartments model = new FieldLanguageDepartments();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setName(request.getName());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setDepartmentId(request.getDepartmentId());
		return model;
	}

	public static FieldLanguageDepartments updateDeptReqToModel(FieldLanguageDepartmentRequest request) {
		FieldLanguageDepartments model = new FieldLanguageDepartments();
		model.setStatus(request.getStatus());
		model.setHeaderId(request.getHeaderId());
		model.setName(request.getName());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setDepartmentId(request.getDepartmentId());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setId(request.getId());
		return model;
	}

	public static FieldLanguageServiceTypes convertServiceTypeJsonToModel(FieldLangLineServieTypeReq request) {
		FieldLanguageServiceTypes model = new FieldLanguageServiceTypes();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setName(request.getName());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setServiceTypeId(request.getServiceTypeId());
		model.setInstructions(request.getInstructions());
		return model;
	}

	public static FieldLanguageServiceTypes modifyServiceTypeJsonToModel(FieldLangLineServieTypeReq request) {
		FieldLanguageServiceTypes model = new FieldLanguageServiceTypes();
		model.setStatus(request.getStatus());
		model.setHeaderId(request.getHeaderId());
		model.setName(request.getName());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setServiceTypeId(request.getServiceTypeId());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setInstructions(request.getInstructions());
		model.setId(request.getId());
		return model;
	}

	public static FeildLanguageAttachments convertAttchmentRequestToModel(
			FieldLangAttchmentRequestResponseModel request) {
		FeildLanguageAttachments model = new FeildLanguageAttachments();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setAttachmentId(request.getAttachmentId());
		model.setAttachmentName(request.getAttachmentName());

		return model;
	}

	public static FeildLanguageAttachments modifyAttchmentRequestToModel(
			FieldLangAttchmentRequestResponseModel request) {
		FeildLanguageAttachments model = new FeildLanguageAttachments();
		model.setId(request.getId());
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setAttachmentId(request.getAttachmentId());
		model.setAttachmentName(request.getAttachmentName());
		return model;
	}

	public static FieldLangDocuments convertDocRequestToModel(FieldLangDocReqResModel request) {
		FieldLangDocuments model = new FieldLangDocuments();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setDocId(request.getDocId());
		model.setDocName(request.getDocName());
		return model;
	}

	public static FieldLangDocuments modifyDocRequestToModel(FieldLangDocReqResModel request) {
		FieldLangDocuments model = new FieldLangDocuments();
		model.setId(request.getId());
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setDocId(request.getDocId());
		model.setDocName(request.getDocName());
		return model;
	}

	public static FeildLangPriceItem convertPriceRequestToModel(FeildLangPriceItemReqResModel request) {
		FeildLangPriceItem model = new FeildLangPriceItem();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setItemId(request.getItemId());
		model.setItemName(request.getItemName());
		return model;
	}

	public static FeildLangPriceItem modifyPriceRequestToModel(FeildLangPriceItemReqResModel request) {
		FeildLangPriceItem model = new FeildLangPriceItem();
		model.setId(request.getId());
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setItemId(request.getItemId());
		model.setItemName(request.getItemName());

		return model;
	}

	public static FieldLangPriceTaxCategory convertTaxCategoryRequestToModel(FieldLangTaxCategoryReqResModel request) {
		FieldLangPriceTaxCategory model = new FieldLangPriceTaxCategory();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setTaxCategoryId(request.getTaxCategoryId());
		model.setTaxCategoryName(request.getTaxCategoryName());
		return model;
	}

	public static FieldLangPriceTaxCategory modifyTaxCategoryRequestToModel(FieldLangTaxCategoryReqResModel request) {
		FieldLangPriceTaxCategory model = new FieldLangPriceTaxCategory();
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setTaxCategoryId(request.getTaxCategoryId());
		model.setTaxCategoryName(request.getTaxCategoryName());
		model.setId(request.getId());
		return model;
	}

	public static FieldLangQuestions convertQuestionsRequestToModel(FieldLangQuestionsRequestResponseModel request) {
		FieldLangQuestions model = new FieldLangQuestions();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setQuestionId(request.getQuestionId());
		model.setQuestionName(request.getQuestionName());
		return model;
	}

	public static FieldLangQuestions modifyQuestionsRequestToModel(FieldLangQuestionsRequestResponseModel request) {
		FieldLangQuestions model = new FieldLangQuestions();
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setQuestionId(request.getQuestionId());
		model.setQuestionName(request.getQuestionName());
		model.setId(request.getId());
		return model;
	}

	public static FeildLangFaq convertFaqsRequestToModel(FieldLangFaqReqResponseModel request) {
		FeildLangFaq model = new FeildLangFaq();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setQuestionId(request.getQuestionId());
		model.setQuestionName(request.getQuestionName());
		model.setAnswer(request.getAnswer());
		model.setReferenceId(request.getReferenceId());
		model.setReferenceType(request.getReferenceType());
		return model;
	}

	public static FeildLangFaq modifyFaqsRequestToModel(FieldLangFaqReqResponseModel request) {
		FeildLangFaq model = new FeildLangFaq();
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setQuestionId(request.getQuestionId());
		model.setQuestionName(request.getQuestionName());
		model.setAnswer(request.getAnswer());
		model.setReferenceId(request.getReferenceId());
		model.setReferenceType(request.getReferenceType());
		model.setId(request.getId());
		return model;
	}

	public static FeildLangGenMaster convertMasterRequestToModel(FieldLangMasterReqResponseModel request) {
		FeildLangGenMaster model = new FeildLangGenMaster();
		model.setStatus(request.getStatus());
		model.setCreatedBy(request.getCreatedBy());
		model.setCreatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setMasterId(request.getMasterId());
		model.setName(request.getName());
		model.setCode(request.getCode());
		model.setDescription(request.getDescription());

		return model;
	}

	public static FeildLangGenMaster updateMasterRequestToModel(FieldLangMasterReqResponseModel request) {
		FeildLangGenMaster model = new FeildLangGenMaster();
		model.setStatus(request.getStatus());
		model.setUpdatedBy(request.getUpdatedBy());
		model.setUpdatedDate(LocalDateTime.now());
		model.setHeaderId(request.getHeaderId());
		model.setLangId(request.getLangId());
		model.setLangCode(request.getLangCode());
		model.setLangName(request.getLangName());
		model.setOrgId(request.getOrgId());
		model.setMasterId(request.getMasterId());
		model.setName(request.getName());
		model.setCode(request.getCode());
		model.setDescription(request.getDescription());
		model.setId(request.getId());
		return model;
	}

}
