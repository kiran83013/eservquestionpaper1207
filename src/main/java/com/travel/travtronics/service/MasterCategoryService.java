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
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.travel.travtronics.enums.Query;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.MasterCategory;
import com.travel.travtronics.repository.MasterCategoryRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class MasterCategoryService {

	@Autowired
	MasterCategoryRepository masterCategoryRepository;

	public APIResponse createMasterCategory(MasterCategory model) {
		List<MasterCategory> list = new ArrayList<>();
		try {
//
//			String tableName = "master_" + model.getName().replaceAll("\\s+", "_").toLowerCase();
//			model.setSchemaKey(tableName);
//
//			ResponseEntity<?> tableCreate = tableCreate(tableName);

			/*--creat-table-schema-name*/
//			if (tableCreate.getStatusCodeValue() == 200) {

				MasterCategory save = masterCategoryRepository.save(model);
				list.add(save);

//			}
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getById(Long categoryId) {
		List<MasterCategory> list = new ArrayList<>();
		try {
			Optional<MasterCategory> opt = masterCategoryRepository.findByCategoryId(categoryId);
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

	public APIResponse getCategory(Long organizationId) {
		try {
			List<Map<String, String>> list = masterCategoryRepository.findAllByOrganizationIdId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse editCategoryType(MasterCategory model) {
		List<MasterCategory> list = new ArrayList<>();
		try {
			Optional<MasterCategory> opt = masterCategoryRepository.findByCategoryId(model.getCategoryId());
			if (opt.isPresent()) {
				model.setCreatedBy(opt.get().getCreatedBy());
				MasterCategory save = masterCategoryRepository.save(model);
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

	@Autowired
	JdbcTemplate jt;

	public ResponseEntity<?> tableCreate(String tableName) {
		String sql = String.format(Query.CREATE_TABLE_SCHEMA, tableName);
		jt.execute(sql);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public APIResponsePaging getMasterCategoryPagenationByOrganization(Long organizationId, int pageNo, int pageSize,String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<MasterCategory> findByOrganizationId = masterCategoryRepository.findByOrganizationId(organizationId, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
					findByOrganizationId.getTotalPages());
		} else {
			Page<MasterCategory> findAll = masterCategoryRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
		}
	}
}
