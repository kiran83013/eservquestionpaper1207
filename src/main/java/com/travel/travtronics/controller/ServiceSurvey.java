package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.SurveyLines;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.SurveyService;

@RestController
@RequestMapping("/survey")
public class ServiceSurvey {

	@Autowired
	SurveyService surveyService;

	@PostMapping(value = "create-or-update-survey")
	public APIResponse createSurveyLines(@RequestBody List<SurveyLines> model) {
		return surveyService.createOrUpdateSurveyLine(model);
	}

	@GetMapping(value = "get-survey/{id}")
	public APIResponse getSurveyLine(@PathVariable Long id) {
		return surveyService.getSurveyLine(id);
	}

	@GetMapping(value = "get-survey")
	public APIResponse getSurveyLines(@RequestParam Long organizationId) {
		return surveyService.getSurveyLines(organizationId);
	}

	@GetMapping(value = "get-survey-by-reference/{referenceId}/{reference}")
	public APIResponse getSurveyByReference(@PathVariable Long referenceId, @PathVariable String reference) {
		return surveyService.getSurveyByReference(referenceId, reference);
	}
	
	@GetMapping(value = "/get")
    public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId,
                                                @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
        return  surveyService.getPagenationByOrganization(organizationId, pageNo, pageSize, sortBy, sortType);
    }

}
