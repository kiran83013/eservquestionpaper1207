package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.ServiceContractToItem;

public interface ServiceContractToItemRepository extends JpaRepository<ServiceContractToItem, Long> {

	@Query(value = "SELECT sci.ID AS id, sci.Created_By AS createdBy, sci.Created_Date AS createdDate, sci.Valid_From AS validFrom, sci.Valid_To AS validTo, sci.Updated_By AS updatedBy, sci.Updated_Date AS updatedDate,sci.Territory AS territory,\r\n"
			+ "sci.Record_Status AS recordStatus, sci.WF_Status AS wfStatus, s.name AS wfStatusName, sci.Organization_Id AS organizationId, mo.Name AS organizationName, sci.Locality AS location, ml.name AS LocationName,sci.Item AS item,\r\n"
			+ "i.Name AS ItemName,sci.Cost_Center AS costCenter, cc.Name AS costCenterName, sci.Business_Unit AS businessUnit, bu.Name AS BusinessName, sci.Agreement AS agreement, a.Name AS agreementName\r\n"
			+ "FROM service_contract_to_item sci\r\n"
			+ "LEFT JOIN e_services.status s ON s.StatusId = sci.WF_Status\r\n"
			+ "LEFT JOIN master_organization mo ON mo.OrganizationId = sci.Organization_Id\r\n"
			+ "LEFT JOIN master_locality ml ON ml.ID = sci.Locality\r\n" + "LEFT JOIN item i ON i.ID = sci.Item\r\n"
			+ "LEFT JOIN cost_center cc ON cc.CostCenterId = sci.Cost_Center\r\n"
			+ "LEFT JOIN business_unit bu ON bu.BusinessUnitId = sci.Business_Unit\r\n"
			+ "LEFT JOIN agreement a ON a.Id = sci.agreement \r\n" + "WHERE sci.Organization_Id=?1", nativeQuery = true)
	List<Map<String, String>> findAllByOrganization(Long organization);

	Page<ServiceContractToItem> findByOrganization(Long organization, Pageable pageable);

	@Query(value = "SELECT sci.ID AS id, sci.Created_By AS createdBy, sci.Created_Date AS createdDate, sci.Valid_From AS validFrom, sci.Valid_To AS validTo, sci.Updated_By AS updatedBy, sci.Updated_Date AS updatedDate,sci.Territory AS territory,\r\n"
			+ "sci.Record_Status AS recordStatus, sci.WF_Status AS wfStatus, s.name AS wfStatusName, sci.Organization_Id AS organizationId, mo.Name AS organizationName, sci.Locality AS location, ml.name AS LocationName,sci.Item AS item,\r\n"
			+ "i.Name AS ItemName,sci.Cost_Center AS costCenter, cc.Name AS costCenterName, sci.Business_Unit AS businessUnit, bu.Name AS BusinessName, sci.Agreement AS agreement, a.Name AS agreementName\r\n"
			+ "FROM service_contract_to_item sci\r\n"
			+ "LEFT JOIN e_services.status s ON s.StatusId = sci.WF_Status\r\n"
			+ "LEFT JOIN master_organization mo ON mo.OrganizationId = sci.Organization_Id\r\n"
			+ "LEFT JOIN master_locality ml ON ml.ID = sci.Locality\r\n" + "LEFT JOIN item i ON i.ID = sci.Item\r\n"
			+ "LEFT JOIN cost_center cc ON cc.CostCenterId = sci.Cost_Center\r\n"
			+ "LEFT JOIN business_unit bu ON bu.BusinessUnitId = sci.Business_Unit\r\n"
			+ "LEFT JOIN agreement a ON a.Id = sci.agreement \r\n" + "WHERE sci.ID=?1", nativeQuery = true)
	List<Map<String, String>> findAllById(Long id);

	@Query(value = "SELECT o.name AS organizationName FROM master_organization o WHERE o.OrganizationId=?1", nativeQuery = true)
	Optional<String> getOrgName(Long organization);

	@Query(value = "SELECT i.Name AS itemName FROM item i WHERE i.ID=?1", nativeQuery = true)
	Optional<String> getItemName(String item);

	@Query(value = "SELECT a.Name AS agreementName FROM agreement a WHERE a.Id=?1", nativeQuery = true)
	Optional<String> getAgreementName(String agreement);

	@Query(value = "SELECT bu.name AS businessName FROM business_unit bu WHERE bu.BusinessUnitId=?1", nativeQuery = true)
	Optional<String> getBusinessUnitName(String businessUnit);

	@Query(value = "SELECT cc.name AS costCenterName FROM cost_center cc WHERE cc.CostCenterId=?1", nativeQuery = true)
	Optional<String> getCostCenterName(String costCenter);

	@Query(value = "SELECT l.name AS locationName FROM location l WHERE l.LocationId=?1", nativeQuery = true)
	Optional<String> getLocalityName(String locality);

	@Query(value = "SELECT s.name AS wfName FROM e_services.status s WHERE s.StatusId=?1", nativeQuery = true)
	Optional<String> getStatusName(String wfstatus);

}
