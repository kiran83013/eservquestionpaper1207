package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.MasterCategory;


public interface MasterCategoryRepository extends JpaRepository<MasterCategory, Long>{

	Optional<MasterCategory> findByCategoryId(Long categoryId);
	
//	@Query(value = "SELECT mc.category_id AS categoryId,mc.code AS CODE,mc.created_date AS createddate,mc.created_by AS createdBy,\r\n" + 
//			"mc.description AS description,mc.end_date AS enddate,mc.module_id AS moduleId ,mm.name AS moduleName,mct.name AS categoryTypeName, mc.name,mc.start_date AS startDate,mc.status AS status, \r\n" + 
//			"mc.tn_key AS schemaKey,mc.organization_id AS organizationId,mo.Name AS OrganizationName,\r\n" + 
//			"mc.updated_date AS updatedDate,mc.updated_by AS updatedBy FROM e_services.master_category mc\r\n" + 
//			"LEFT JOIN e_services.master_category_type mct ON mct.category_id = mc.category_id\r\n" + 
//			"LEFT JOIN e_services.master_module mm ON mm.Id = mc.module_id\r\n" + 
//			"LEFT JOIN e_services.master_organization mo ON mo.OrganizationId = mc.organization_id\r\n" + 
//			"WHERE mc.organization_id =?1",nativeQuery = true)
//	List<Map<String,String>> findAllByCategoryId(Long organizationId);

	Page<MasterCategory> findByOrganizationId(Long organizationId, Pageable pageable);
	
	@Query(value = "SELECT mc.category_id AS categoryId,mc.code AS CODE,mc.created_date AS createddate,mc.created_by AS createdBy,\r\n" + 
			"mc.description AS description,mc.end_date AS enddate,mc.module_id AS moduleId ,mm.name AS moduleName,mc.category_type_id AS categorytypeid, mct.name AS categoryTypeName, mc.name,mc.start_date AS startDate,mc.status AS status,\r\n" + 
			"mc.tn_key AS schemaKey,mc.organization_id AS organizationId,mo.Name AS OrganizationName,\r\n" + 
			"mc.updated_date AS updatedDate,mc.updated_by AS updatedBy FROM e_services.master_category mc\r\n" + 
			"LEFT JOIN e_services.master_category_type mct ON mct.category_id = mc.category_type_id\r\n" + 
			"LEFT JOIN e_services.master_module mm ON mm.Id = mc.module_id\r\n" + 
			"LEFT JOIN e_services.master_organization mo ON mo.OrganizationId = mc.organization_id\r\n" + 
			"WHERE mc.organization_id =?1",nativeQuery = true)
	List<Map<String, String>> findAllByOrganizationIdId(Long organizationId);

}
