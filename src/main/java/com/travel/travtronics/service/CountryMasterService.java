package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.CountryMasterConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.CountryMaster;
import com.travel.travtronics.repository.CountryMasterRepository;
import com.travel.travtronics.request.CountryMasterRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

@Service
public class CountryMasterService {

	@Autowired
	CountryMasterRepository cmRepository;

	public APIResponse createCountry(List<CountryMaster> country) {
		try {
			List<CountryMaster> list = new ArrayList<>();
			List<CountryMaster> save = cmRepository.saveAll(country);
			list.addAll(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		try {
			Optional<CountryMaster> opt = cmRepository.findById(id);
			List<CountryMaster> list = new ArrayList<>();
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

//	public APIResponse editCountry(CountryMaster country) {
//		List<CountryMaster> list = new ArrayList<>();
//		try {
//			Optional<CountryMaster> opt = cmRepository.findById(country.getId());
//			if (opt.isPresent()) {
//				country.setCreatedBy(opt.get().getCreatedBy());
//				CountryMaster save = cmRepository.save(country);
//				list.add(save);
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

	public APIResponse getAll(Long organizationId) {
		try {
			List<CountryMaster> list = cmRepository.findAllByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getCountryMasterPagenationByOrganization(Long organizationId, int pageNo, int pageSize,
			String sortBy, SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null) {
			Page<CountryMaster> findByOrganizationId = cmRepository.findByOrganizationId(organizationId, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
					findByOrganizationId.getTotalPages());
		} else {
			Page<CountryMaster> findAll = cmRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
		}
	}

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse editCountry(List<CountryMasterRequest> country) {
		List<CountryMaster> list = cmRepository.saveAll(
				country.stream().map(CountryMasterConverter::convertRequestToModel).collect(Collectors.toList()));
		logger.info("country-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

	public APIResponse saveAndEdit(List<CountryMaster> line) {
		try {
			List<CountryMaster> save = cmRepository.saveAll(line);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), save);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

}
