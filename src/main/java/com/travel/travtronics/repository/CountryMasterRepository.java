package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.model.CountryMaster;

public interface CountryMasterRepository extends JpaRepository<CountryMaster, Long>{

	List<CountryMaster> findAllByOrganizationId(Long organizationId);

	Page<CountryMaster> findByOrganizationId(Long organizationId, Pageable pageable);

}
