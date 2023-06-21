package com.travel.travtronics.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@ToString
public class EservicePricingResponse {

	private Long priceLineId;

	private Integer itemId;

	private String itemName;

	private String Description;

	private double taxPrice;

	private double discount;

	private double ItemPrice;

	private double totalPrice;

	@JsonIgnore
	private Integer organizationId;

	@JsonIgnore
	private String organizationName;

	private List<TaxTemplate> taxBreakup;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Long getPriceLineId() {
		return priceLineId;
	}

	public void setPriceLineId(Long priceLineId) {
		this.priceLineId = priceLineId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getItemPrice() {
		return ItemPrice;
	}

	public void setItemPrice(double itemPrice) {
		ItemPrice = itemPrice;
	}

	public List<TaxTemplate> getTaxBreakup() {
		return taxBreakup;
	}

	public void setTaxBreakup(List<TaxTemplate> taxBreakup) {
		this.taxBreakup = taxBreakup;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
