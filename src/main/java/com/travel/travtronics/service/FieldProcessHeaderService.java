package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.FieldProcessHeaderConverter;
import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.FieldProcessHeader;
import com.travel.travtronics.repository.FieldLinesRepository;
import com.travel.travtronics.repository.FieldProcessHeaderRepository;
import com.travel.travtronics.repository.ServiceTypesRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.FieldProcessHeaderResponse;

@Service
public class FieldProcessHeaderService {

	@Autowired
	FieldProcessHeaderRepository fieldProcessHeaderRepository;

	@Autowired
	FieldLinesRepository fieldLinesRepository;

	@Autowired
	ServiceTypesRepository serviceTypesRepository;

	@Autowired
	EServiceRegisterCustomRepository esCustomRepository;

	public APIResponse createFieldProcess(FieldProcessHeader field) {
		try {
			List<FieldProcessHeader> list = new ArrayList<>();
			FieldProcessHeader save = fieldProcessHeaderRepository.save(field);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

//	public APIResponse GetById(Long id) {
//		try {
//			Optional<FieldProcessHeader> opt = fieldProcessHeaderRepository.findById(id);
//			List<FieldProcessHeader> list = new ArrayList<>();
//			if (opt.isPresent()) {
//				list.add(opt.get());
//				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
//			} else {
//				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
//					new ArrayList<>());
//		}
//	}

	public APIResponse editFieldProcess(FieldProcessHeader field) {
		List<FieldProcessHeader> list = new ArrayList<>();
		try {
			Optional<FieldProcessHeader> opt = fieldProcessHeaderRepository.findById(field.getPrcId());
			if (opt.isPresent()) {
				field.setCreatedBy(opt.get().getCreatedBy());
				FieldProcessHeader save = fieldProcessHeaderRepository.save(field);
				list.add(save);
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getAll(Long organizationId) {
		try {
			List<Map<String, String>> list = fieldProcessHeaderRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getFieldProcessPagenationByOrganization(Long organizationId, String processName,
			int pageNo, int pageSize, String sortBy, SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<FieldProcessHeader> findByOrganizationId = fieldProcessHeaderRepository
//					.findByOrganizationId(organizationId, pageable);
//
//			Page<FieldProcessHeaderResponse> item = findByOrganizationId.map(model -> {
//				FieldProcessHeaderResponse response = FieldProcessHeaderConverter
//						.convertFieldProcessHeaderModelToResponse(model);
//				Optional<String> srtypeName = fieldProcessHeaderRepository.getSrTypeName(response.getSrTypeId());
//				if (srtypeName.isPresent())
//					response.setSrTypeName(srtypeName.get());
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		} else {
//			Page<FieldProcessHeader> findByOrganizationId = fieldProcessHeaderRepository.findAll(pageable);
//			Page<FieldProcessHeaderResponse> item = findByOrganizationId.map(model -> {
//				FieldProcessHeaderResponse response = FieldProcessHeaderConverter
//						.convertFieldProcessHeaderModelToResponse(model);
//				Optional<String> srtypeName = fieldProcessHeaderRepository.getSrTypeName(response.getSrTypeId());
//				if (srtypeName.isPresent())
//					response.setSrTypeName(srtypeName.get());
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<FieldProcessHeader> serviceMenuTypeData = esCustomRepository.fetchFieldProcessHeaderPagination(processName,
				organizationId, pageable, sortBy, sortType);
		Page<FieldProcessHeaderResponse> item = serviceMenuTypeData.map(model -> {
			FieldProcessHeaderResponse response = FieldProcessHeaderConverter
					.convertFieldProcessHeaderModelToResponse(model);
			Optional<String> srtypeName = fieldProcessHeaderRepository.getSrTypeName(response.getSrTypeId());
			if (srtypeName.isPresent())
				response.setSrTypeName(srtypeName.get());
			return response;
		});
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(), new ArrayList<>(),
				item.getNumber(), item.getTotalElements(), item.getTotalPages());

	}

	public APIResponse getSRTypeStatges(Integer srTypeId) {
		Map<String, Object> processObject = new HashMap<>();
		Map<String, Object> srProcessHeader = fieldProcessHeaderRepository.getSrProcessHeader(srTypeId);
		List<Map<String, Object>> srStages = fieldProcessHeaderRepository.getSrStages(srTypeId);

		processObject.put("processHeader", srProcessHeader);
		processObject.put("processLines", srStages);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(processObject));
	}

	public APIResponse getSRTypeStatgesInfo(Long srTypeId) {

		List<Map<String, Object>> collectedSrTypeStages = fieldLinesRepository.findBySrType(srTypeId).stream()
				.map(eachStage -> {

					Map<String, Object> processObject = new HashMap<>();
					Map<String, Object> srProcessHeader = fieldProcessHeaderRepository
							.getSrProcessHeader(eachStage.getParentSrType().intValue());
					List<Map<String, Object>> srStages = fieldProcessHeaderRepository
							.getSrStages(eachStage.getParentSrType().intValue());

					processObject.put("processHeader", srProcessHeader);
					processObject.put("processLines", srStages);

					return processObject;

				}).collect(Collectors.toList());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collectedSrTypeStages);
	}

	public APIResponse GetById(Long id) {
		try {
			List<Map<String, String>> list = fieldProcessHeaderRepository.findAllById(id);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}
}
