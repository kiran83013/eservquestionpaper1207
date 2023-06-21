package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.travel.travtronics.converter.ServiceDocumentsConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.exception.NotFoundException;
import com.travel.travtronics.model.FieldLangDocuments;
import com.travel.travtronics.model.ServiceDocuments;
import com.travel.travtronics.repository.FieldLangDocumentsRepository;
import com.travel.travtronics.repository.ServiceDocumentsRepository;
import com.travel.travtronics.request.ServiceDocumentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class ServiceDocumentsService {

	@Autowired
	ServiceDocumentsRepository serviceDocumentsRepository;

	@Autowired
	FieldLangDocumentsRepository feildLangDocsRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse createDocument(List<ServiceDocuments> documents) {
		try {
			List<ServiceDocuments> save = serviceDocumentsRepository.saveAll(documents);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), save);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long headerId) {
		List<ServiceDocuments> opt = serviceDocumentsRepository.findByHeaderIdAndStatus(headerId, Status.Active);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);

	}

	public APIResponse saveAndUpdate(List<ServiceDocumentsRequest> documents) {
		List<ServiceDocuments> list = serviceDocumentsRepository.saveAll(documents.stream()
				.map(ServiceDocumentsConverter::convertDocumentsToModel).collect(Collectors.toList()));
		logger.info("lines-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<ServiceDocuments> menuData = serviceDocumentsRepository.findByOrganizationId(organizationId, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<ServiceDocuments> esRegister = serviceDocumentsRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}

	public APIResponse feildLocalizationDocs(Long headerId, String langCode) {
		List<ServiceDocuments> collectedTrabfomesDocsList = serviceDocumentsRepository
				.findByHeaderIdAndStatus(headerId, Status.Active).stream().map(eachDoc -> {

					if (!langCode.equalsIgnoreCase("en")) {

						Optional<FieldLangDocuments> localizationInfo = feildLangDocsRepository.getLocalizationInfo(
								eachDoc.getOrganizationId().intValue(), eachDoc.getId().intValue(), langCode);
						if (localizationInfo.isPresent())
							eachDoc.setName(localizationInfo.get().getDocName());

						return eachDoc;
					} else
						return eachDoc;

				}).collect(Collectors.toCollection(() -> new ArrayList<>()));
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collectedTrabfomesDocsList);
	}

}
