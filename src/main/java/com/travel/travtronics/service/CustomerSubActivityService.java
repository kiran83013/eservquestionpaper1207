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

import com.travel.travtronics.converter.CustomerSubActivitiyConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CustomerActivity;
import com.travel.travtronics.model.CustomerSubActivity;
import com.travel.travtronics.repository.CustomerActivityRepository;
import com.travel.travtronics.repository.CustomerSubActivityRepository;
import com.travel.travtronics.request.CustomerSubActivityRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class CustomerSubActivityService {

	@Autowired
	CustomerSubActivityRepository csaRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse Create(List<CustomerSubActivity> subactivity) {
		try {
			List<CustomerSubActivity> list = new ArrayList<>();
			List<CustomerSubActivity> save = csaRepository.saveAll(subactivity);
			list.addAll(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		List<CustomerSubActivity> list = new ArrayList<>();
		try {
			Optional<CustomerSubActivity> opt = csaRepository.findById(id);
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

	public APIResponse editSubActivity(List<CustomerSubActivityRequest> subactivity) {
		List<CustomerSubActivity> list = csaRepository.saveAll(subactivity.stream()
				.map(CustomerSubActivitiyConverter::convertSubActivityToModel).collect(Collectors.toList()));
		logger.info("activity-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponse getAll(Long organizationId) {
		try {
			List<CustomerSubActivity> list = csaRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	@Autowired
	CustomerActivityRepository caRepository;

	public APIResponsePaging getCustomerSubActivityPagenationByOrganization(Long organizationId, int pageNo,
			int pageSize, String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
//			Page<CustomerSubActivity> findByOrganizationId = csaRepository.findByOrganizationId(organizationId, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
//					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
//					findByOrganizationId.getTotalPages());
//		} else {
//			Page<CustomerSubActivity> findAll = csaRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
//					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
//		}
			Page<CustomerSubActivity> findByOrganizationId = csaRepository.findByOrganizationId(organizationId,pageable);
			Page<CustomerSubActivityRequest> item = findByOrganizationId.map(model -> {
				CustomerSubActivityRequest request = CustomerSubActivitiyConverter.convertCustomerSubActivitiyModelToRequest(model);
				Optional<CustomerActivity> findById = caRepository.findById(request.getActivityId());
				request.setActivityName(findById.isPresent() ? findById.get().getActivityName() : null);
				Optional<String> language = csaRepository.getLanguageName(request.getLanguage());
				if (language.isPresent())
					request.setLanguageName(language.get());
				return request;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<CustomerSubActivity> findByOrganizationId = csaRepository.findAll(pageable);
			Page<CustomerSubActivityRequest> item = findByOrganizationId.map(model -> {
				CustomerSubActivityRequest request = CustomerSubActivitiyConverter.convertCustomerSubActivitiyModelToRequest(model);
				Optional<CustomerActivity> findById = caRepository.findById(request.getActivityId());
				request.setActivityName(findById.isPresent() ? findById.get().getActivityName() : null);
				Optional<String> language = csaRepository.getLanguageName(request.getLanguage());
				if (language.isPresent())
					request.setLanguageName(language.get());
				return request;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}
}