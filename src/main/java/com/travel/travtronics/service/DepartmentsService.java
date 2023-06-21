package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Departments;
import com.travel.travtronics.repository.DepartmentsRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
@Service
public class DepartmentsService {

	@Autowired
	DepartmentsRepository departmentsRepository;

	public APIResponse create(Departments model) {
		try {
			List<Departments> list = new ArrayList<>();
			Departments save = departmentsRepository.save(model);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), new ArrayList<>());
		}
	}

	public APIResponse list(Long organizationId) {
		try {
			List<Map<String,String>> list = departmentsRepository.findAllList(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), new ArrayList<>());
		}
		
	}

	public APIResponse getById(Long departmentId) {
		List<Departments> list = new ArrayList<>();
		try {
			Optional<Departments> id = departmentsRepository.findByDepartmentId(departmentId);
			if (id.isPresent()) {
				list.add(id.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), new ArrayList<>());
		}
	}

	public APIResponse update(Departments model) {
		List<Departments> list = new ArrayList<>();
		try {
			Optional<Departments> id = departmentsRepository.findByDepartmentId(model.getDepartmentId());
			if (id.isPresent()) {
				model.setCreatedBy(id.get().getCreatedBy());
				Departments save = departmentsRepository.save(model);
				list.add(save);
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(), new ArrayList<>());
		}
		
	}

	public APIResponse getByOrganizationId(Long organizationId) {
		List<Map<String,String>> list = departmentsRepository.findByOrganizationId(organizationId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponsePaging getDepartmentPagenationByOrganization(Long organizationId, int pageNo, int pageSize,String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<Departments> findByOrganizationId = departmentsRepository.findByOrganizationId(organizationId, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
					findByOrganizationId.getTotalPages());
		} else {
			Page<Departments> findAll = departmentsRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
		}
	}
	
}
