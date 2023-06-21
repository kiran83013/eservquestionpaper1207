package com.travel.travtronics.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.travel.travtronics.enums.Status;

import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "pricing_lines")
public class PricingLines {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TemplateHeaderId")
	private Long headerId;

	@Column(name = "Item")
	private Long item;

	@Column(name = "OrganizationId")
	private Long organizationId;

	@Column(name = "TaxSlab")
	private String taxSlab;

	@Column(name = "Api")
	private String api;

	@Column(name = "Charge")
	private String charge;

	@Column(name = "Qualifier")
	@Enumerated(EnumType.STRING)
	private Item.EntityImport qualifier;

	@Enumerated(EnumType.STRING)
	@Column(name = "FieldDependent")
	private Item.EntityImport fieldDependent;

	@Enumerated(EnumType.STRING)
	@Column(name = "Percentage")
	private Item.EntityImport percentage;

	@Column(name = "Field")
	private Integer field;

	@Column(name = "VariableFrequency")
	private String variableFrequency;

	@Column(name = "Operator")
	private String operator;

	@JsonRawValue
	@Column(name = "Value")
	private String value;

	@Enumerated(EnumType.STRING)
	@Column(name = "PortalVisible")
	private Item.EntityImport portalVisible;

	@Enumerated(EnumType.STRING)
	@Column(name = "Statutory")
	private Item.EntityImport statutory;

	@Column(name = "IsAdditinalCharge")
	private String isAdditinalCharge;

	@Column(name = "IsChargeOveride")
	private String isChargeOveride;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "Attr1")
	private String attr1;

	@Column(name = "Attr2")
	private String attr2;

	@Column(name = "attr3")
	private String attr3;

	@Column(name = "CreatedBy", updatable = false)
	private Integer createdBy;

	@Column(name = "UpdatedBy")
	private Integer updatedBy;

	@CreationTimestamp
	@Column(name = "CreatedDate", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UpdatedDate")
	private Date updatedDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "Status")
	private Status status;

	@Column(name = "PBOUOM")
	private Boolean pbouom;

	@Column(name = "UmoValue")
	private Long umoValue;

	@Column(name = "ToOperator")
	private String toOperator;

	@JsonRawValue
	@Column(name = "ToValue")
	private String toValue;

	@Column(name = "IsApi")
	private Boolean isApi;

	@Column(name = "IsRange")
	private Boolean isRange;

	@Column(name = "PriceTemplateType")
	private Integer priceTemplateType;

}
