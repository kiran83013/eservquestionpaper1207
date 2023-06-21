package com.travel.travtronics.service;

import com.travel.travtronics.converter.SurveyConverter;
import com.travel.travtronics.dto.SurveyResponseDto;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.Questions;
import com.travel.travtronics.model.SurveyHeader;
import com.travel.travtronics.model.SurveyLines;
import com.travel.travtronics.repository.QuestionsRepository;
import com.travel.travtronics.repository.SurveyHeaderRepository;
import com.travel.travtronics.repository.SurveyLinesRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    SurveyHeaderRepository surveyHeaderRepository;
    @Autowired
    SurveyLinesRepository surveyLinesRepository;

    @Autowired
    QuestionsRepository questionsRepository;
//    public APIResponse<SurveyHeader> createTutorial(@RequestBody Tutorial tutorial) {
//        Tutorial _tutorial = tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), true));
//        return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//    }

    // create survey header
    public APIResponse createSurveyHeader(SurveyHeader model) {
        // save survey
        SurveyHeader survey = surveyHeaderRepository.save(model);
        return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), Collections.singletonList(survey));
    }
    // update survey header
    public APIResponse modifySurveyHeader(SurveyHeader model, Long id) {
        Optional<SurveyHeader> findById =  surveyHeaderRepository.findById(id);
        if (!findById.isPresent())
            return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
        else {
            SurveyHeader survey = surveyHeaderRepository.save(model);
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(survey));
        }

    }
    // find survey header
    public APIResponse getSurveyHeader(Long id) {
        Optional<SurveyHeader> findById =  surveyHeaderRepository.findById(id);
        if (!findById.isPresent())
            return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
        else {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    Collections.singletonList(findById));
        }
    }

    // get all survey headers
    public APIResponse getSurveyHeaders() {
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
               surveyHeaderRepository.findAll());
    }

    // create or update survey line
    public APIResponse createOrUpdateSurveyLine(List<SurveyLines> model) {
        // save survey
        List<SurveyLines> survey = surveyLinesRepository.saveAll(model);
        return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), Collections.singletonList(survey));
    }

    // find survey line
    public APIResponse getSurveyLine(Long id) {
        Optional<SurveyLines> findById =  surveyLinesRepository.findById(id);
        if (!findById.isPresent())
            return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
        else {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    Collections.singletonList(findById));
        }
    }

    // find survey line
    public APIResponse getSurveyByReference(Long referenceId, String reference) {
        List<SurveyLines> find =  surveyLinesRepository.findAllByReferenceIdAndReferenceAndStatus(referenceId, reference, Status.Active);


        if (!find.isEmpty()) {
            List<SurveyResponseDto> surveyResponse = SurveyConverter.convertSurveyLinesQuestionModelToJson(find).stream().map(model -> {
                model.setQuestionModel(getSurveyQuestions(model.getQuestion()));
                return model;
            }).collect(Collectors.toList());

            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    surveyResponse);
        }
        else {
            return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),  Collections.emptyList());
        }
    }

    private Optional<Questions> getSurveyQuestions(Long Id) {
        Optional<Questions> question = questionsRepository.findById(Id);
        return question;
    }

    // get all survey lines
    public APIResponse getSurveyLines(Long organizationId) {
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                surveyLinesRepository.findByOrganizationId(organizationId));
    }
	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId != null ) {
			Page<SurveyLines> menuData = surveyLinesRepository.findByOrganizationId(organizationId, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<SurveyLines> esRegister = surveyLinesRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}

}
