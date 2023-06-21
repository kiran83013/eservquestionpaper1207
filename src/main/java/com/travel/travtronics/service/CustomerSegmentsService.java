package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

import com.travel.travtronics.converter.CustomerSegmentsRequestConverter;
import com.travel.travtronics.converter.ServiceSegmentsConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CustomerSegments;
import com.travel.travtronics.repository.CustomerSegmentsRepository;
import com.travel.travtronics.request.CustomerSegmentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class CustomerSegmentsService {

	@Autowired
	CustomerSegmentsRepository csRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse Create(List<CustomerSegments> segments) {
		try {
			List<CustomerSegments> list = new ArrayList<>();
			List<CustomerSegments> save = csRepository.saveAll(segments);
			list.addAll(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		List<CustomerSegments> list = new ArrayList<>();
		try {
			Optional<CustomerSegments> opt = csRepository.findById(id);
			if (opt.isPresent()) {
				list.add(opt.get());
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
			List<CustomerSegments> list = csRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse editSegments(List<CustomerSegmentsRequest> segments) {
		List<CustomerSegments> list = csRepository.saveAll(
				segments.stream().map(ServiceSegmentsConverter::convertSegmentsToModel).collect(Collectors.toList()));
		logger.info("lines-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponsePaging getCustomerSegmentsPagenationByOrganization(Long organizationId, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<CustomerSegments> findByOrganizationId = csRepository.findByOrganizationId(organizationId, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
//					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
//					findByOrganizationId.getTotalPages());
//		} else {
//			Page<CustomerSegments> findAll = csRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
//					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
//		}

		if (organizationId != null) {
			Page<CustomerSegments> findByOrganizationId = csRepository.findByOrganizationId(organizationId, pageable);
			Page<CustomerSegmentsRequest> item = findByOrganizationId.map(model -> {
				CustomerSegmentsRequest request = CustomerSegmentsRequestConverter
						.convertCustomerActivitiyModelToRequest(model);
				Optional<String> language = csRepository.getLanguageName(request.getLanguage());
				if (language.isPresent())
					request.setLanguageName(language.get());
				return request;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<CustomerSegments> findByOrganizationId = csRepository.findAll(pageable);
			Page<CustomerSegmentsRequest> item = findByOrganizationId.map(model -> {
				CustomerSegmentsRequest request = CustomerSegmentsRequestConverter
						.convertCustomerActivitiyModelToRequest(model);
				Optional<String> language = csRepository.getLanguageName(request.getLanguage());
				if (language.isPresent())
					request.setLanguageName(language.get());
				return request;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}
}
