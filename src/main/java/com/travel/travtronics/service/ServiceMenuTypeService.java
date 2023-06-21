package com.travel.travtronics.service;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;

import com.travel.travtronics.model.ServiceMenuType;
import com.travel.travtronics.repository.ServiceMenuTypeRepository;
import com.travel.travtronics.repository.ServiceTypeCustomRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMenuTypeService {

	@Autowired
	ServiceMenuTypeRepository serviceMenuTypeRepository;

	@Autowired
	ServiceTypeCustomRepository serviceTypePaginationRepository;

	/*
	 * Create ServiceMenuType Data
	 */
	public APIResponse create(ServiceMenuType serviceMenuType) {
		if (serviceMenuType.getId() == null || serviceMenuType.getId() == 0) {
			ServiceMenuType serviceMenu = serviceMenuTypeRepository.save(serviceMenuType);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(serviceMenu));
		} else {
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	/*
	 * Update ServiceMenuType Data
	 */
	public APIResponse update(ServiceMenuType serviceMenuType) {
		if (serviceMenuTypeRepository.existsById(serviceMenuType.getId())) {
			ServiceMenuType serviceMenu = serviceMenuTypeRepository.save(serviceMenuType);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(serviceMenu));
		} else {
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	/*
	 * Get ServiceMenuType Data based given id
	 */
	public APIResponse getById(Long id) {
		Optional<ServiceMenuType> opt = serviceMenuTypeRepository.findById(id);
		if (opt.isPresent()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(opt));
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), new ArrayList<>());
		}
	}

	/*
	 * Get ServiceMenuType Data based given organization
	 */
	public APIResponse getByOrganization(Long id) {
		List<ServiceMenuType> opt = serviceMenuTypeRepository.findByOrganizationAndStatus(id, Status.Active);
		if (!opt.isEmpty()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),opt);
		} else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), new ArrayList<>());
		}
	}
	/*
	 * Get All ServiceMenuType Data
	 */

	public APIResponsePaging getServiceTypeMenu(String name, Long organization, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<ServiceMenuType> serviceMenuTypeData = serviceTypePaginationRepository.fetchServiceTypeMenuPagination(name,
				organization, pageable, sortBy, sortType);

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceMenuTypeData.getContent(),
				new ArrayList<>(), serviceMenuTypeData.getNumber(), serviceMenuTypeData.getTotalElements(),
				serviceMenuTypeData.getTotalPages());

//		if (name != null && !name.isEmpty()) {
//			Page<ServiceMenuType> menuData = serviceMenuTypeRepository.findByNameContaining(name, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
//					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
//		}
//		if (organization != null) {
//			Page<ServiceMenuType> menuData = serviceMenuTypeRepository.findByOrganization(organization, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
//					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
//		}
//		if (organization != null && name != null && !name.isEmpty()) {
//			Page<ServiceMenuType> menuData = serviceMenuTypeRepository.findByOrganizationAndNameContaining(organization,
//					name, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
//					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
//		} else {
//			Page<ServiceMenuType> serviceMenuTypeData = serviceMenuTypeRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceMenuTypeData.getContent(),
//					new ArrayList<>(), serviceMenuTypeData.getNumber(), serviceMenuTypeData.getTotalElements(),
//					serviceMenuTypeData.getTotalPages());
//		}
	}
}
