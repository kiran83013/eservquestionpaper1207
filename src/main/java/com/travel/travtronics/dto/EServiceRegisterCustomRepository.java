package com.travel.travtronics.dto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Agreement;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.FieldProcessHeader;
import com.travel.travtronics.model.InputTypeConfig;
import com.travel.travtronics.model.Item;
import com.travel.travtronics.model.PricingHeader;
import com.travel.travtronics.model.ServiceTypeGroup;
import com.travel.travtronics.model.TaxSlabHeader;

public interface EServiceRegisterCustomRepository {

	Page<EServiceRegister> fetchEServiceRegisterPagination(String serviceName, Long organizationId, Pageable pageable,
			String sortBy, SortType sortType);

	Page<InputTypeConfig> fetchInputTypeConfigPagination(String name, Long organizationId, Pageable pageable,
		  String sortBy, SortType sortType);

	Page<ServiceTypeGroup> fetchServiceTypeGroupPagination(String name, Long organizationId, 
		 Pageable pageable, String sortBy, SortType sortType);

	Page<Item> fetchItemPagination(String name, Long organizationId, Pageable pageable, String sortBy,
		 SortType sortType);

	Page<PricingHeader> fetchPricingPagination(String name, Long organization, Pageable pageable, String sortBy,
		SortType sortType);

	Page<TaxSlabHeader> fetchTaxPagination(Long taxCategory, Long organizationId, Pageable pageable, String sortBy,
		SortType sortType);

	Page<Agreement> fetchAgreementPagination(String name, Long organizationId, Pageable pageable, String sortBy,
			SortType sortType);

	Page<FieldProcessHeader> fetchFieldProcessHeaderPagination(String processName, Long organizationId,
			Pageable pageable, String sortBy, SortType sortType);

	

}
