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

import com.travel.travtronics.converter.ServiceContractToItemConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.ServiceContractToItem;
import com.travel.travtronics.repository.ServiceContractToItemRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.ServiceContractToItemResponse;

@Service
public class ServiceContractToItemService {

	@Autowired
	ServiceContractToItemRepository serviceContractToItemRepository;

	public APIResponse create(ServiceContractToItem item) {
		try {
			List<ServiceContractToItem> list = new ArrayList<>();
			ServiceContractToItem save = serviceContractToItemRepository.save(item);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

//	public APIResponse GetById(Long id) {
//		try {
//			Optional<ServiceContractToItem> opt = serviceContractToItemRepository.findById(id);
//			List<ServiceContractToItem> list = new ArrayList<>();
//			if (opt.isPresent()) {
//				list.add(opt.get());
//				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
//			} else {
//				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
//					new ArrayList<>());
//		}
//	}

	public APIResponse edit(ServiceContractToItem item) {
		List<ServiceContractToItem> list = new ArrayList<>();
		try {
			Optional<ServiceContractToItem> opt = serviceContractToItemRepository.findById(item.getId());
			if (opt.isPresent()) {
				item.setCreatedBy(opt.get().getCreatedBy());
				ServiceContractToItem save = serviceContractToItemRepository.save(item);
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

	public APIResponse getAll(Long organization) {
		try {
			List<Map<String, String>> list = serviceContractToItemRepository.findAllByOrganization(organization);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getPagenationByOrganization(Long organization, int pageNo, int pageSize, String sortBy,SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organization != null) {
			Page<ServiceContractToItem> findByOrganizationId = serviceContractToItemRepository.findByOrganization(organization, pageable);
			Page<ServiceContractToItemResponse> item = findByOrganizationId.map(model -> {
				ServiceContractToItemResponse response = ServiceContractToItemConverter
						.convertServiceContractToItemModelToResponse(model);
				Optional<String> orgName = serviceContractToItemRepository.getOrgName(response.getOrganization());
				Optional<String> itemName = serviceContractToItemRepository.getItemName(response.getItem());
				Optional<String> agreement = serviceContractToItemRepository.getAgreementName(response.getAgreement());
				Optional<String> business = serviceContractToItemRepository
						.getBusinessUnitName(response.getBusinessUnit());
				Optional<String> costcenter = serviceContractToItemRepository
						.getCostCenterName(response.getCostCenter());
				Optional<String> locality = serviceContractToItemRepository.getLocalityName(response.getLocality());
				Optional<String> status = serviceContractToItemRepository.getStatusName(response.getWfstatus());
				if (orgName.isPresent())
					response.setOrganizationName(orgName.get());
				if (itemName.isPresent())
					response.setItemName(itemName.get());
				if (agreement.isPresent())
					response.setAgreementName(agreement.get());
				if (business.isPresent())
					response.setBusinessUnitName(business.get());
				if (costcenter.isPresent())
					response.setCostCenterName(costcenter.get());
				if (locality.isPresent())
					response.setLocationName(locality.get());
				if (status.isPresent())
					response.setWfStatusName(status.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<ServiceContractToItem> findByOrganizationId = serviceContractToItemRepository.findAll(pageable);
			Page<ServiceContractToItemResponse> item = findByOrganizationId.map(model -> {
				ServiceContractToItemResponse response = ServiceContractToItemConverter
						.convertServiceContractToItemModelToResponse(model);
				Optional<String> orgName = serviceContractToItemRepository.getOrgName(response.getOrganization());
				Optional<String> itemName = serviceContractToItemRepository.getItemName(response.getItem());
				Optional<String> agreement = serviceContractToItemRepository.getAgreementName(response.getAgreement());
				Optional<String> business = serviceContractToItemRepository
						.getBusinessUnitName(response.getBusinessUnit());
				Optional<String> costcenter = serviceContractToItemRepository
						.getCostCenterName(response.getCostCenter());
				Optional<String> locality = serviceContractToItemRepository.getLocalityName(response.getLocality());
				Optional<String> status = serviceContractToItemRepository.getStatusName(response.getWfstatus());
				if (orgName.isPresent())
					response.setOrganizationName(orgName.get());
				if (itemName.isPresent())
					response.setItemName(itemName.get());
				if (agreement.isPresent())
					response.setAgreementName(agreement.get());
				if (business.isPresent())
					response.setBusinessUnitName(business.get());
				if (costcenter.isPresent())
					response.setCostCenterName(costcenter.get());
				if (locality.isPresent())
					response.setLocationName(locality.get());
				if (status.isPresent())
					response.setWfStatusName(status.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}

	public APIResponse GetById(Long id) {
		try {
			List<Map<String, String>> list = serviceContractToItemRepository.findAllById(id);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

}
