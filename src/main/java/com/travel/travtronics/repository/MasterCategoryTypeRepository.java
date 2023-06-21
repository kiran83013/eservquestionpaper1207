package com.travel.travtronics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.model.MasterCategoryType;


public interface MasterCategoryTypeRepository extends JpaRepository<MasterCategoryType, Long>{

	Optional<MasterCategoryType> findByCategoryId(Long id);

	List<MasterCategoryType> findAllByOrganizationId(Long organizationId);

	Page<MasterCategoryType> findByOrganizationId(Long organizationId, Pageable pageable);

}
