package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.CostCenter;

public interface CostCenterRepository extends JpaRepository<CostCenter, Long>{
	
	@Query(value = "SELECT cc.CostCenterId AS costcenterId, cc.BusinessUnitId AS businessUnitId, cc.AccCode AS accCode, cc.Name AS NAME,  \r\n" + 
			"cc.StartDate AS startDate, cc.Status AS STATUS, cc.CreatedBy AS createdBy, cc.CreatedDate AS createdDate, cc.UpdatedBy AS updatedBy,\r\n" + 
			"cc.UpdatedDate AS updatedDate,cc.Code AS CODE, cc.Description AS DESCRIPTION, cc.EndDate AS endDate,bu.Name AS businessUnitName,\r\n" + 
			"cc.Attr1 AS attr1, cc.Attr2 AS attr2, cc.Attr3 AS attr3, cc.Attr4 AS attr4, cc.Attr5 AS attr5, cc.Attr6 AS attr6, cc.Attr7 AS attr7,\r\n" + 
			"cc.Attr8 AS attr8, cc.Attr9 AS attr9, cc.Attr10 AS attr10, cc.Attr11 AS attr11, cc.Attr12 AS attr12, cc.Attr13 AS attr13, cc.Attr14 AS attr14, \r\n" + 
			"cc.Attr15 AS attr15, cc.Attr16 AS attr16, cc.Attr17 AS attr17, cc.Attr18 AS attr18, cc.Attr19 AS attr19,  cc.Attr20 AS attr20,cc.OrganizationId AS organizationId,mo.Name AS organizationName FROM cost_center cc\r\n" + 
			"LEFT JOIN business_unit bu ON bu.BusinessUnitId = cc.BusinessUnitId\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = cc.OrganizationId\r\n" + 
			"WHERE cc.OrganizationId =?1", nativeQuery = true)
	List<Map<String, String>> findByList(Long organizationId);

	Page<CostCenter> findByOrganizationId(Long organizationId, Pageable pageable);
	
	@Query(value = "SELECT b.Name AS BusinessUnitName  FROM business_unit  b WHERE b.BusinessUnitId=?1", nativeQuery = true)
	Optional<String> getBusinessUnitName(Long Id);
	
	
	@Query(value = "SELECT cc.CostCenterId AS costcenterId, cc.BusinessUnitId AS businessUnitId, cc.AccCode AS accCode, cc.Name AS NAME,  \r\n" + 
			"cc.StartDate AS startDate, cc.Status AS STATUS, cc.CreatedBy AS createdBy, cc.CreatedDate AS createdDate, cc.UpdatedBy AS updatedBy,\r\n" + 
			"cc.UpdatedDate AS updatedDate,cc.Code AS CODE, cc.Description AS DESCRIPTION, cc.EndDate AS endDate,bu.Name AS businessUnitName,\r\n" + 
			"cc.Attr1 AS attr1, cc.Attr2 AS attr2, cc.Attr3 AS attr3, cc.Attr4 AS attr4, cc.Attr5 AS attr5, cc.Attr6 AS attr6, cc.Attr7 AS attr7,\r\n" + 
			"cc.Attr8 AS attr8, cc.Attr9 AS attr9, cc.Attr10 AS attr10, cc.Attr11 AS attr11, cc.Attr12 AS attr12, cc.Attr13 AS attr13, cc.Attr14 AS attr14, \r\n" + 
			"cc.Attr15 AS attr15, cc.Attr16 AS attr16, cc.Attr17 AS attr17, cc.Attr18 AS attr18, cc.Attr19 AS attr19,  cc.Attr20 AS attr20,cc.OrganizationId AS organizationId,mo.Name AS organizationName FROM cost_center cc\r\n" + 
			"LEFT JOIN business_unit bu ON bu.BusinessUnitId = cc.BusinessUnitId\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = cc.OrganizationId\r\n" + 
			"WHERE cc.BusinessUnitId =?1", nativeQuery = true)
	List<Map<String, String>> findByBusinessUnitList(Long businessUnitId);

}
