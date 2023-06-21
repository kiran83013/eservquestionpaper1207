package com.travel.travtronics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.FieldEnum;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.exception.NotFoundException;
import com.travel.travtronics.request.FeildLanguageHeaderRequestModel;
import com.travel.travtronics.request.FeildLanguageLinesRequestModel;
import com.travel.travtronics.request.FieldLangLineServieTypeReq;
import com.travel.travtronics.request.FieldLanguageDepartmentRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.FeildLangPriceItemReqResModel;
import com.travel.travtronics.response.FieldLangAttchmentRequestResponseModel;
import com.travel.travtronics.response.FieldLangDocReqResModel;
import com.travel.travtronics.response.FieldLangFaqReqResponseModel;
import com.travel.travtronics.response.FieldLangMasterReqResponseModel;
import com.travel.travtronics.response.FieldLangQuestionsRequestResponseModel;
import com.travel.travtronics.response.FieldLangTaxCategoryReqResModel;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.service.InternationalizationService;

@RestController
@Validated
@RequestMapping("/localization")
public class InternationalizationController {

	InternationalizationService internalizationService;

	public InternationalizationController(InternationalizationService internalizationService) {
		super();
		this.internalizationService = internalizationService;

	}

	@PostMapping(value = "/internalization-lang-header")
	public MessageStatusResponse createModifyLangFeildHeader(
			@RequestBody @Valid FeildLanguageHeaderRequestModel requestModel) {
		return internalizationService.createLangFeildHeader(requestModel);
	}

	@GetMapping(value = "lang-header-by-id")
	public APIResponse GetById(@RequestParam Integer id) throws NotFoundException {
		return internalizationService.GetById(id);
	}

	@GetMapping(value = "lang-header-info")
	public APIResponsePaging getAllInfo(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return internalizationService.getAllInfo(pageNo, pageSize, sortBy, sortType);
	}

	@PostMapping(value = "/internalization-lang-Lines")
	public MessageStatusResponse createModifyLangFeildLines(
			@RequestBody @Valid List<FeildLanguageLinesRequestModel> requestInfo) {
		return internalizationService.createLangFeildLines(requestInfo);
	}

	@GetMapping(value = "lang-lines-by-id")
	public APIResponse GetByLinesId(@RequestParam Integer id) throws NotFoundException {
		return internalizationService.GetByLinesId(id);
	}

	@GetMapping(value = "lang-lines")
	public APIResponsePaging GetByLinesHeaderIdAndOrgId(@RequestParam Integer headerId, @RequestParam Integer orgId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) throws NotFoundException {
		return internalizationService.GetByLinesHeaderIdAndOrgId(headerId, orgId, pageNo, pageSize, sortBy, sortType);
	}

//	@GetMapping(value = "get-feilds-lang-org")
//	public APIResponsePaging getFieldsByLanguageAndOrganization(@RequestParam Integer langId,
//			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
//			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "feild_id") String sortBy,
//			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
//		return internalizationService.getFieldsByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
//				sortType);
//	}
//
//	@GetMapping(value = "get-new-lang-feilds")
//	public APIResponse getNewLangFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
//		return internalizationService.getNewLangFeilds(langId, orgId);
//	}

//	@GetMapping(value = "get-feilds-lang-org123")
//	public APIResponsePaging getFieldsByLanguageAndOrganization123(@RequestParam Integer langId,
//			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
//			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "feild_id") String sortBy,
//			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
//		return internalizationService.getFieldsByLanguageAndOrganization123(langId, orgId, pageNo, pageSize, sortBy,
//				sortType);
//	}

	@GetMapping(value = "get-feilds-lang-org")
	public APIResponsePaging getFieldsByLanguageAndOrganization(@RequestParam Integer langId,
			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "feild_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getFieldsByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	@GetMapping(value = "get-new-lang-fields")
	public APIResponse getNewLangFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangFeilds(langId, orgId);
	}

	@PostMapping(value = "/internalization-lang-dept-lines")
	public MessageStatusResponse createModifyLangFeildDeptLines(
			@RequestBody @Valid List<FieldLanguageDepartmentRequest> requestInfo) {
		return internalizationService.FeildLanguageLinesRequestModel(requestInfo);
	}

	@PostMapping(value = "/internalization-lang-sr-type-lines")
	public MessageStatusResponse createModifyLangFeildSrTypeLines(
			@RequestBody @Valid List<FieldLangLineServieTypeReq> requestInfo) {
		return internalizationService.createModifyLangFeildSrTypeLines(requestInfo);
	}

	@GetMapping(value = "get-servicetype-lang-org")
	public APIResponsePaging getSrTypeByLanguageAndOrganization(@RequestParam Integer langId,
			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "service_type_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getSrTypeByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	@GetMapping(path = "get-dept-lang-org")
	public APIResponsePaging getDeptByLanguageAndOrganization(@RequestParam Integer langId, @RequestParam Integer orgId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "department_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getDeptByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	@GetMapping(value = "get-new-lang-dept-fields")
	public APIResponse getNewLangDeptFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangDeptFeilds(langId, orgId);
	}

	@GetMapping(value = "get-new-lang-sr-type-fields")
	public APIResponse getNewLangsrTypeFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangsrTypeFeilds(langId, orgId);
	}

	/*
	 * attchments
	 */

