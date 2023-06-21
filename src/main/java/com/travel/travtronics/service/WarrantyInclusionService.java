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

import com.travel.travtronics.converter.WarrantyExclusionConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.WarrantyInclusion;
import com.travel.travtronics.repository.WarrantyInclusionRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.WarrantyInclusionResponse;

@Service
public class WarrantyInclusionService {

	@Autowired
	WarrantyInclusionRepository warrantyInclusionRepository;

	public APIResponse createWarrantyInclusion(WarrantyInclusion inclusion) {
		try {
			List<WarrantyInclusion> list = new ArrayList<>();
			WarrantyInclusion save = warrantyInclusionRepository.save(inclusion);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		try {
			Optional<WarrantyInclusion> opt = warrantyInclusionRepository.findById(id);
			List<WarrantyInclusion> list = new ArrayList<>();
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

	public APIResponse editWarrantyInclusion(WarrantyInclusion inclusion) {
		List<WarrantyInclusion> list = new ArrayList<>();
		try {
			Optional<WarrantyInclusion> opt = warrantyInclusionRepository.findById(inclusion.getId());
			if (opt.isPresent()) {
				inclusion.setCreatedBy(opt.get().getCreatedBy());
				WarrantyInclusion save = warrantyInclusionRepository.save(inclusion);
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

	public APIResponse getAll(Long organizationId) {
		try {
			List<Map<String, String>> list = warrantyInclusionRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId,Long agreementId, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<WarrantyInclusion> findByOrganizationId = warrantyInclusionRepository
					.findByOrganizationIdAndAgreementId(organizationId,agreementId, pageable);
			Page<WarrantyInclusionResponse> item = findByOrganizationId.map(model -> {
				WarrantyInclusionResponse response = WarrantyExclusionConverter
						.convertWarrantyInclusionToResponse(model);
				Optional<String> orgName = warrantyInclusionRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = warrantyInclusionRepository.getItemName(response.getItem());
				Optional<String> agreement = warrantyInclusionRepository.getAgreementName(response.getAgreementId());
				if (orgName.isPresent())
					response.setOrganizationName(orgName.get());
				if (itemName.isPresent())
					response.setItemName(itemName.get());
				if (agreement.isPresent())
					response.setAgreementName(agreement.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}if (agreementId!=null) {
			Page<WarrantyInclusion> findByOrganizationId = warrantyInclusionRepository
					.findByAgreementId(agreementId, pageable);
			Page<WarrantyInclusionResponse> item = findByOrganizationId.map(model -> {
				WarrantyInclusionResponse response = WarrantyExclusionConverter
						.convertWarrantyInclusionToResponse(model);
				Optional<String> orgName = warrantyInclusionRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = warrantyInclusionRepository.getItemName(response.getItem());
				Optional<String> agreement = warrantyInclusionRepository.getAgreementName(response.getAgreementId());
				if (orgName.isPresent())
					response.setOrganizationName(orgName.get());
				if (itemName.isPresent())
					response.setItemName(itemName.get());
				if (agreement.isPresent())
					response.setAgreementName(agreement.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages()); 
		}
		else{
			Page<WarrantyInclusion> findByOrganizationId = warrantyInclusionRepository.findAll(pageable);
			Page<WarrantyInclusionResponse> item = findByOrganizationId.map(model -> {
			WarrantyInclusionResponse response = WarrantyExclusionConverter
					.convertWarrantyInclusionToResponse(model);
			Optional<String> orgName = warrantyInclusionRepository.getOrgName(response.getOrganizationId());
			Optional<String> itemName = warrantyInclusionRepository.getItemName(response.getItem());
			Optional<String> agreement = warrantyInclusionRepository.getAgreementName(response.getAgreementId());
			if (orgName.isPresent())
				response.setOrganizationName(orgName.get());
			if (itemName.isPresent())
				response.setItemName(itemName.get());
			if (agreement.isPresent())
				response.setAgreementName(agreement.get());
			return response;
		});
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
				new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}

	public APIResponse getAllByAgreementId(Long agreementId) {
		try {
			List<Map<String, String>> list = warrantyInclusionRepository.findAllByAgreementId(agreementId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}
}
