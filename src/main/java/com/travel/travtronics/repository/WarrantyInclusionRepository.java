package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.WarrantyInclusion;

public interface WarrantyInclusionRepository extends JpaRepository<WarrantyInclusion, Long> {

	@Query(value = "SELECT wi.Id AS warrantyExclusionId,\r\n" + 
			"wi.Updated_By AS updatedBy, \r\n" + 
			"wi.Updated_Date AS updatedDate,\r\n" + 
			"wi.Created_By AS createdBy,\r\n" + 
			"wi.Created_Date AS createdDate,\r\n" + 
			"wi.Cost_As_ON_Date AS costAsOnDate,\r\n" + 
			"wi.Labor AS laborId,\r\n" + 
			"wi.Labor_Amount AS laborAmount,\r\n" + 
			"wi.Parts AS parts, wi.Notes AS notes,\r\n" + 
			"wi.Parts_Amount AS partsAmount,\r\n" + 
			"wi.Replaces AS replaces,\r\n" + 
			"wi.W_Days AS wDays,\r\n" + 
			"wi.W_Meter AS wMeter,\r\n" + 
			"wi.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"wi.Agreement_Id AS agreementId,a.Name AS agreementName, \r\n" + 
			"wi.Item AS item, i.Name AS itemName FROM warranty_inclusion wi\r\n" + 
			"LEFT JOIN agreement a ON a.Id = wi.Agreement_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = wi.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = wi.Organization_Id \r\n" + 
			"WHERE wi.Organization_Id =?1",nativeQuery = true)
	List<Map<String, String>> findAllByOrganizationId(Long organizationId);

//	Page<WarrantyInclusion> findByOrganizationId(Long organizationId, Pageable pageable);
	
	@Query(value = "SELECT wi.Id AS warrantyExclusionId,\r\n" + 
			"wi.Updated_By AS updatedBy, \r\n" + 
			"wi.Updated_Date AS updatedDate,\r\n" + 
			"wi.Created_By AS createdBy,\r\n" + 
			"wi.Created_Date AS createdDate,\r\n" + 
			"wi.Cost_As_ON_Date AS costAsOnDate,\r\n" + 
			"wi.Labor AS laborId,\r\n" + 
			"wi.Labor_Amount AS laborAmount,\r\n" + 
			"wi.Parts AS parts, wi.Notes AS notes,\r\n" + 
			"wi.Parts_Amount AS partsAmount,\r\n" + 
			"wi.Replaces AS replaces,\r\n" + 
			"wi.W_Days AS wDays,\r\n" + 
			"wi.W_Meter AS wMeter,\r\n" + 
			"wi.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"wi.Agreement_Id AS agreementId,a.Name AS agreementName, \r\n" + 
			"wi.Item AS item, i.Name AS itemName FROM warranty_inclusion wi\r\n" + 
			"LEFT JOIN agreement a ON a.Id = wi.Agreement_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = wi.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = wi.Organization_Id WHERE wi.Agreement_Id =?1",nativeQuery = true)
	List<Map<String, String>> findAllByAgreementId(Long agreementId);
	
	

	@Query(value ="SELECT o.name AS organizationName FROM master_organization o WHERE o.OrganizationId=?1",nativeQuery = true)
	Optional<String> getOrgName(Long organizationId);
	
	@Query(value ="SELECT i.Name AS itemName FROM item i WHERE i.ID=?1",nativeQuery = true)
	Optional<String> getItemName(String item);
	
	@Query(value ="SELECT a.Name AS agreementName FROM agreement a WHERE a.Id=?1",nativeQuery = true)
	Optional<String> getAgreementName(Long id);

	Page<WarrantyInclusion> findByOrganizationIdAndAgreementId(Long organizationId, Long agreementId,
			Pageable pageable);

	Page<WarrantyInclusion> findByAgreementId(Long agreementId, Pageable pageable);

//	Page<WarrantyInclusion> findByOrganizationId(Long organizationId, Pageable pageable);

}
