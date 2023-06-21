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

import com.travel.travtronics.converter.CustomerActivitiyConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CustomerActivity;
import com.travel.travtronics.model.CustomerSegments;
import com.travel.travtronics.repository.CustomerActivityRepository;
import com.travel.travtronics.repository.CustomerSegmentsRepository;
import com.travel.travtronics.request.CustomerActivitiyRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class CustomerActivityService {

	@Autowired
	CustomerActivityRepository caRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse Create(List<CustomerActivity> activity) {
		try {
			List<CustomerActivity> list = new ArrayList<>();
			List<CustomerActivity> save = caRepository.saveAll(activity);
			list.addAll(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		List<CustomerActivity> list = new ArrayList<>();
		try {
			Optional<CustomerActivity> opt = caRepository.findById(id);
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
			List<CustomerActivity> list = caRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse editActivity(List<CustomerActivitiyRequest> activity) {
		List<CustomerActivity> list = caRepository.saveAll(
				activity.stream().map(CustomerActivitiyConverter::convertActivityToModel).collect(Collectors.toList()));
		logger.info("activity-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	@Autowired
	CustomerSegmentsRepository csRepository;

	public APIResponsePaging getCustomerActivityPagenationByOrganization(Long organizationId, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<CustomerActivity> findByOrganizationId = caRepository.findByOrganizationId(organizationId, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
//					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
//					findByOrganizationId.getTotalPages());
//		} else {
//			Page<CustomerActivity> findAll = caRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
//					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
//		}
//	}

		if (organizationId != null) {
			Page<CustomerActivity> findByOrganizationId = caRepository.findByOrganizationId(organizationId, pageable);

			Page<CustomerActivitiyRequest> item = findByOrganizationId.map(model -> {
				CustomerActivitiyRequest request = CustomerActivitiyConverter
						.convertCustomerActivitiyModelToRequest(model);
				Optional<CustomerSegments> findById = csRepository.findById(request.getSegmentId());
				request.setSegmentName(findById.isPresent() ? findById.get().getSegmentName() : null);
				Optional<String> language = caRepository.getLanguageName(request.getLanguage());
				if (language.isPresent())
					request.setLanguageName(language.get());
				return request;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<CustomerActivity> findByOrganizationId = caRepository.findAll(pageable);

			Page<CustomerActivitiyRequest> item = findByOrganizationId.map(model -> {
				CustomerActivitiyRequest request = CustomerActivitiyConverter
						.convertCustomerActivitiyModelToRequest(model);
				Optional<CustomerSegments> findById = csRepository.findById(request.getSegmentId());
				request.setSegmentName(findById.isPresent() ? findById.get().getSegmentName() : null);
				Optional<String> language = caRepository.getLanguageName(request.getLanguage());
				if (language.isPresent())
					request.setLanguageName(language.get());
				return request;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}

}
