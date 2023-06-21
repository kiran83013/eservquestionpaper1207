package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.CountryMasterConverter;
import com.travel.travtronics.model.GenerateSetupMaster;
import com.travel.travtronics.repository.GenerateSetupMasterRepository;
import com.travel.travtronics.request.GenerateSetupMasterRequest;
import com.travel.travtronics.response.APIResponse;

@Service
public class GenerateSetupMasterService {

	@Autowired
	GenerateSetupMasterRepository generateSetupMasterRepository;

	public APIResponse createSetUpMaster(List<GenerateSetupMasterRequest> model) {
		try {
			List<GenerateSetupMaster> save = generateSetupMasterRepository.saveAll(model.stream()
					.map(CountryMasterConverter::convertGeneralSetUpRequestToModel).collect(Collectors.toList()));
			// logger.info("country-modified");
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), save);

//			GenerateSetupMaster save = generateSetupMasterRepository.save(model);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.CONFLICT.value(),
					"Organization And Category And CreatedBy must be Mandatory", new ArrayList<>());
		}
	}

	public APIResponse GetById(Long id) {
		try {
			Optional<GenerateSetupMaster> opt = generateSetupMasterRepository.findById(id);
			List<GenerateSetupMaster> list = new ArrayList<>();
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

	public APIResponse editSetUpMaster(GenerateSetupMaster model) {
		List<GenerateSetupMaster> list = new ArrayList<>();
		try {
			Optional<GenerateSetupMaster> opt = generateSetupMasterRepository.findById(model.getId());
			if (opt.isPresent()) {
				model.setCreatedBy(opt.get().getCreatedBy());
				GenerateSetupMaster save = generateSetupMasterRepository.save(model);
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

	public APIResponse getAll(Long orgId) {
		try {
			List<Map<String, String>> list = generateSetupMasterRepository.findByOrgId(orgId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getAllByCategory(Long categoryId) {
		try {
			List<GenerateSetupMaster> list = generateSetupMasterRepository.findByCategoryId(categoryId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getAllByOrgAndCategory(Long orgId, Long categoryId) {
		try {
			List<Map<String, String>> list = generateSetupMasterRepository.findByOrgIdAndCategoryId(orgId, categoryId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse getAllByOrgAndCategoryLocalization(Long orgId, Long categoryId, String langCode) {
		List<Map<String, String>> masterData = generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(orgId,
				categoryId, Objects.isNull(langCode) ? "en" : langCode);

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), masterData);
	}
}
