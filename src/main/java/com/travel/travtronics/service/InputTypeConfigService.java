package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.InputTypeConfigConverter;
import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.dto.InputTypeConfigRequest;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.InputTypeConfig;
import com.travel.travtronics.repository.InputTypeConfigRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.ConfigResponse;
import com.travel.travtronics.response.InputTypeConfigResponse;
import com.travel.travtronics.response.MessageStatusResponse;

@Service
public class InputTypeConfigService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	InputTypeConfigRepository configRepository;

	@Autowired
	EServiceRegisterCustomRepository esCustomRepository;

	public MessageStatusResponse createConfig(List<InputTypeConfigRequest> models) {

		models.stream().map(InputTypeConfigConverter::convertDtoToModel).forEach(configRepository::save);

		// configRepository.save(InputTypeConfigConverter.convertDtoToModel(model));
		logger.info("created-successfully");
		return new MessageStatusResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
	}

	public MessageStatusResponse modifyConfig(InputTypeConfigRequest model, Integer id) {

		InputTypeConfig findByConfigId = configRepository.findByConfigId(id);
		if (findByConfigId == null)
			return new MessageStatusResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
		else {
			configRepository.save(InputTypeConfigConverter.updateDtoToModel(model, id));
			logger.info("modified-successfully");
			return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
		}

	}

	public APIResponse getConfig(Integer id) {
		InputTypeConfig findByConfigId = configRepository.findByConfigId(id);
		if (findByConfigId == null)
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.EMPTY_LIST);
		else
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(InputTypeConfigConverter.convertModelToResponse(findByConfigId)));
	}

	public APIResponse getConfig(Long organizationId) {
		List<ConfigResponse> response = new ArrayList<>();
		configRepository.findAllByOrganizationId(organizationId).forEach(model -> {
			ConfigResponse convertModelToResponse = InputTypeConfigConverter.convertModelToResponse(model);
			logger.info("fetching-succcesfully");
			response.add(convertModelToResponse);
		});
		List<ConfigResponse> collect = response.stream().map(res -> {
			String findByTypeId = configRepository.findByTypeId(res.getType());
			res.setTypeName(findByTypeId != null ? findByTypeId : null);
			logger.info("type-name-added-succcesfully");
			return res;
		}).collect(Collectors.toList());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collect);
	}

	public APIResponsePaging getPaginationByOrganizationId(Long organizationId, String name, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		
//		  if (organizationId != null) 
//		  { 
//			  Page<InputTypeConfig> findByOrganizationId =configRepository.findByOrganizationId(organizationId, pageable);
//			  Page<InputTypeConfigResponse> item = findByOrganizationId.map(model -> {
//			  InputTypeConfigResponse request =InputTypeConfigConverter.convertInputTypeConfigModelToRequest(model);
//			  	Optional<String> type = configRepository.getTypeName(request.getType()); 
//			  	if(type.isPresent()) 
//			  		request.setTypeName(type.get());
//			  		return request;
//			  	});
//		  			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(), new ArrayList<>(), item.getNumber(),item.getTotalElements(), item.getTotalPages());
//		  } 
//		  else {
//		  Page<InputTypeConfig> findByOrganizationId =configRepository.findAll(pageable); 
//		  Page<InputTypeConfigResponse> item =findByOrganizationId.map(model -> { 
//			  InputTypeConfigResponse request =InputTypeConfigConverter.convertInputTypeConfigModelToRequest(model);
//			  	Optional<String> type = configRepository.getTypeName(request.getType());
//			  		if(type.isPresent()) 
//			  			request.setTypeName(type.get()); 
//			  			return request; 
//			  });
//		  return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(),item.getContent(), new ArrayList<>(), item.getNumber(),item.getTotalElements(), item.getTotalPages());
//		  }
		 
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<InputTypeConfig> serviceMenuTypeData = esCustomRepository.fetchInputTypeConfigPagination(name,
				organizationId, pageable, sortBy, sortType);
		Page<InputTypeConfigResponse> item = serviceMenuTypeData.map(model -> {
			InputTypeConfigResponse request = InputTypeConfigConverter.convertInputTypeConfigModelToRequest(model);
			Optional<String> type = configRepository.getTypeName(request.getType());
			if (type.isPresent())
				request.setTypeName(type.get());
			return request;
		});
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(), new ArrayList<>(),
				item.getNumber(), item.getTotalElements(), item.getTotalPages());
	}

}
