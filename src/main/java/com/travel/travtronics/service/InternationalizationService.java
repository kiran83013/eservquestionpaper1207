package com.travel.travtronics.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.InternelizationConverter;
import com.travel.travtronics.enums.FieldEnum;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.exception.NotFoundException;
import com.travel.travtronics.model.FeildLanguageHeaderModel;
import com.travel.travtronics.model.FeildLanguageLinesModel;
import com.travel.travtronics.model.LocalizationMasterEntity;
import com.travel.travtronics.model.MasterLanguage;
import com.travel.travtronics.repository.DepartmentsRepository;
import com.travel.travtronics.repository.FeildLangFaqRepository;
import com.travel.travtronics.repository.FeildLangGemMasterRepository;
import com.travel.travtronics.repository.FeildLangPriceItemRepository;
import com.travel.travtronics.repository.FeildLanguageHeaderRepository;
import com.travel.travtronics.repository.FeildLanguageLinesRepository;
import com.travel.travtronics.repository.FieldLangAttachmentsRepository;
import com.travel.travtronics.repository.FieldLangDocumentsRepository;
import com.travel.travtronics.repository.FieldLangPriceTaxCategoryRepository;
import com.travel.travtronics.repository.FieldLangQuestionsRepository;
import com.travel.travtronics.repository.FieldLanguageDepartmentsRepository;
import com.travel.travtronics.repository.FieldLanguageServiceTypesRepository;
import com.travel.travtronics.repository.LocalizationMasterEntityRepository;
import com.travel.travtronics.repository.MasterLanguageRepository;
import com.travel.travtronics.request.FeildLanguageHeaderRequestModel;
import com.travel.travtronics.request.FeildLanguageLinesRequestModel;
import com.travel.travtronics.request.FieldLangLineServieTypeReq;
import com.travel.travtronics.request.FieldLanguageDepartmentRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.FeildLangPriceItemReqResModel;
import com.travel.travtronics.response.FeildLanguageHeaderResponseModel;
import com.travel.travtronics.response.FeildLanguageLinesResponseModel;
import com.travel.travtronics.response.FieldLangAttchmentRequestResponseModel;
import com.travel.travtronics.response.FieldLangDocReqResModel;
import com.travel.travtronics.response.FieldLangFaqReqResponseModel;
import com.travel.travtronics.response.FieldLangMasterReqResponseModel;
import com.travel.travtronics.response.FieldLangQuestionsRequestResponseModel;
import com.travel.travtronics.response.FieldLangTaxCategoryReqResModel;
import com.travel.travtronics.response.MessageStatusResponse;

@Service
public class InternationalizationService {

	FeildLanguageHeaderRepository headerRepository;

	FeildLanguageLinesRepository linesRepository;

	MasterLanguageRepository masterLanguageRepository;

	FieldLanguageDepartmentsRepository fieldLanguageDepartmentsRepository;

	FieldLanguageServiceTypesRepository fieldLanguageServiceTypesRepository;

	DepartmentsRepository departmentsRepository;

	FieldLangAttachmentsRepository fieldLangAttachmentsRepository;

	FieldLangDocumentsRepository feildLangDocRepository;

	FeildLangPriceItemRepository feildLangPriceRepository;

	FieldLangPriceTaxCategoryRepository fieldLangPriceTaxCategoryRepository;

	FieldLangQuestionsRepository fieldLangQuestionsRepository;

	FeildLangFaqRepository feildLangFaqRepository;

	FeildLangGemMasterRepository feildLangGemMasterRepository;

	LocalizationMasterEntityRepository localizationMasterEntityRepository;

