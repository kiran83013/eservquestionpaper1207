package com.travel.travtronics.converter;


import com.travel.travtronics.dto.PricingLinesFetchModel;
import com.travel.travtronics.dto.SurveyResponseDto;

import com.travel.travtronics.model.SurveyLines;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyConverter {
    public static List<SurveyResponseDto> convertSurveyLinesQuestionModelToJson(List<SurveyLines> models) {

        return models.stream().map(model->{
            SurveyResponseDto dto = new SurveyResponseDto();
            dto.setId(model.getId());
            dto.setOrganizationId(model.getOrganizationId());
            dto.setQuestion(model.getQuestion());
            dto.setReference(model.getReference());
            dto.setReferenceId(model.getReferenceId());
            dto.setSurveyHeader(model.getSurveyHeader());
            dto.setCreatedBy(model.getCreatedBy());
            dto.setUpdatedBy(model.getUpdatedBy());
            dto.setCreatedDate(model.getCreatedDate());
            dto.setUpdatedDate(model.getUpdatedDate());
            dto.setStatus(model.getStatus());
            return dto;
        }).collect(Collectors.toList());
    }
}
