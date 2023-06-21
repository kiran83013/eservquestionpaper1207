package com.travel.travtronics.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.CustomerSegments;

public interface CustomerSegmentsRepository extends JpaRepository<CustomerSegments, Long>{

	List<CustomerSegments> findAllByOrganizationId(Long organizationId);

	Page<CustomerSegments> findByOrganizationId(Long organizationId, Pageable pageable);
	
	@Query(value = "SELECT l.Name AS LANGUAGE  FROM master_language  l WHERE l.Id=?1",nativeQuery = true)
	Optional<String> getLanguageName(Long language);

}