	public InternationalizationService(FeildLanguageHeaderRepository headerRepository,
			FeildLanguageLinesRepository linesRepository, MasterLanguageRepository masterLanguageRepository,
			FieldLanguageDepartmentsRepository fieldLanguageDepartmentsRepository,
			FieldLanguageServiceTypesRepository fieldLanguageServiceTypesRepository,
			DepartmentsRepository departmentsRepository, FieldLangAttachmentsRepository feildLangAttchmentsRepository,
			FieldLangDocumentsRepository feildLangDocRepository, FeildLangPriceItemRepository feildLangPriceRepository,
			FieldLangPriceTaxCategoryRepository fieldLangPriceTaxCategoryRepository,
			FieldLangQuestionsRepository fieldLangQuestionsRepository, FeildLangFaqRepository feildLangFaqRepository,
			FeildLangGemMasterRepository feildLangGemMasterRepository,
			LocalizationMasterEntityRepository localizationMasterEntityRepository) {
		super();
		this.headerRepository = headerRepository;
		this.linesRepository = linesRepository;
		this.masterLanguageRepository = masterLanguageRepository;
		this.fieldLanguageDepartmentsRepository = fieldLanguageDepartmentsRepository;
		this.fieldLanguageServiceTypesRepository = fieldLanguageServiceTypesRepository;
		this.departmentsRepository = departmentsRepository;
		this.fieldLangAttachmentsRepository = feildLangAttchmentsRepository;
		this.feildLangDocRepository = feildLangDocRepository;
		this.feildLangPriceRepository = feildLangPriceRepository;
		this.fieldLangPriceTaxCategoryRepository = fieldLangPriceTaxCategoryRepository;
		this.fieldLangQuestionsRepository = fieldLangQuestionsRepository;
		this.feildLangFaqRepository = feildLangFaqRepository;
		this.feildLangGemMasterRepository = feildLangGemMasterRepository;
		this.localizationMasterEntityRepository = localizationMasterEntityRepository;
	}

	public MessageStatusResponse createLangFeildHeader(@Valid FeildLanguageHeaderRequestModel requestModel) {

		boolean existsByIdValidation = headerRepository
				.existsById(requestModel.getId() != null ? requestModel.getId() : 0);

		if (existsByIdValidation) {
			headerRepository.save(InternelizationConverter.modifyDtoToEntityModel(requestModel));
			return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());

		} else {
			headerRepository.save(InternelizationConverter.convertDtoToEntityModel(requestModel));
			return new MessageStatusResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
		}
	}

	public APIResponse GetById(Integer id) throws NotFoundException {

		FeildLanguageHeaderModel model = headerRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("entity not found with id : %s", id)));

		MasterLanguage langModel = masterLanguageRepository.findById(model.getLanguageId()).orElseThrow(
				() -> new NotFoundException(String.format("entity not found with id : %s", model.getLanguageId())));

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
				Arrays.asList(InternelizationConverter.convertEntityToDtoModel(model, langModel)));
	}

	public APIResponsePaging getAllInfo(int pageNo, int pageSize, String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

		Page<FeildLanguageHeaderResponseModel> mappedDto = headerRepository.findAll(pageable).map(model -> {

			MasterLanguage langModel = null;
			try {
				langModel = masterLanguageRepository.findById(model.getLanguageId())
						.orElseThrow(() -> new NotFoundException(
								String.format("entity not found with id : %s", model.getLanguageId())));
			} catch (NotFoundException e) {
				e.printStackTrace();
			}
			return InternelizationConverter.convertEntityToDtoModel(model, langModel);

		});
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), mappedDto.getContent(),
				Collections.emptyList(), mappedDto.getNumber(), mappedDto.getTotalElements(),
				mappedDto.getTotalPages());

	}

	public MessageStatusResponse createLangFeildLines(@Valid List<FeildLanguageLinesRequestModel> requestInfo) {

		requestInfo.stream().forEach(line -> {

			boolean existsById = linesRepository.existsById(line.getId() != null ? line.getId() : 0);
			if (existsById) {
				linesRepository.save(InternelizationConverter.modifyLinesDtoToEntityModel(line));
			} else {
				linesRepository.save(InternelizationConverter.convertLinesDtoToEntityModel(line));
			}

		});

		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse GetByLinesId(Integer id) throws NotFoundException {
		FeildLanguageLinesModel line = linesRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("entity not found with id : %s", id)));
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
				Arrays.asList(InternelizationConverter.convertEntityToDto(line)));
	}

	public APIResponsePaging GetByLinesHeaderIdAndOrgId(Integer headerId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType) throws NotFoundException {

		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());

		Page<FeildLanguageLinesModel> linesInfo = linesRepository.findByHeaderIdAndOrgId(headerId, orgId, pageable);

		if (linesInfo.getContent().isEmpty())
			throw new NotFoundException("no data found with this request");
		else {
			Page<FeildLanguageLinesResponseModel> mappedDto = linesInfo
					.map(InternelizationConverter::convertEntityToDto);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), mappedDto.getContent(),
					Collections.emptyList(), mappedDto.getNumber(), mappedDto.getTotalElements(),
					mappedDto.getTotalPages());

		}

	}

	public APIResponsePaging getFieldsByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize);
