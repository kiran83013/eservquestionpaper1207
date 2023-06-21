package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.GenerateSetupMaster;

public interface GenerateSetupMasterRepository extends JpaRepository<GenerateSetupMaster, Long> {

	@Query(value = "SELECT mgs.id,mgs.name,mgs.code,mgs.description,mgs.org_id AS orgId,mgs.category_id AS categoryId,mgs.created_by AS createdBy,mgs.created_date AS createdDate, mgs.updated_by AS updatedBy,\r\n"
			+ "mgs.updated_date AS updatedDate,mgs.status,mc.name AS categoryName,mo.Name AS organizationName  FROM master_general_setup mgs\r\n"
			+ "LEFT JOIN  master_category mc ON mc.category_id  = mgs.category_id\r\n"
			+ "LEFT JOIN  master_organization mo ON mo.OrganizationId = mgs.org_id WHERE mgs.org_id =?1", nativeQuery = true)
	List<Map<String, String>> findByOrgId(Long orgId);

	List<GenerateSetupMaster> findByCategoryId(Long categoryId);

	@Query(value = "SELECT mgs.id,mgs.name,mgs.code,mgs.description,mgs.org_id AS orgId,mgs.category_id AS categoryId,mgs.created_by AS createdBy,mgs.created_date AS createdDate, mgs.updated_by AS updatedBy,\r\n"
			+ "mgs.updated_date AS updatedDate,mgs.status,mc.name AS categoryName,mo.Name AS organizationName  FROM master_general_setup mgs\r\n"
			+ "LEFT JOIN  master_category mc ON mc.category_id  = mgs.category_id\r\n"
			+ "LEFT JOIN  master_organization mo ON mo.OrganizationId = mgs.org_id WHERE mgs.org_id =?1 AND mgs.category_id=?2", nativeQuery = true)
	List<Map<String, String>> findByOrgIdAndCategoryId(Long orgId, Long categoryId);

	@Query(value = "SELECT mgs.id,\r\n"
			+ "CASE WHEN translated_master.id IS NOT NULL THEN translated_master.name ELSE mgs.name END  AS `name`,\r\n"
			+ "CASE WHEN translated_master.id IS NOT NULL THEN translated_master.code ELSE mgs.code END  AS `code`,\r\n"
			+ "CASE WHEN translated_master.id IS NOT NULL THEN translated_master.description ELSE mgs.description END  AS `description`,\r\n"
			+ "mgs.org_id AS orgId,\r\n" + "mgs.category_id AS categoryId,\r\n" + "mgs.created_by AS createdBy,\r\n"
			+ "mgs.created_date AS createdDate,\r\n" + "mgs.updated_by AS updatedBy,\r\n"
			+ "mgs.updated_date AS updatedDate,\r\n" + "mgs.status,mc.name AS categoryName,\r\n"
			+ "mo.Name AS organizationName  \r\n" + "FROM master_general_setup mgs\r\n"
			+ "LEFT JOIN  field_language_general_setup_master translated_master ON translated_master.general_master_setup_id=mgs.id \r\n"
			+ "AND LOWER(translated_master.lang_code)=?3 AND translated_master.org_id=?1\r\n"
			+ "LEFT JOIN  master_category mc ON mc.category_id  = mgs.category_id\r\n"
			+ "LEFT JOIN  master_organization mo ON mo.OrganizationId = mgs.org_id\r\n"
			+ "WHERE mgs.org_id =?1 AND mgs.category_id=?2 ", nativeQuery = true)
	List<Map<String, String>> findByOrgIdAndCategoryIdLocalization(Long orgId, Long categoryId, String langCode);

}
