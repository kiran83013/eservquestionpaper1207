package com.travel.travtronics.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.travel.travtronics.dto.PaginationFetchDto;
import com.travel.travtronics.dto.PaginationFetchGroupDto;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.ServiceMenuType;
import com.travel.travtronics.model.ServiceTypesHeader;

public interface ServiceTypeCustomRepository {

	Page<ServiceTypesHeader> fetchPaginationList(PaginationFetchDto service, Pageable pageable);

	Page<ServiceMenuType> fetchServiceTypeMenuPagination(String name, Long organization, Pageable pageable,
			String sortBy, SortType sortType);

	Page<ServiceTypesHeader> fetchPaginationGroupList(PaginationFetchGroupDto dto, Pageable pageable);

}
