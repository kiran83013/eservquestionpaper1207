package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.AmenitiesForm;

public interface AmenitiesFormRepository extends JpaRepository<AmenitiesForm, Long>{
	
	@Query(value = "SELECT af.amt_id AS amenitiesFormId, af.name AS amenitiesFormName, af.description AS description, af.status AS status, af.categoryId AS categoryId, af.typeId AS typeId,af.organizationId AS organizationId,mo.Name AS organizationName,\r\n" + 
			"af.created_by AS createdby, af.created_date AS createdDate, af.updated_by AS updatedBy, af.updated_date AS updatedDate,mac.name AS categoryName, mat.name AS typeName FROM amenities af\r\n" + 
			"LEFT JOIN master_amenities_category mac ON mac.ID = af.categoryId\r\n" + 
			"LEFT JOIN master_amenities_type mat ON mat.ID = af.typeId\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = af.OrganizationId\r\n" + 
			"WHERE af.OrganizationId=?1",nativeQuery = true)
	List<Map<String, String>> findByList(Long organizationId);

	Page<AmenitiesForm> findByOrganizationId(Long organizationId, Pageable pageable);

	Optional<AmenitiesForm> findByTypeId(Long typeId);
	
	@Query(value = "SELECT c.Name AS TypeName  FROM master_amenities_type  c WHERE c.Id=?1", nativeQuery = true)
	Optional<String> getTypeyName(Long Id);
	
	@Query(value = "SELECT c.Name AS CategoryName  FROM master_amenities_category  c WHERE c.Id=?1", nativeQuery = true)
	Optional<String> getCategoryName(Long Id);
}
