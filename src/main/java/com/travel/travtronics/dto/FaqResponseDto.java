package com.travel.travtronics.dto;

import java.util.Date;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Questions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqResponseDto {

	private Long id;

	private Long organization;

	private Long department;

	private String reference;

	private Long referenceId;

	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Long question;

	@JsonInclude(Include.NON_NULL)
	@JsonProperty("question")
	private Optional<Questions> questionModel;

	private Long questionId;

	private String questionName;

	private String answer;

	private String deviceId;

	private String deviceType;

	private String ipAddress;

	private String attribute1;

	private String attribute2;

	private String attribute3;

	private String createdBy;

	private Date createdDate;

	private String updatedBy;

	private Date updatedDate;

	private Status status;

}