//
//		Page<Map<String, Object>> pageObject = headerRepository.getFeildsByLanguageAndOrganization(langId, orgId,
//				pageable);
//		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
//				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
//				pageObject.getTotalPages());

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;

		if (enumValue.equals(FieldEnum.ALL))
			pageObject = headerRepository.getFeildsByLanguageAndOrganization(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = headerRepository.getNewFeildsNonExistsPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = headerRepository.getNewFeildsExistsPagination(langId, orgId, pageable);
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

//	public APIResponsePaging getFieldsByLanguageAndOrganization123(Integer langId, Integer orgId, int pageNo,
//			int pageSize, String sortBy, SortType sortType) {
//
//		Sort sort = Sort.by(sortBy).descending();
//
//		if (sortType.equals(SortType.asc)) {
//			sort = Sort.by(sortBy);
//		}
//
//		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
//		Page<Map<String, Object>> pageObject = headerRepository.getFeildsByLanguageAndOrganization123(langId, orgId,
//				pageable);
//		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
//				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
//				pageObject.getTotalPages());
//	}

	public APIResponse getNewLangFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> newFeildsLang = headerRepository.getNewFeildsLang(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), newFeildsLang);
	}

	public MessageStatusResponse FeildLanguageLinesRequestModel(
			@Valid List<FieldLanguageDepartmentRequest> requestInfo) {
		requestInfo.stream().forEach(req -> {
			boolean existsById = fieldLanguageDepartmentsRepository.existsById(req.getId() != null ? req.getId() : 0);
			if (existsById) {
				fieldLanguageDepartmentsRepository.save(InternelizationConverter.updateDeptReqToModel(req));
			} else {
				fieldLanguageDepartmentsRepository.save(InternelizationConverter.convertDeptReqToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public MessageStatusResponse createModifyLangFeildSrTypeLines(@Valid List<FieldLangLineServieTypeReq> requestInfo) {
		requestInfo.stream().forEach(req -> {
			boolean existsById = fieldLanguageServiceTypesRepository.existsById(req.getId());

			if (existsById) {
				fieldLanguageServiceTypesRepository.save(InternelizationConverter.modifyServiceTypeJsonToModel(req));

			} else {
				fieldLanguageServiceTypesRepository.save(InternelizationConverter.convertServiceTypeJsonToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponsePaging getSrTypeByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;

		if (enumValue.equals(FieldEnum.ALL))
			pageObject = fieldLanguageServiceTypesRepository.getAllSrTypeInfo(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = fieldLanguageServiceTypesRepository.getAllNonExistsSrTypeInfo(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = fieldLanguageServiceTypesRepository.getAllExistsSrTypeInfo(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public APIResponsePaging getDeptByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;
		if (enumValue.equals(FieldEnum.ALL))
			pageObject = fieldLanguageDepartmentsRepository.getAllFieldLangDeptInfo(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = fieldLanguageDepartmentsRepository.getAllFieldNotExistsLangDeptInfo(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = fieldLanguageDepartmentsRepository.getAllFeildExistsLangInfo(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public APIResponse getNewLangDeptFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> mappedResponse = fieldLanguageDepartmentsRepository
				.getAllFieldNotExistsLangDeptList(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), mappedResponse);
	}

	public APIResponse getNewLangsrTypeFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> mappedResponse = fieldLanguageServiceTypesRepository.getAllNonExistsSrTypeList(langId,
				orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), mappedResponse);
	}

	public MessageStatusResponse createModifyLangFeildAttahcments(
			@Valid List<FieldLangAttchmentRequestResponseModel> requestInfo) {
		requestInfo.stream().forEach(req -> {
			boolean existsById = fieldLangAttachmentsRepository.existsById(req.getId());

			if (existsById) {
				fieldLangAttachmentsRepository.save(InternelizationConverter.modifyAttchmentRequestToModel(req));

			} else {
				fieldLangAttachmentsRepository.save(InternelizationConverter.convertAttchmentRequestToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public MessageStatusResponse createModifyLangFeildDocs(@Valid List<FieldLangDocReqResModel> requestInfo) {

		requestInfo.stream().forEach(req -> {
			boolean existsById = feildLangDocRepository.existsById(req.getId());

			if (existsById) {
				feildLangDocRepository.save(InternelizationConverter.modifyDocRequestToModel(req));

			} else {
				feildLangDocRepository.save(InternelizationConverter.convertDocRequestToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse getNewLangAttchFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> newAttachmentsList = fieldLangAttachmentsRepository.getNewAttachmentsList(langId,
				orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), newAttachmentsList);
	}

	public APIResponsePaging getAttchByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;
		if (enumValue.equals(FieldEnum.ALL))
			pageObject = fieldLangAttachmentsRepository.getNewAttachMentAllPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = fieldLangAttachmentsRepository.getNewAttachMentPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = fieldLangAttachmentsRepository.getNewAttachMentNonExistsPagination(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public APIResponse getNewLangDocsFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> nullDocsList = feildLangDocRepository.getNullDocsList(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), nullDocsList);
	}

	public APIResponsePaging getDocsByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;
		if (enumValue.equals(FieldEnum.ALL))
			pageObject = feildLangDocRepository.getAllDocsPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = feildLangDocRepository.getNullDocsListPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = feildLangDocRepository.getNotNullDocsPagination(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public MessageStatusResponse createModifyLangFeildPrice(@Valid List<FeildLangPriceItemReqResModel> requestInfo) {
		requestInfo.stream().forEach(req -> {
			boolean existsById = feildLangPriceRepository.existsById(req.getId());

			if (existsById) {
				feildLangPriceRepository.save(InternelizationConverter.modifyPriceRequestToModel(req));

			} else {
				feildLangPriceRepository.save(InternelizationConverter.convertPriceRequestToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse getNewLangPriceFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> nonNullPriceList = feildLangPriceRepository.getNullPriceList(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), nonNullPriceList);
	}

	public APIResponsePaging getItemByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;
		if (enumValue.equals(FieldEnum.ALL))
			pageObject = feildLangPriceRepository.getAllPriceListPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = feildLangPriceRepository.getNullPriceListPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = feildLangPriceRepository.getNotNullPriceListPagination(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public MessageStatusResponse createModifyLangFeildTaxCategoryPrice(
			@Valid List<FieldLangTaxCategoryReqResModel> requestInfo) {
		// fieldLangPriceTaxCategoryRepository
		requestInfo.stream().forEach(req -> {
			boolean existsById = fieldLangPriceTaxCategoryRepository.existsById(req.getId());

			if (existsById) {
				fieldLangPriceTaxCategoryRepository.save(InternelizationConverter.modifyTaxCategoryRequestToModel(req));

			} else {
				fieldLangPriceTaxCategoryRepository
						.save(InternelizationConverter.convertTaxCategoryRequestToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse getNewLangTaxCategoryFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> nullTaxCategoryList = fieldLangPriceTaxCategoryRepository
				.getNullTaxCategoryList(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), nullTaxCategoryList);
	}

	public APIResponsePaging getTaxCategoryByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo,
			int pageSize, String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;
		if (enumValue.equals(FieldEnum.ALL))
			pageObject = fieldLangPriceTaxCategoryRepository.getAllTaxCategoryPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = fieldLangPriceTaxCategoryRepository.getNullTaxCategoryPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = fieldLangPriceTaxCategoryRepository.getNotNUllTaxCategoryPagination(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public MessageStatusResponse createModifyLangFeildQuestions(
			@Valid List<FieldLangQuestionsRequestResponseModel> requestInfo) {
		requestInfo.stream().forEach(req -> {
			boolean existsById = fieldLangQuestionsRepository.existsById(req.getId());

			if (existsById) {
				fieldLangQuestionsRepository.save(InternelizationConverter.modifyQuestionsRequestToModel(req));

			} else {
				fieldLangQuestionsRepository.save(InternelizationConverter.convertQuestionsRequestToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse getNewLangQuestionsFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> newLangQuestions = fieldLangQuestionsRepository.getNewLangQuestions(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), newLangQuestions);
	}

	public APIResponsePaging getQuestionByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo,
			int pageSize, String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;

		if (enumValue.equals(FieldEnum.ALL))
			pageObject = fieldLangQuestionsRepository.getAllLangQuestions(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = fieldLangQuestionsRepository.getNewLangQuestions(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = fieldLangQuestionsRepository.getExistsLangQuestions(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public MessageStatusResponse createModifyLangFeildFaqs(@Valid List<FieldLangFaqReqResponseModel> requestInfo) {
		requestInfo.stream().forEach(req -> {
			boolean existsById = feildLangFaqRepository.existsById(req.getId());

			if (existsById) {
				feildLangFaqRepository.save(InternelizationConverter.modifyFaqsRequestToModel(req));

			} else {
				feildLangFaqRepository.save(InternelizationConverter.convertFaqsRequestToModel(req));
			}
		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse getNewLangFaqsFeilds(Integer langId, Integer orgId) {
		List<Map<String, Object>> newLangRaq = feildLangFaqRepository.getNewLangFaq(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), newLangRaq);
	}

	public APIResponsePaging getFaqByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pageObject = null;

		if (enumValue.equals(FieldEnum.ALL))
			pageObject = feildLangFaqRepository.getNewAllLangfaqPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = feildLangFaqRepository.getNewLangfaqPagination(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = feildLangFaqRepository.getNewLangfaqExistsPagination(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

	public MessageStatusResponse createModifyLangFeildMasters(
			@Valid List<FieldLangMasterReqResponseModel> requestInfo) {

		requestInfo.stream().forEach(req -> {
			boolean existsById = feildLangGemMasterRepository.existsById(req.getId());
			if (existsById) {
				feildLangGemMasterRepository.save(InternelizationConverter.updateMasterRequestToModel(req));

			} else {
				feildLangGemMasterRepository.save(InternelizationConverter.convertMasterRequestToModel(req));
			}

		});
		return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
	}

	public APIResponse getNewLangMastersFeilds(Integer langId, Integer orgId) {
		List<LocalizationMasterEntity> newLangMasterFeilds = localizationMasterEntityRepository
				.getNewLangMasterFeilds(langId, orgId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), newLangMasterFeilds);
	}

	public APIResponsePaging getMasterByLanguageAndOrganization(Integer langId, Integer orgId, int pageNo, int pageSize,
			String sortBy, SortType sortType, FieldEnum enumValue) {

		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<LocalizationMasterEntity> pageObject = null;
		if (enumValue.equals(FieldEnum.NOT_EXISTS))
			pageObject = localizationMasterEntityRepository.getNewLangMasterFeilds(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.ALL))
			pageObject = localizationMasterEntityRepository.getALLangMasterFeilds(langId, orgId, pageable);
		if (enumValue.equals(FieldEnum.EXISTS))
			pageObject = localizationMasterEntityRepository.getNonNewangMasterFeilds(langId, orgId, pageable);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), pageObject.getContent(),
				Collections.emptyList(), pageObject.getNumber(), pageObject.getTotalElements(),
				pageObject.getTotalPages());
	}

}

/*
 * public APIResponse getAllInfo() {
 * 
 * return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
 * StreamSupport.stream(headerRepository.findAll().spliterator(), false)
 * .map(InternelizationConverter::convertEntityoDtoModel).collect(Collectors.
 * toList())); }
 * 
 * Sort sort = Sort.by(sortBy).descending();
 * 
 * if (sortType.equals(SortType.asc)) { sort=Sort.by(orders) }
 */
