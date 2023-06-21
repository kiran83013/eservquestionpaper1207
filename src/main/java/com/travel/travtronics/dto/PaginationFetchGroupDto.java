package com.travel.travtronics.dto;

import javax.validation.constraints.NotNull;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
public class PaginationFetchGroupDto {

	private String organizationId;

	private String departmentId;

	private String serviceTypeGroup;

	private Status status;

	@NotNull
	private int pageNo;

	@NotNull
	private int pageSize;

	private String sortBy;

	private SortType sortType;
}
