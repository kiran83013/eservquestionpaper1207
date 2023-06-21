package com.travel.travtronics.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.repository.GenerateSetupMasterRepository;
import com.travel.travtronics.response.APIResponse;

@RestController
public class GenericController {

	@Autowired
	GenerateSetupMasterRepository generateSetupMasterRepository;

	@GetMapping(value = "/genSetupLocalization", produces = "application/json")
	public APIResponse masterLocalization() {

		Map<String, Object> map = new HashMap<>();

		map.put("propertyOptions", generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(1L, 389L, "en"));
		map.put("whoWillOwnCompany",
				generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(1L, 388L, "en"));
		map.put("typeOfEntities", generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(1L, 387L, "en"));
		map.put("howSoonAreYouLookingToSetupCompany",
				generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(1L, 386L, "en"));
		map.put("countries", generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(1L, 345L, "en"));
		map.put("languages", generateSetupMasterRepository.findByOrgIdAndCategoryIdLocalization(1L, 385L, "en"));

		return new APIResponse(200, "OK", List.of(map));

	}

}
