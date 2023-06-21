package com.travel.travtronics.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Item;

import lombok.Data;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class PricingLineResponse {
	private Long id;

	private Long headerId;

	private Long item;

	private String itemName;

	private String taxSlab;

	private String api;

	private String charge;

	private Item.EntityImport qualifier;

	private Item.EntityImport fieldDependent;

	private Item.EntityImport percentage;

	private Integer field;

	private String variableFrequency;

	private String operator;

	private String value;

	private Item.EntityImport portalVisible;

	private Item.EntityImport statutory;

	private String isAdditinalCharge;

	private String isChargeOveride;

	private Integer createdBy;

	private Date startDate;

	private Date endDate;

	private String attr1;

	private String attr2;

	private String attr3;

	private Date createdDate;

	private Date updatedDate;

	private Status status;

	private Boolean pbouom;

	private Long umoValue;

	private Boolean isApi;

	private Boolean isRange;
	
	private Integer priceTemplateType;

}
