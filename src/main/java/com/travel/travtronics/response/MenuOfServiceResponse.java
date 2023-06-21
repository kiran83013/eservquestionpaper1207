package com.travel.travtronics.response;

import lombok.Data;

@Data
public class MenuOfServiceResponse {
	private Long serviceTypeId;
	private String ServiceTypeName;
	private String ServiceTypeUrl;
	private Long isServiceDynamic;
	private Long serviceTypeClass;
	private Boolean isProcess;
	private Boolean isParent;

//	@JsonProperty("sanctionTypeId")
//	private Integer typeId;
//	
//	@JsonProperty("sanctionTypeName")
//	private String typeName;
	
	
}
