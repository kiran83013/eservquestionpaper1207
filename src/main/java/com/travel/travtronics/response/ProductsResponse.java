package com.travel.travtronics.response;

import java.util.List;

import lombok.Data;

@Data
public class ProductsResponse {

	private Long id;
	private String name;
	private String description;
	private List<String> url;
	private String organizationName;
	private Long serviceTypeId;
	private String serviceTypeName;
	private String serviceTypeCode;
	private Double minprice;
	private Double maxprice;
}
