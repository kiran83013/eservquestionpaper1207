package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.LineCharges;

public interface LineChargesRepository extends JpaRepository<LineCharges, Long>{

	Page<LineCharges> findByOrganizationId(Long organizationId, Pageable pageable);
	

	
	@Query(value = "SELECT lc.Id AS lineChargeId,\r\n" + 
			"lc.Charge AS charge,\r\n" + 
			"lc.Updated_By AS updatedBy,\r\n" + 
			"lc.Updated_Date AS updatedDate,\r\n" + 
			"lc.Created_By AS createdBy,\r\n" + 
			"lc.Created_Date AS createdDate,\r\n" + 
			"lc.Charge_Amount AS chargeAmount,\r\n" + 
			"lc.Cost_On_Date AS costOnDate,\r\n" + 
			"lc.On_Site AS onSite,\r\n" + 
			"lc.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"lc.Agreement_Id AS agreementId,a.Name AS agreementName,\r\n" + 
			"lc.Agreement_Line_Id AS agreementLineId,al.Line_Name AS agreementLineName,\r\n" + 
			"lc.Item AS item, i.Name AS itemName,lc.Status as status FROM lines_charges lc\r\n" + 
			"LEFT JOIN agreement a ON a.Id = lc.Agreement_Id\r\n" + 
			"LEFT JOIN agreement_lines al ON al.Agreement_Line_Id = lc.Agreement_Line_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = lc.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = lc.Organization_Id \r\n" + 
			"WHERE lc.Organization_Id =?1 AND lc.Status = 'Active'",nativeQuery = true)
	List<Map<String,String>> findAllByOrganizationId(Long organizationId);
	
	
	@Query(value ="SELECT o.name AS organizationName FROM master_organization o WHERE o.OrganizationId=?1",nativeQuery = true)
	Optional<String> getOrgName(Long organizationId);
	
	@Query(value ="SELECT i.Name AS itemName FROM item i WHERE i.ID=?1",nativeQuery = true)
	Optional<String> getItemName(String item);
	
	@Query(value ="SELECT a.Name AS agreementName FROM agreement a WHERE a.Id=?1",nativeQuery = true)
	Optional<String> getAgreementName(Long id);
	
	@Query(value ="SELECT al.Line_Name AS agreementLineName FROM agreement_lines al WHERE al.Agreement_Line_Id=?1",nativeQuery = true)
	Optional<String> getAgreementLineName(Long agreementLineId);
	
	@Query(value = "SELECT lc.Id AS lineChargeId,\r\n" + 
			"lc.Charge AS charge,\r\n" + 
			"lc.Updated_By AS updatedBy,\r\n" + 
			"lc.Updated_Date AS updatedDate,\r\n" + 
			"lc.Created_By AS createdBy,\r\n" + 
			"lc.Created_Date AS createdDate,\r\n" + 
			"lc.Charge_Amount AS chargeAmount,\r\n" + 
			"lc.Cost_On_Date AS costOnDate,\r\n" + 
			"lc.On_Site AS onSite,lc.Status AS status,\r\n" + 
			"lc.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"lc.Agreement_Id AS agreementId,a.Name AS agreementName,\r\n" + 
			"lc.Agreement_Line_Id AS agreementLineId,al.Line_Name AS agreementLineName,\r\n" + 
			"lc.Item AS item, i.Name AS itemName FROM lines_charges lc\r\n" + 
			"LEFT JOIN agreement a ON a.Id = lc.Agreement_Id\r\n" + 
			"LEFT JOIN agreement_lines al ON al.Agreement_Line_Id = lc.Agreement_Line_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = lc.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = lc.Organization_Id WHERE lc.Agreement_Id =?1 AND lc.Status = 'Active'",nativeQuery = true)
	List<Map<String, String>> findByAgreementId(Long agreementId);
	
	
	@Query(value = "SELECT lc.Id AS lineChargeId,\r\n" + 
			"lc.Charge AS charge,\r\n" + 
			"lc.Updated_By AS updatedBy,\r\n" + 
			"lc.Updated_Date AS updatedDate,\r\n" + 
			"lc.Created_By AS createdBy,\r\n" + 
			"lc.Created_Date AS createdDate,\r\n" + 
			"lc.Charge_Amount AS chargeAmount,\r\n" + 
			"lc.Cost_On_Date AS costOnDate,\r\n" + 
			"lc.On_Site AS onSite,lc.Status AS status,\r\n" + 
			"lc.Organization_Id AS organizationId,mo.Name AS organizationName,\r\n" + 
			"lc.Agreement_Id AS agreementId,a.Name AS agreementName,\r\n" + 
			"lc.Agreement_Line_Id AS agreementLineId,al.Line_Name AS agreementLineName,\r\n" + 
			"lc.Item AS item, i.Name AS itemName FROM lines_charges lc\r\n" + 
			"LEFT JOIN agreement a ON a.Id = lc.Agreement_Id\r\n" + 
			"LEFT JOIN agreement_lines al ON al.Agreement_Line_Id = lc.Agreement_Line_Id\r\n" + 
			"LEFT JOIN item i ON i.ID = lc.Item\r\n" + 
			"LEFT JOIN master_organization AS mo ON mo.OrganizationId = lc.Organization_Id WHERE lc.Agreement_Line_Id =?1 AND lc.Status = 'Active'",nativeQuery = true)
	List<Map<String, String>> findByAgreementLineId(Long agreementLineId);

	
}
