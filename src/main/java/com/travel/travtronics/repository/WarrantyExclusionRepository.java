package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.WarrantyExclusion;

public interface WarrantyExclusionRepository extends JpaRepository<WarrantyExclusion, Long>{

	@Query(value = "SELECT we.Id AS warrantyExclusionId,\r\n" + 
			"we.Updated_By AS updatedBy, \r\n" + 
			"we.Updated_Date AS updatedDate,\r\n" + 
			"we.Created_By AS createdBy,\r\n" + 
			"we.Created_Date AS createdDate,\r\n" + 
			"we.Cost_As_ON_Date AS costAsOnDate,\r\n" + 
			"we.Labor AS laborId,\r\n" + 
			"we.Labor_Amount AS laborAmount,\r\n" + 
			"we.Parts AS parts,\r\n" + 
			"we.Parts_Amount AS partsAmount,\r\n" + 
			"we.Replaces AS replaces, we.Notes as notes,\r\n" + 
			"we.W_Days AS wDays,\r\n" + 
			"we.W_Meter AS wMeter,\r\n" + 
			"we.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"we.Agreement_Id AS agreementId,a.Name AS agreementName, \r\n" + 
			"we.Item AS item, i.Name AS itemName FROM warranty_exclusion we\r\n" + 
			"LEFT JOIN agreement a ON a.Id = we.Agreement_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = we.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = we.Organization_Id \r\n" + 
			"WHERE we.Organization_Id =?1",nativeQuery = true)
	List<Map<String, String>> findAllByOrganizationId(Long organizationId);

//	Page<WarrantyExclusion> findByOrganizationId(Long organizationId, Pageable pageable);
	
	@Query(value = "SELECT we.Id AS warrantyExclusionId,\r\n" + 
			"we.Updated_By AS updatedBy, \r\n" + 
			"we.Updated_Date AS updatedDate,\r\n" + 
			"we.Created_By AS createdBy,\r\n" + 
			"we.Created_Date AS createdDate,\r\n" + 
			"we.Cost_As_ON_Date AS costAsOnDate,\r\n" + 
			"we.Labor AS laborId,\r\n" + 
			"we.Labor_Amount AS laborAmount,\r\n" + 
			"we.Parts AS parts, we.Notes AS notes,\r\n" + 
			"we.Parts_Amount AS partsAmount,\r\n" + 
			"we.Replaces AS replaces,\r\n" + 
			"we.W_Days AS wDays,\r\n" + 
			"we.W_Meter AS wMeter,\r\n" + 
			"we.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"we.Agreement_Id AS agreementId,a.Name AS agreementName, \r\n" + 
			"we.Item AS item, i.Name AS itemName FROM warranty_exclusion we\r\n" + 
			"LEFT JOIN agreement a ON a.Id = we.Agreement_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = we.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = we.Organization_Id WHERE we.Agreement_Id =?1",nativeQuery = true)
	List<Map<String, String>> findByAgreementId(Long agreementId);
	
	
	@Query(value ="SELECT o.name AS organizationName FROM master_organization o WHERE o.OrganizationId=?1",nativeQuery = true)
	Optional<String> getOrgName(Long organizationId);
	
	@Query(value ="SELECT i.Name AS itemName FROM item i WHERE i.ID=?1",nativeQuery = true)
	Optional<String> getItemName(String item);
	
	@Query(value ="SELECT a.Name AS agreementName FROM agreement a WHERE a.Id=?1",nativeQuery = true)
	Optional<String> getAgreementName(Long id);

	Page<WarrantyExclusion> findByOrganizationIdAndAgreementId(Long organizationId, Long agreementId,
			Pageable pageable);

	Page<WarrantyExclusion> findByAgreementId(Long agreementId, Pageable pageable);

}
