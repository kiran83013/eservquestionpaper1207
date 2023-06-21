package com.travel.travtronics.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Questions;
import lombok.Data;

import java.util.Date;
import java.util.Optional;

@Data
public class SurveyResponseDto {

    private Long id;

    @JsonIgnore
    private Long question;

    @JsonProperty("question")
    private Optional<Questions> questionModel;

    private String reference;

    private Long referenceId;
    
    private Long organizationId;

    private Long surveyHeader;

    private String createdBy;

    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private Status status;
}
