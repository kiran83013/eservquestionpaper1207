package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.travel.travtronics.converter.ServiceAttachmentsConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.FeildLanguageAttachments;
import com.travel.travtronics.model.ServiceAttachments;
import com.travel.travtronics.repository.FieldLangAttachmentsRepository;
import com.travel.travtronics.repository.ServiceAttachmentsRepository;
import com.travel.travtronics.request.ServiceAttachmentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class ServiceAttachmentsService {

	@Autowired
	ServiceAttachmentsRepository serviceAttachemtsRepository;

	@Autowired
	FieldLangAttachmentsRepository feildLangAttachmentsRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse createAttachments(List<ServiceAttachments> attachments) {
		try {
			List<ServiceAttachments> save = serviceAttachemtsRepository.saveAll(attachments);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), save);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

//	public ResponseEntity<?> saveAndUpdate(ServiceAttachments attachments) {
//
//		try {
//			Optional<ServiceAttachments> opt = serviceAttachemtsRepository.findById(attachments.getAttachmentsId());
//			if (opt.isPresent()) {
//				attachments.setCreatedBy(opt.get().getCreatedBy());
//				attachments.setCreatedDate(opt.get().getCreatedDate());
//				return new ResponseEntity<ServiceAttachments>(serviceAttachemtsRepository.save(attachments),
//						HttpStatus.OK);
//			} else {
//				return new ResponseEntity<ServiceAttachments>(serviceAttachemtsRepository.save(attachments),
//						HttpStatus.CREATED);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//	}

	public APIResponse GetById(Long headerId) {
		List<ServiceAttachments> opt = serviceAttachemtsRepository.findByHeaderIdAndStatus(headerId, Status.Active);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);

	}

	public APIResponse getAttachmentsById(Long headerId) {
		List<Map<String, String>> opt = serviceAttachemtsRepository.findAttachmentsByHeaderId(headerId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);

	}

	public APIResponse saveAndUpdate(List<ServiceAttachmentsRequest> attachments) {
		List<ServiceAttachments> list = serviceAttachemtsRepository.saveAll(attachments.stream()
				.map(ServiceAttachmentsConverter::convertAttachmentsToModel).collect(Collectors.toList()));
		logger.info("lines-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<ServiceAttachments> menuData = serviceAttachemtsRepository.findByOrganizationId(organizationId,
					pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<ServiceAttachments> esRegister = serviceAttachemtsRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}

	public APIResponse getlocalizationInfo(Long headerId, String langCode) {

		List<ServiceAttachments> findByHeaderIdAndStatus = serviceAttachemtsRepository.findByHeaderIdAndStatus(headerId,
				Status.Active);

		List<Map<String, Object>> collectedTranformedAttahments = findByHeaderIdAndStatus.stream().map(eachAttach -> {

			ServiceAttachments response = null;
			if (!langCode.equalsIgnoreCase("en")) {
				Optional<FeildLanguageAttachments> localizationInfo = feildLangAttachmentsRepository
						.getLocalizationInfo(eachAttach.getOrganizationId().intValue(),
								eachAttach.getAttachmentsId().intValue(), langCode);

				if (localizationInfo.isPresent())
					eachAttach.setName(localizationInfo.get().getAttachmentName());
				response = eachAttach;
			} else

				response = eachAttach;

			Map<String, Object> map = new HashMap<>();
			map.put("attachmentsId", response.getAttachmentsId());
			map.put("name", response.getName());
			map.put("fileType", serviceAttachemtsRepository.getFileType(response.getAllowedExtensions()).get());
			map.put("mandatory", response.getMandatory());
			return map;

		}).collect(Collectors.toCollection(ArrayList::new));

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collectedTranformedAttahments);
	}
}
