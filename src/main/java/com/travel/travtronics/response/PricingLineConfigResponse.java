package com.travel.travtronics.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travtronics.model.InputTypeConfig;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PricingLineConfigResponse extends InputTypeConfig{
	
	@JsonProperty("type")
	private String typeName;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
