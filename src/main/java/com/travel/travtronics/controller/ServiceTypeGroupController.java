package com.travel.travtronics.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.converter.ServiceTypeGroupConverter;
import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Departments;
import com.travel.travtronics.model.ServiceTypeGroup;
import com.travel.travtronics.repository.DepartmentsRepository;
import com.travel.travtronics.repository.ServiceTypeGroupRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.ServiceTypeGroupResponse;

@RestController
@RequestMapping("service-type-group")
public class ServiceTypeGroupController {
	@Autowired
	ServiceTypeGroupRepository serviceTypeGroupRepository;

	@Autowired
	EServiceRegisterCustomRepository esCustomRepository;

	@PostMapping(value = "create")
	public APIResponse createSTG(@RequestBody ServiceTypeGroup model) {
		ServiceTypeGroup serviceTypeGroup = serviceTypeGroupRepository.save(model);
		return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(),
				Collections.singletonList(serviceTypeGroup));
	}

	@GetMapping(value = "find/{id}")
	public APIResponse findSTG(@PathVariable Long id) {
		Optional<ServiceTypeGroup> serviceTypeGroup = serviceTypeGroupRepository.findById(id);
		if (serviceTypeGroup.isPresent()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(serviceTypeGroup));
		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	@GetMapping(value = "find-by-department/{id}")
	public APIResponse findByDepartmentSTG(@PathVariable Long id) {
		List<ServiceTypeGroup> serviceTypeGroup = serviceTypeGroupRepository.findByDepartmentAndStatus(id,
				Status.Active);
		if (!serviceTypeGroup.isEmpty()) {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceTypeGroup);
		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	@GetMapping(value = "get-all-by-organizationId")
	public APIResponse getAll(@RequestParam Long organizationId) {
		List<ServiceTypeGroup> serviceTypeGroup = serviceTypeGroupRepository.findAllByOrganizationId(organizationId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceTypeGroup);
	}

	@PutMapping(value = "update")
	public APIResponse update(@RequestBody ServiceTypeGroup model) {
		Optional<ServiceTypeGroup> serviceTypeGroup = serviceTypeGroupRepository.findById(model.getId());
		if (serviceTypeGroup.isPresent()) {
			ServiceTypeGroup service = serviceTypeGroupRepository.save(model);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(service));
		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	@Autowired
	DepartmentsRepository dRepository;

	@GetMapping(value = "/get-pagenation-by-organization")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId,
			@RequestParam(required = false) String name, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {

//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//
//		if (organizationId != null) {
//			Page<ServiceTypeGroup> findByOrganizationId = serviceTypeGroupRepository.findByOrganizationId(organizationId, pageable);
//			Page<ServiceTypeGroupResponse> item = findByOrganizationId.map(model -> {
//				ServiceTypeGroupResponse response = ServiceTypeGroupConverter.convertServiceTypeGroupModelToResponse(model);
//				Optional<Departments> findById = dRepository.findById(response.getDepartment());
//				response.setDepartmentName(findById.isPresent() ? findById.get().getName() : null);
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		} else {
//			Page<ServiceTypeGroup> findByOrganizationId = serviceTypeGroupRepository.findAll(pageable);
//			Page<ServiceTypeGroupResponse> item = findByOrganizationId.map(model -> {
//				ServiceTypeGroupResponse response = ServiceTypeGroupConverter.convertServiceTypeGroupModelToResponse(model);
//				Optional<Departments> findById = dRepository.findById(response.getDepartment());
//				response.setDepartmentName(findById.isPresent() ? findById.get().getName() : null);
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		}

		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<ServiceTypeGroup> serviceMenuTypeData = esCustomRepository.fetchServiceTypeGroupPagination(name,
				organizationId, pageable, sortBy, sortType);
		Page<ServiceTypeGroupResponse> item = serviceMenuTypeData.map(model -> {
			ServiceTypeGroupResponse response = ServiceTypeGroupConverter.convertServiceTypeGroupModelToResponse(model);
			Optional<Departments> findById = dRepository.findById(response.getDepartment());
			response.setDepartmentName(findById.isPresent() ? findById.get().getName() : null);
			return response;
		});
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(), new ArrayList<>(),
				item.getNumber(), item.getTotalElements(), item.getTotalPages());
	}

}
