package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.model.MasterModule;


public interface MasterModuleRepository extends JpaRepository<MasterModule, Long>{

	List<MasterModule> findAllByOrganizationId(Long organizationId);

	Page<MasterModule> findByOrganizationId(Long organizationId, Pageable pageable);

}
