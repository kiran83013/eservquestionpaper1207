package com.travel.travtronics.request;

import java.util.Date;

import lombok.Data;

@Data
public class GenerateSetupMasterRequest {

	private Long id;

	private Long categoryId;

	private Long orgId;

	private String name;

	private String code;

	private String description;

	private Boolean status;

	private Date createdDate;

	private Long createdBy;

	private Date updatedDate;

	private Long updatedBy;

}
