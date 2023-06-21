package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Agreement;

public interface AgreementRepository extends JpaRepository<Agreement, Long>{
	


	Page<Agreement> findByOrganizationId(Long organizationId, Pageable pageable);
	
	@Query(value ="SELECT mc.Name AS categoryName  FROM master_category mc WHERE mc.category_id=?1",nativeQuery = true)
	Optional<String> getCategoryName(String category);
	
	@Query(value ="SELECT s.name AS statusName FROM e_services.status s WHERE s.StatusId=?1",nativeQuery = true)
	Optional<String> getStatusName(Status recordStatus);
	
	@Query(value ="SELECT o.name AS organizationName FROM master_organization o WHERE o.OrganizationId=?1",nativeQuery = true)
	Optional<String> getOrgName(Long organizationId);
	
	@Query(value = "SELECT a.Id AS agreementId,a.Type AS type, a.Name AS agreementName, a.Description AS description,a.Updated_By AS updatedBy,a.Updated_Date AS updatedDate,\r\n" + 
			"a.Created_By AS createdBy, a.Created_Date AS createdDate, a.Record_Status AS recordStatus,\r\n" + 
			"a.Valid_From AS validFrom, a.Valid_To AS validTo,a.WF_Status AS wfStatus,s.name AS wfStatusName,a.Organization_Id AS organizationId,mo.Name AS organizationName,a.Category AS category,mc.name AS categoryName\r\n" + 
			"FROM agreement a\r\n" + 
			"INNER JOIN master_category mc ON mc.category_id = a.Id\r\n" + 
			"INNER JOIN e_services.status s ON s.StatusId = a.WF_Status\r\n" + 
			"INNER JOIN master_organization AS mo ON mo.OrganizationId = a.Organization_Id \r\n" + 
			"WHERE a.Organization_Id =?1",nativeQuery = true)
	List<Map<String, String>> findAllByOrganizationId(Long organizationId);

	

}
