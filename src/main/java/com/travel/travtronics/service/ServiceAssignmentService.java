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

import com.travel.travtronics.converter.ServiceAssignmentConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.ServiceAssignment;
import com.travel.travtronics.repository.ServiceAssignmentRepository;
import com.travel.travtronics.request.ServiceAssignmentRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class ServiceAssignmentService {

	@Autowired
	ServiceAssignmentRepository serviceAssignmentRepository;
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse saveAndUpdate(List<ServiceAssignmentRequest> serviceAssignments) {
		List<ServiceAssignment> list = serviceAssignmentRepository.saveAll(serviceAssignments.stream()
				.map(ServiceAssignmentConverter::convertAssignmentToModel).collect(Collectors.toList()));
		logger.info("assignments-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponse getHeaderById(Long headerId) {
		List<ServiceAssignment> opt = serviceAssignmentRepository.findByHeaderIdAndStatus(headerId, Status.Active);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);

	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null ) {
			Page<ServiceAssignment> menuData = serviceAssignmentRepository.findByOrganizationId(organizationId, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<ServiceAssignment> esRegister = serviceAssignmentRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}
}
