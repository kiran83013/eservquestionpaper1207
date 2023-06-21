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
import com.travel.travtronics.model.WarrantyExclusion;
import com.travel.travtronics.repository.WarrantyExclusionRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.WarrantyExclusionResponse;

@Service
public class WarrantyExclusionService {

	@Autowired
	WarrantyExclusionRepository warrantyExclusionRepository;

	public APIResponse createWarrantyExclusion(WarrantyExclusion exclusion) {
		try {
			List<WarrantyExclusion> list = new ArrayList<>();
			WarrantyExclusion save = warrantyExclusionRepository.save(exclusion);
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
			Optional<WarrantyExclusion> opt = warrantyExclusionRepository.findById(id);
			List<WarrantyExclusion> list = new ArrayList<>();
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

	public APIResponse editWarrantyExclusion(WarrantyExclusion exclusion) {
		List<WarrantyExclusion> list = new ArrayList<>();
		try {
			Optional<WarrantyExclusion> opt = warrantyExclusionRepository.findById(exclusion.getId());
			if (opt.isPresent()) {
				exclusion.setCreatedBy(opt.get().getCreatedBy());
				WarrantyExclusion save = warrantyExclusionRepository.save(exclusion);
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
			List<Map<String, String>> list = warrantyExclusionRepository.findAllByOrganizationId(organizationId);
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
			Page<WarrantyExclusion> findByOrganizationId = warrantyExclusionRepository
					.findByOrganizationIdAndAgreementId(organizationId,agreementId, pageable);
			Page<WarrantyExclusionResponse> item = findByOrganizationId.map(model -> {
				WarrantyExclusionResponse response = WarrantyExclusionConverter
						.convertWarrantyExclusionToResponse(model);
				Optional<String> orgName = warrantyExclusionRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = warrantyExclusionRepository.getItemName(response.getItem());
				Optional<String> agreement = warrantyExclusionRepository.getAgreementName(response.getAgreementId());
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
		} if (agreementId !=null ) {
			Page<WarrantyExclusion> findByOrganizationId = warrantyExclusionRepository
					.findByAgreementId(agreementId, pageable);
			Page<WarrantyExclusionResponse> item = findByOrganizationId.map(model -> {
				WarrantyExclusionResponse response = WarrantyExclusionConverter
						.convertWarrantyExclusionToResponse(model);
				Optional<String> orgName = warrantyExclusionRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = warrantyExclusionRepository.getItemName(response.getItem());
				Optional<String> agreement = warrantyExclusionRepository.getAgreementName(response.getAgreementId());
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
		}else {
			Page<WarrantyExclusion> findByOrganizationId = warrantyExclusionRepository.findAll(pageable);
			Page<WarrantyExclusionResponse> item = findByOrganizationId.map(model -> {
				WarrantyExclusionResponse response = WarrantyExclusionConverter
						.convertWarrantyExclusionToResponse(model);
				Optional<String> orgName = warrantyExclusionRepository.getOrgName(response.getOrganizationId());
				Optional<String> itemName = warrantyExclusionRepository.getItemName(response.getItem());
				Optional<String> agreement = warrantyExclusionRepository.getAgreementName(response.getAgreementId());
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
			List<Map<String, String>> list = warrantyExclusionRepository.findByAgreementId(agreementId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}
}
