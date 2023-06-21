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

import com.travel.travtronics.converter.AmenitiesFormConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.AmenitiesForm;
import com.travel.travtronics.repository.AmenitiesFormRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.AmenitiesFormResponse;

@Service
public class AmenitiesFormService {

	@Autowired
	AmenitiesFormRepository amenitiesformRepository;

	public APIResponse createAmenities(AmenitiesForm amenities) {
		try {
			List<AmenitiesForm> list = new ArrayList<>();
			AmenitiesForm save = amenitiesformRepository.save(amenities);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long amenitiesFormId) {
		try {
			Optional<AmenitiesForm> opt = amenitiesformRepository.findById(amenitiesFormId);
			List<AmenitiesForm> list = new ArrayList<>();
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

	public APIResponse editLocation(AmenitiesForm amenities) {
		List<AmenitiesForm> list = new ArrayList<>();
		try {
			Optional<AmenitiesForm> opt = amenitiesformRepository.findById(amenities.getAmenitiesFormId());
			if (opt.isPresent()) {
				amenities.setCreatedBy(opt.get().getCreatedBy());
				AmenitiesForm save = amenitiesformRepository.save(amenities);
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
			List<Map<String, String>> list = amenitiesformRepository.findByList(organizationId);
//			List<AmenitiesForm> list = amenitiesformRepository.findAll();
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

//	public APIResponsePaging getAmenitiesFormPagenationByOrganization(Long organizationId, int pageNo, int pageSize,String sortBy, SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<AmenitiesForm> findByOrganizationId = amenitiesformRepository.findByOrganizationId(organizationId, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
//					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
//					findByOrganizationId.getTotalPages());
//		} else {
//			Page<AmenitiesForm> findAll = amenitiesformRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
//					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
//		}
//	}

	public APIResponsePaging getAmenitiesFormPagenationByOrganization(Long organizationId, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<AmenitiesForm> findByOrganizationId = amenitiesformRepository.findByOrganizationId(organizationId,
					pageable);

			Page<AmenitiesFormResponse> item = findByOrganizationId.map(model -> {
				AmenitiesFormResponse response = AmenitiesFormConverter.convertAmenitiesModelToResponse(model);
				Optional<String> findById = amenitiesformRepository.getTypeyName(response.getTypeId());
				Optional<String> category = amenitiesformRepository.getCategoryName(response.getCategoryId());
				if (findById.isPresent())
					response.setTypeName(findById.get());
				if (category.isPresent())
					response.setCategoryName(category.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} else {
			Page<AmenitiesForm> findByOrganizationId = amenitiesformRepository.findAll(pageable);
			Page<AmenitiesFormResponse> item = findByOrganizationId.map(model -> {
				AmenitiesFormResponse response = AmenitiesFormConverter.convertAmenitiesModelToResponse(model);
				Optional<String> findById = amenitiesformRepository.getTypeyName(response.getTypeId());
				Optional<String> category = amenitiesformRepository.getCategoryName(response.getCategoryId());
				if (findById.isPresent())
					response.setTypeName(findById.get());
				if (category.isPresent())
					response.setCategoryName(category.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}
}
