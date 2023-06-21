package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{
//	
//	@Query(value = "SELECT  l.LocationId AS locationId, l.CostCenterId AS costcenterId, l.AccCode AS accCode, l.Name AS name, \r\n" + 
//			"l.StartDate AS startDate, l.Status AS status, l.CreatedBy AS createdBy, l.CreatedDate AS createdDate, l.UpdatedBy AS updatedBy,\r\n" + 
//			"l.UpdatedDate AS updatedDate,l.Code AS code, l.Description AS description, l.EndDate AS endDate,cc.Name AS costCenterName,\r\n" + 
//			"l.Attr1 AS attr1, l.Attr2 AS attr2, l.Attr3 AS attr3, l.Attr4 AS attr4, l.Attr5 AS attr5, l.Attr6 AS attr6, l.Attr7 AS attr7,\r\n" + 
//			"l.Attr8 AS attr8, l.Attr9 AS attr9, l.Attr10 AS attr10, l.Attr11 AS attr11, l.Attr12 AS attr12, l.Attr13 AS attr13, l.Attr14 AS attr14,\r\n" + 
//			"l.Attr15 AS attr15, l.Attr16 AS attr16, l.Attr17 AS attr17, l.Attr18 AS attr18, l.Attr19 AS attr19,  l.Attr20 AS attr20, cc.OrganizationId AS organizationId,mo.Name AS organizationName FROM location l\r\n" + 
//			"LEFT JOIN cost_center cc ON cc.CostCenterId = l.LocationId\r\n" + 
//			"LEFT JOIN master_organization mo ON mo.OrganizationId = cc.OrganizationId\r\n" + 
//			"WHERE cc.OrganizationId =?1", nativeQuery = true)
//	List<Map<String, String>> findByList(Long organizationId);
	@Query(value = "SELECT  l.LocationId AS locationId, l.CostCenterId AS costcenterId,cc.Name AS costCenterName, l.AccCode AS accCode, l.Name AS name,\r\n" + 
			"l.StartDate AS startDate, l.Status AS status, l.CreatedBy AS createdBy, l.CreatedDate AS createdDate, l.UpdatedBy AS updatedBy,\r\n" + 
			"l.UpdatedDate AS updatedDate,l.Code AS code, l.Description AS description, l.EndDate AS endDate,\r\n" + 
			"l.Attr1 AS attr1, l.Attr2 AS attr2, l.Attr3 AS attr3, l.Attr4 AS attr4, l.Attr5 AS attr5, l.Attr6 AS attr6, l.Attr7 AS attr7,\r\n" + 
			"l.Attr8 AS attr8, l.Attr9 AS attr9, l.Attr10 AS attr10, l.Attr11 AS attr11, l.Attr12 AS attr12, l.Attr13 AS attr13, l.Attr14 AS attr14,\r\n" + 
			"l.Attr15 AS attr15, l.Attr16 AS attr16, l.Attr17 AS attr17, l.Attr18 AS attr18, l.Attr19 AS attr19,  l.Attr20 AS attr20, l.OrganizationId AS organizationId,mo.Name AS organizationName FROM location l\r\n" + 
			"LEFT JOIN cost_center cc ON cc.CostCenterId = l.CostCenterId\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = l.OrganizationId\r\n" + 
			"WHERE l.OrganizationId =?1",nativeQuery = true)
	List<Map<String, String>> findByList(Long organizationId);
	
	Page<Location> findByOrganizationId(Long organizationId, Pageable pageable);
	
	
	@Query(value = "SELECT  l.LocationId AS locationId, l.CostCenterId AS costcenterId,cc.Name AS costCenterName, l.AccCode AS accCode, l.Name AS name,\r\n" + 
			"l.StartDate AS startDate, l.Status AS status, l.CreatedBy AS createdBy, l.CreatedDate AS createdDate, l.UpdatedBy AS updatedBy,\r\n" + 
			"l.UpdatedDate AS updatedDate,l.Code AS code, l.Description AS description, l.EndDate AS endDate,\r\n" + 
			"l.Attr1 AS attr1, l.Attr2 AS attr2, l.Attr3 AS attr3, l.Attr4 AS attr4, l.Attr5 AS attr5, l.Attr6 AS attr6, l.Attr7 AS attr7,\r\n" + 
			"l.Attr8 AS attr8, l.Attr9 AS attr9, l.Attr10 AS attr10, l.Attr11 AS attr11, l.Attr12 AS attr12, l.Attr13 AS attr13, l.Attr14 AS attr14,\r\n" + 
			"l.Attr15 AS attr15, l.Attr16 AS attr16, l.Attr17 AS attr17, l.Attr18 AS attr18, l.Attr19 AS attr19,  l.Attr20 AS attr20, l.OrganizationId AS organizationId,mo.Name AS organizationName FROM location l\r\n" + 
			"LEFT JOIN cost_center cc ON cc.CostCenterId = l.CostCenterId\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = l.OrganizationId\r\n" + 
			"WHERE l.CostCenterId =?1",nativeQuery = true)
	List<Map<String, String>> findByCostCenterList(Long costCenterId);

}
