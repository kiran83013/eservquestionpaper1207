package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.AgreementConverter;
import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Agreement;
import com.travel.travtronics.repository.AgreementRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.AgreementResponse;

@Service
public class AgreementService {

	@Autowired
	AgreementRepository agreementRepository;

	@Autowired
	EServiceRegisterCustomRepository esCustomRepository;

	public APIResponse createAgreement(Agreement agreement) {
		try {
			List<Agreement> list = new ArrayList<>();
			Agreement save = agreementRepository.save(agreement);
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
			Optional<Agreement> opt = agreementRepository.findById(id);
			List<Agreement> list = new ArrayList<>();
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

	public APIResponse editAgreement(Agreement agreement) {
		List<Agreement> list = new ArrayList<>();
		try {
			Optional<Agreement> opt = agreementRepository.findById(agreement.getAgreementId());
			if (opt.isPresent()) {
				agreement.setCreatedBy(opt.get().getCreatedBy());
				Agreement save = agreementRepository.save(agreement);
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
			List<Map<String, String>> list = agreementRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId, String name, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<Agreement> findByOrganizationId = agreementRepository.findByOrganizationId(organizationId, pageable);
//			Page<AgreementResponse> item = findByOrganizationId.map(model -> {
//				AgreementResponse response = AgreementConverter.convertAgreementToResponse(model);
//				Optional<String> categoryName = agreementRepository.getCategoryName(response.getCategory());
//				Optional<String> statusName = agreementRepository.getStatusName(response.getRecordStatus());
//				Optional<String> orgName = agreementRepository.getOrgName(response.getOrganizationId());
//				if (categoryName.isPresent())
//					response.setCategoryName(categoryName.get());
//				if (statusName.isPresent())
//					response.setStatusName(statusName.get());
//				if (orgName.isPresent())
//					response.setOrganizationName(orgName.get());
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		} else {
//			Page<Agreement> findByOrganizationId = agreementRepository.findAll(pageable);
//			Page<AgreementResponse> item = findByOrganizationId.map(model -> {
//				AgreementResponse response = AgreementConverter.convertAgreementToResponse(model);
//				Optional<String> categoryName = agreementRepository.getCategoryName(response.getCategory());
//				Optional<String> statusName = agreementRepository.getStatusName(response.getRecordStatus());
//				Optional<String> orgName = agreementRepository.getOrgName(response.getOrganizationId());
//				if (categoryName.isPresent())
//					response.setCategoryName(categoryName.get());
//				if (statusName.isPresent())
//					response.setStatusName(statusName.get());
//				if (orgName.isPresent())
//					response.setOrganizationName(orgName.get());
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		}
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<Agreement> serviceMenuTypeData = esCustomRepository.fetchAgreementPagination(name, organizationId,
				pageable, sortBy, sortType);
		Page<AgreementResponse> item = serviceMenuTypeData.map(model -> {
			AgreementResponse response = AgreementConverter.convertAgreementToResponse(model);
			Optional<String> categoryName = agreementRepository.getCategoryName(response.getCategory());
			Optional<String> statusName = agreementRepository.getStatusName(response.getRecordStatus());
			Optional<String> orgName = agreementRepository.getOrgName(response.getOrganizationId());
			if (categoryName.isPresent())
				response.setCategoryName(categoryName.get());
			if (statusName.isPresent())
				response.setStatusName(statusName.get());
			if (orgName.isPresent())
				response.setOrganizationName(orgName.get());
			return response;
		});
		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(), new ArrayList<>(),
				item.getNumber(), item.getTotalElements(), item.getTotalPages());
	}

}
