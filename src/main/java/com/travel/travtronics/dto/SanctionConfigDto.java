package com.travel.travtronics.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanctionConfigDto {

	private Integer sanctionId;

	private String sanctionName;

	private Integer sanctionTypeId;

	private String sanctionTypeName;

	@JsonIgnore
	private String srTypeId;

	private String description;

	private String sanctionImage;

}
