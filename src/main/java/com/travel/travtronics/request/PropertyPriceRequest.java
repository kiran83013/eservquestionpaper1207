package com.travel.travtronics.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyPriceRequest {

	private String qualifiers;

	private Long uom;

	private Integer uomValue;

}
