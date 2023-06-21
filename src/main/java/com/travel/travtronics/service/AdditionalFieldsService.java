package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.travel.travtronics.converter.InputTypeConfigConverter;
import com.travel.travtronics.converter.ServiceTypeConveter;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.AdditionalFields;
import com.travel.travtronics.model.InputTypeConfig;
import com.travel.travtronics.repository.AdditionalFieldsRepository;
import com.travel.travtronics.repository.InputTypeConfigRepository;
import com.travel.travtronics.request.AdditionalFieldsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.AdditionalFieldsResponse;
import com.travel.travtronics.response.ConfigResponse;

@Service
public class AdditionalFieldsService {

	@Autowired
	AdditionalFieldsRepository additionalFieldsRepository;
	
	@Autowired
	InputTypeConfigRepository configRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse additionalFields(List<AdditionalFieldsRequest> requestModels) {
		List<AdditionalFields> saveAll = additionalFieldsRepository.saveAll(requestModels.stream()
				.map(ServiceTypeConveter::convertLineRequestAdditionalFieldToModel).collect(Collectors.toList()));
		logger.info("lines-modified");

		List<AdditionalFieldsResponse> collect = saveAll.stream()
				.map(ServiceTypeConveter::convertAdditionalFieldModelToJson).peek(model -> {
					model.setConigModel(fetchInputConfigWithType(model.getField()));

				}).collect(Collectors.toList());

		logger.info("lines-resposne-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
	}

	public APIResponse getadditionalFieldsByHeaderId(Long headerId, Long isPricing) {
		
		List<AdditionalFieldsResponse> collect = additionalFieldsRepository
				.findAllByHeaderIdAndStatus(headerId, Status.Active).stream()
				.map(ServiceTypeConveter::convertAdditionalFieldModelToJson).peek(model -> {
					model.setConigModel(fetchInputConfigWithType(model.getField()));

				}).collect(Collectors.toList());

		if (!collect.isEmpty()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}
	}
	
	public ConfigResponse fetchInputConfigWithType(Integer configId) {
		ConfigResponse response = new ConfigResponse();
		InputTypeConfig configModel = configRepository.findByConfigId(configId != null ? configId : 0);
		response = InputTypeConfigConverter
				.convertModelToResponse(configModel != null ? configModel : new InputTypeConfig());
		String findByTypeId = configRepository.findByTypeId(response.getType() != null ? response.getType() : 0);
		response.setTypeName(findByTypeId != null ? findByTypeId : null);
		return response;
	}
//		try {
//			if (headerId != null && headerId != 0 && isPricing != null) {
//				List<AdditionalFields> findAllByHeaderIdAndStatusAndIsPricing = additionalFieldsRepository.findAllByHeaderIdAndStatusAndIsPricing(headerId, Status.Active, isPricing);
//				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), findAllByHeaderIdAndStatusAndIsPricing);
//			} else {
//				List<AdditionalFields> findAllByHeaderIdAndStatus = additionalFieldsRepository.findAllByHeaderIdAndStatus(headerId, Status.Active);
//				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), findAllByHeaderIdAndStatus);
//			}
//		} catch (Exception e) {
//			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), new ArrayList<>());
//		}
//		
//	}

	public APIResponse getadditionalFieldsByHeaderIdAndTransitionId(Long headerId, Long transitionId) {
		
		List<AdditionalFields> serviceLines = additionalFieldsRepository.findAllByHeaderIdAndTransitionIdAndStatus(headerId, transitionId, Status.Active);
		if (!serviceLines.isEmpty()) {
			List<String> collect = serviceLines.stream().map(model -> model.getFormData()).collect(Collectors.toList());

			List<Map<String, Object>> mapList = new ArrayList<>();
			collect.forEach(model -> {

				try {
					@SuppressWarnings("unchecked")
					Map<String, Object> map = new ObjectMapper().readValue(model, Map.class);
					logger.info("convert-string-to-json");
					mapList.add(map);
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), mapList);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
		}

	}
//		List<AdditionalFieldsResponse> collect = additionalFieldsRepository
//				.findAllByHeaderIdAndTransitionIdAndStatus(headerId, transitionId, Status.Active).stream()
//				.map(ServiceTypeConveter::convertAdditionalFieldModelToJson1).peek(model -> {
//					model.setConigModel(fetchInputConfigWithType(model.getField()));
//
//				}).collect(Collectors.toList());
//
//		if (!collect.isEmpty()) {
//			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
//		} else {
//			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.EMPTY_LIST);
//		}
//	}
	
}
