package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.FieldLanguageDepartments;

public interface FieldLanguageDepartmentsRepository extends JpaRepository<FieldLanguageDepartments, Integer> {

	@Query(value = "SELECT \r\n" + "master_departments.DepartmentId AS department_id,\r\n"
			+ "master_departments.Name AS actual_name,\r\n" + "field_language_departments.lang_name,\r\n"
			+ "field_language_departments.name,\r\n" + "field_language_departments.created_by,\r\n"
			+ "field_language_departments.created_date,\r\n" + "field_language_departments.updated_by,\r\n"
			+ "field_language_departments.updated_date,field_language_departments.`id`,\r\n"
			+ "field_language_departments.`header_id`\r\n" + "FROM master_departments\r\n"
			+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
			+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2", countQuery = "SELECT \r\n"
					+ "COUNT(1)\r\n" + "FROM master_departments\r\n"
					+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
					+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2", nativeQuery = true)
	Page<Map<String, Object>> getAllFieldLangDeptInfo(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT \r\n" + "master_departments.DepartmentId AS department_id,\r\n"
			+ "master_departments.Name AS actual_name,\r\n" + "field_language_departments.lang_name,\r\n"
			+ "field_language_departments.name,\r\n" + "field_language_departments.created_by,\r\n"
			+ "field_language_departments.created_date,\r\n" + "field_language_departments.updated_by,\r\n"
			+ "field_language_departments.updated_date,field_language_departments.`id`,\r\n"
			+ "field_language_departments.`header_id`\r\n" + "FROM master_departments\r\n"
			+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
			+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2\r\n"
			+ "AND field_language_departments.lang_name IS NULL", countQuery = "SELECT \r\n" + "COUNT(1)\r\n"
					+ "FROM master_departments\r\n"
					+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
					+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2\r\n"
					+ "AND field_language_departments.lang_name IS NULL", nativeQuery = true)
	Page<Map<String, Object>> getAllFieldNotExistsLangDeptInfo(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT \r\n" + "master_departments.DepartmentId AS department_id,\r\n"
			+ "master_departments.Name AS actual_name,\r\n" + "field_language_departments.lang_name,\r\n"
			+ "field_language_departments.name,\r\n" + "field_language_departments.created_by,\r\n"
			+ "field_language_departments.created_date,\r\n" + "field_language_departments.updated_by,\r\n"
			+ "field_language_departments.updated_date,field_language_departments.`id`,\r\n"
			+ "field_language_departments.`header_id`\r\n" + "FROM master_departments\r\n"
			+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
			+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2\r\n"
			+ "AND field_language_departments.lang_name IS NOT NULL", countQuery = "SELECT \r\n" + "COUNT(1)\r\n"
					+ "FROM master_departments\r\n"
					+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
					+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2\r\n"
					+ "AND field_language_departments.lang_name IS NOT NULL", nativeQuery = true)
	Page<Map<String, Object>> getAllFeildExistsLangInfo(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT \r\n" + "master_departments.DepartmentId AS department_id,\r\n"
			+ "master_departments.Name AS actual_name,\r\n" + "field_language_departments.lang_name,\r\n"
			+ "field_language_departments.name,\r\n" + "field_language_departments.created_by,\r\n"
			+ "field_language_departments.created_date,\r\n" + "field_language_departments.updated_by,\r\n"
			+ "field_language_departments.updated_date,field_language_departments.`id`,\r\n"
			+ "field_language_departments.`header_id`\r\n" + "FROM master_departments\r\n"
			+ "LEFT JOIN field_language_departments ON master_departments.DepartmentId = field_language_departments.department_id AND lang_id = ?1 AND field_language_departments.org_id = ?2\r\n"
			+ "WHERE 1=1 \r\n" + "AND master_departments.OrganizationId = ?2\r\n"
			+ "AND field_language_departments.lang_name IS NULL", nativeQuery = true)
	List<Map<String, Object>> getAllFieldNotExistsLangDeptList(Integer langId, Integer orgId);

	Optional<FieldLanguageDepartments> findByOrgIdAndDepartmentIdAndLangCode(Integer orgId, Integer deptId,
			String langCode);
}