	@PostMapping(value = "/internalization-field-lang-attachments")
	public MessageStatusResponse createModifyLangFeildAttahcments(
			@RequestBody @Valid List<FieldLangAttchmentRequestResponseModel> requestInfo) {
		return internalizationService.createModifyLangFeildAttahcments(requestInfo);
	}

	@GetMapping(value = "get-new-lang-attchments-fields")
	public APIResponse getNewLangAttchFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangAttchFeilds(langId, orgId);
	}

	@GetMapping(path = "get-attachments-lang-org")
	public APIResponsePaging getAttchByLanguageAndOrganization(@RequestParam Integer langId,
			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "attachment_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getAttchByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	/*
	 * documents
	 */

	@PostMapping(value = "/internalization-field-lang-docs")
	public MessageStatusResponse createModifyLangFeildDocs(
			@RequestBody @Valid List<FieldLangDocReqResModel> requestInfo) {
		return internalizationService.createModifyLangFeildDocs(requestInfo);
	}

	@GetMapping(value = "get-new-lang-docs-fields")
	public APIResponse getNewLangDocsFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangDocsFeilds(langId, orgId);
	}

	@GetMapping(path = "get-docs-lang-org")
	public APIResponsePaging getDocsByLanguageAndOrganization(@RequestParam Integer langId, @RequestParam Integer orgId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "document_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getDocsByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	/*
	 * price
	 */

	@PostMapping(value = "/internalization-field-lang-item")
	public MessageStatusResponse createModifyLangFeildPrice(
			@RequestBody @Valid List<FeildLangPriceItemReqResModel> requestInfo) {
		return internalizationService.createModifyLangFeildPrice(requestInfo);
	}

	@GetMapping(value = "get-new-lang-item-fields")
	public APIResponse getNewLangPriceFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangPriceFeilds(langId, orgId);
	}

	@GetMapping(path = "get-item-lang-org")
	public APIResponsePaging getItemByLanguageAndOrganization(@RequestParam Integer langId, @RequestParam Integer orgId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "item_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getItemByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	/*
	 * tax category
	 */

	@PostMapping(value = "/internalization-field-lang-tax-category")
	public MessageStatusResponse createModifyLangFeildTaxCategoryPrice(
			@RequestBody @Valid List<FieldLangTaxCategoryReqResModel> requestInfo) {
		return internalizationService.createModifyLangFeildTaxCategoryPrice(requestInfo);
	}

	@GetMapping(value = "get-new-lang-taxcategory-fields")
	public APIResponse getNewLangTaxCategoryFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangTaxCategoryFeilds(langId, orgId);
	}

	@GetMapping(path = "get-tax-category-lang-org")
	public APIResponsePaging getTaxCategoryByLanguageAndOrganization(@RequestParam Integer langId,
			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "tax_category_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getTaxCategoryByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	/*
	 * questions
	 */

	@PostMapping(value = "/internalization-field-lang-questions")
	public MessageStatusResponse createModifyLangFeildQuestions(
			@RequestBody @Valid List<FieldLangQuestionsRequestResponseModel> requestInfo) {
		return internalizationService.createModifyLangFeildQuestions(requestInfo);
	}

	@GetMapping(value = "get-new-lang-questions-fields")
	public APIResponse getNewLangQuestionsFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangQuestionsFeilds(langId, orgId);
	}

	@GetMapping(path = "get-questions-lang-org")
	public APIResponsePaging getQuestionByLanguageAndOrganization(@RequestParam Integer langId,
			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "question_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getQuestionByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

	/*
	 * faqs
	 */

	@PostMapping(value = "/internalization-field-lang-faqs")
	public MessageStatusResponse createModifyLangFeildFaqs(
			@RequestBody @Valid List<FieldLangFaqReqResponseModel> requestInfo) {
		return internalizationService.createModifyLangFeildFaqs(requestInfo);
	}

	@GetMapping(value = "get-new-lang-faqs-fields")
	public APIResponse getNewLangFaqsFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangFaqsFeilds(langId, orgId);
	}

	@GetMapping(path = "get-faq-lang-org")
	public APIResponsePaging getFaqByLanguageAndOrganization(@RequestParam Integer langId, @RequestParam Integer orgId,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "faq_id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getFaqByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy, sortType,
				enumValue);
	}
	/*
	 * master
	 */

	@PostMapping(value = "/internalization-field-lang-masters")
	public MessageStatusResponse createModifyLangFeildMasters(
			@RequestBody @Valid List<FieldLangMasterReqResponseModel> requestInfo) {
		return internalizationService.createModifyLangFeildMasters(requestInfo);
	}

	@GetMapping(value = "get-new-lang-master-fields")
	public APIResponse getNewLangMastersFeilds(@RequestParam Integer langId, @RequestParam Integer orgId) {
		return internalizationService.getNewLangMastersFeilds(langId, orgId);
	}

	@GetMapping(path = "get-master-lang-org")
	public APIResponsePaging getMasterByLanguageAndOrganization(@RequestParam Integer langId,
			@RequestParam Integer orgId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType,
			@RequestParam FieldEnum enumValue) {
		return internalizationService.getMasterByLanguageAndOrganization(langId, orgId, pageNo, pageSize, sortBy,
				sortType, enumValue);
	}

}
