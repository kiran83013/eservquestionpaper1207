package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.AgreementLines;

public interface AgreementLinesRepository extends JpaRepository<AgreementLines, Long> {

	@Query(value = "SELECT al.Agreement_Line_Id AS agreementLineId, al.Created_By AS createdBy, al.Created_Date AS createdDate, al.Days_Max AS daysMax, al.Days_Min AS daysMin, al.Line_Name AS lineName, al.Metered_Max AS meteredMax, al.Metered_Min AS meteredMin, al.On_Site AS onSite,\r\n" + 
			"al.Service_Agreement_Line AS serviceAgreementLine, al.Type AS type, al.Updated_By AS updatedBy, al.Updated_Date AS updatedDate,\r\n" + 
			"al.Organization_Id AS organizationId,mo.Name AS organizationName, \r\n" + 
			"al.Srtype_Id AS srtype, sth.Name AS srTypeName,al.Status AS status,\r\n" + 
			"al.Agreement_Id AS agreementId, a.Name AS agreementName,\r\n" + 
			"al.Category AS category FROM agreement_lines al\r\n" + 
			"INNER JOIN master_organization mo ON mo.OrganizationId = al.Organization_Id\r\n" + 
			"INNER JOIN service_types_header sth ON sth.ID = al.Srtype_Id\r\n" + 
			"INNER JOIN agreement a ON a.ID = al.Agreement_Id\r\n" + 
			"WHERE al.Organization_Id= ?1 AND al.Status = 'Active'", nativeQuery = true)
	List<Map<String, String>> findByOrganizationId(Long organizationId);
	
	/**@Query(value = "SELECT al.Agreement_Line_Id AS agreementLineId, al.Created_By AS createdBy, al.Created_Date AS createdDate, al.Days_Max AS daysMax, al.Days_Min AS daysMin, al.Line_Name AS lineName, al.Metered_Max AS meteredMax, al.Metered_Min AS meteredMin, al.On_Site AS onSite,\r\n" + 
			"al.Service_Agreement_Line AS serviceAgreementLine, al.Type AS type, al.Updated_By AS updatedBy, al.Updated_Date AS updatedDate,\r\n" + 
			"al.Organization_Id AS organizationId,mo.Name AS organizationName, \r\n" + 
			"al.Srtype_Id AS srtype, sth.Name AS srTypeName,al.Status AS status,\r\n" + 
			"al.Agreement_Id AS agreementId, a.Name AS agreementName,\r\n" + 
			"al.Category AS category, mc.name AS categoryName \r\n" + 
			"FROM agreement_lines al\r\n" + 
			"INNER JOIN master_organization mo ON mo.OrganizationId = al.Organization_Id\r\n" + 
			"INNER JOIN service_types_header sth ON sth.ID = al.Srtype_Id\r\n" + 
			"INNER JOIN agreement a ON a.ID = al.Agreement_Id\r\n" + 
			"INNER JOIN master_category mc ON mc.category_id = al.Category\r\n" + 
			"WHERE al.Agreement_Id=?1  AND al.Status = 'Active'", nativeQuery = true)
	List<Map<String,String>> findAllByAgreementId(Long agreementId);**/

//	Page<AgreementLines> findByOrganizationId(Long organizationId, Pageable pageable);

	@Query(value = "SELECT al.Agreement_Line_Id AS agreementLineId, al.Created_By AS createdBy, al.Created_Date AS createdDate, al.Days_Max AS daysMax, al.Days_Min AS daysMin, al.Line_Name AS lineName, al.Metered_Max AS meteredMax, al.Metered_Min AS meteredMin, al.On_Site AS onSite,\r\n" + 
			"al.Service_Agreement_Line AS serviceAgreementLine, al.Type AS type, al.Updated_By AS updatedBy, al.Updated_Date AS updatedDate,\r\n" + 
			"al.Organization_Id AS organizationId,mo.Name AS organizationName, \r\n" + 
			"al.Srtype_Id AS srtype, sth.Name AS srTypeName,al.Status AS status,\r\n" + 
			"al.Agreement_Id AS agreementId, a.Name AS agreementName,\r\n" + 
			"al.Category AS category FROM agreement_lines al\r\n" + 
			"INNER JOIN master_organization mo ON mo.OrganizationId = al.Organization_Id\r\n" + 
			"INNER JOIN service_types_header sth ON sth.ID = al.Srtype_Id\r\n" + 
			"INNER JOIN agreement a ON a.ID = al.Agreement_Id\r\n" + 
			"WHERE al.Agreement_Line_Id= ?1 AND al.Status = 'Active'", nativeQuery = true)
	List<Map<String, String>> findAllByAgreementLineId(Long agreementLineId);
	
	
	@Query(value = "SELECT c.Name AS OrganizationName  FROM master_organization  c WHERE c.OrganizationId=?1", nativeQuery = true)
	Optional<String> getOrgName(Long organizationId);
	
	
	@Query(value = "SELECT c.Name AS AgreementName  FROM agreement  c WHERE c.Id=?1", nativeQuery = true)
	Optional<String> getAgreementName(Long AgreementId);
	
	@Query(value = "SELECT c.Name AS serviceTypeHeaderName  FROM service_types_header  c WHERE c.ID=?1", nativeQuery = true)
	Optional<String> getSrTypeName(Long srtype);
	
	@Query(value = "SELECT c.Name AS categoryName  FROM master_category  c WHERE c.category_id=?1", nativeQuery = true)
	Optional<String> getCategoryName(String category);

	Page<AgreementLines> findByOrganizationIdAndAgreementId(Long organizationId,Long AgreementId, Pageable pageable);

	Page<AgreementLines> findByAgreementId( Long agreementId, Pageable pageable);

}
