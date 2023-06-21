package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.Organization;


public interface OrganizationRepository extends JpaRepository<Organization, Long>{

	@Query(value = "SELECT \r\n" + 
			"mo.OrganizationId AS id,\r\n" + 
			"mo.Name AS name \r\n" + 
			"FROM master_organization AS mo", nativeQuery = true)
	List<Map<String, String>> findByIdAndName();

	Page<Organization> findByOrganizationId(Long organizationId, Pageable pageable);

}
