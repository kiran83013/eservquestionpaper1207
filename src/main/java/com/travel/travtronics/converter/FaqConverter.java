package com.travel.travtronics.converter;

import com.travel.travtronics.dto.FaqResponseDto;
import com.travel.travtronics.dto.SurveyResponseDto;
import com.travel.travtronics.model.Faq;
import com.travel.travtronics.model.SurveyLines;

import java.util.List;
import java.util.stream.Collectors;

public class FaqConverter {

    public static List<FaqResponseDto> convertFaqQuestionModelToJson(List<Faq> models) {

        return models.stream().map(model->{
            FaqResponseDto dto = new FaqResponseDto();
            dto.setId(model.getId());
            dto.setOrganization(model.getOrganization());
            dto.setDepartment(model.getDepartment());
            dto.setQuestion(model.getQuestion());
            dto.setReference(model.getReference());
            dto.setReferenceId(model.getReferenceId());
            dto.setAnswer(model.getAnswer());
            dto.setDeviceId(model.getDeviceId());
            dto.setDeviceType(model.getDeviceType());
            dto.setIpAddress(model.getIpAddress());
            dto.setAttribute1(model.getAttribute1());
            dto.setAttribute2(model.getAttribute2());
            dto.setAttribute3(model.getAttribute3());
            dto.setCreatedBy(model.getCreatedBy());
            dto.setUpdatedBy(model.getUpdatedBy());
            dto.setCreatedDate(model.getCreatedDate());
            dto.setUpdatedDate(model.getUpdatedDate());
            dto.setStatus(model.getStatus());
            return dto;
        }).collect(Collectors.toList());
    }
}
