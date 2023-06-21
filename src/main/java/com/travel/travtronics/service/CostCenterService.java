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

import com.travel.travtronics.converter.CostCenterConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CostCenter;
import com.travel.travtronics.repository.CostCenterRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.CostCenterResponse;

@Service
public class CostCenterService {

	@Autowired
	CostCenterRepository ccRepository;

	public APIResponse createCostCenter(CostCenter costcenter) {
		try {
			List<CostCenter> list = new ArrayList<>();
			CostCenter save = ccRepository.save(costcenter);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long costCenterId) {
		try {
			Optional<CostCenter> opt = ccRepository.findById(costCenterId);
			List<CostCenter> list = new ArrayList<>();
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

	public APIResponse editCostCenter(CostCenter costcenter) {
		List<CostCenter> list = new ArrayList<>();
		try {
			Optional<CostCenter> opt = ccRepository.findById(costcenter.getCostCenterId());
			if (opt.isPresent()) {
				costcenter.setCreatedBy(opt.get().getCreatedBy());
				CostCenter save = ccRepository.save(costcenter);
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

	public APIResponse getAll(Long organizatioinId) {
		try {
			List<Map<String, String>> list = ccRepository.findByList(organizatioinId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getCostCenterPagenationByOrganization(Long organizationId, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<CostCenter> findByOrganizationId = ccRepository.findByOrganizationId(organizationId, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
//					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
//					findByOrganizationId.getTotalPages());
//		} else {
//			Page<CostCenter> findAll = ccRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
//					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
//		}
		if (organizationId != null) {
			Page<CostCenter> findByOrganizationId = ccRepository.findByOrganizationId(organizationId, pageable);

			Page<CostCenterResponse> item = findByOrganizationId.map(model -> {
				CostCenterResponse response = CostCenterConverter.convertCostCenterModelToResponse(model);
				Optional<String> business = ccRepository.getBusinessUnitName(response.getBusinessUnitId());
				if (business.isPresent())
					response.setBusinessUnitName(business.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<CostCenter> findByOrganizationId = ccRepository.findAll(pageable);

			Page<CostCenterResponse> item = findByOrganizationId.map(model -> {
				CostCenterResponse response = CostCenterConverter.convertCostCenterModelToResponse(model);
				Optional<String> business = ccRepository.getBusinessUnitName(response.getBusinessUnitId());
				if (business.isPresent())
					response.setBusinessUnitName(business.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}

	public APIResponse getAllByBusinessUnitId(Long businessUnitId) {
		List<Map<String, String>> list = ccRepository.findByBusinessUnitList(businessUnitId);
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}
}
