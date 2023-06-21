package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.travel.travtronics.model.FeildLanguageHeaderModel;

public interface FeildLanguageHeaderRepository extends PagingAndSortingRepository<FeildLanguageHeaderModel, Integer> {

	boolean existsById(Integer id);

	@Query(value = "SELECT input_type_config.ID AS field_id,input_type_config.name AS tech_name ,\r\n"
			+ "field_language_lines.lang_name,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.label'),'\\\"','') AS actual_label,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.placeholder'),'\\\"','') AS actual_placeholder,\r\n"
			+ "field_language_lines.label,field_language_lines.place_holder,\r\n"
			+ "field_language_lines.hint,field_language_lines.info,\r\n"
			+ "field_language_lines.created_by,field_language_lines.updated_by,\r\n"
			+ "field_language_lines.header_id,field_language_lines.lang_code,\r\n"
			+ "field_language_lines.lang_id,field_language_lines.status,field_language_lines.id,\r\n"
			+ "field_language_lines.org_id FROM input_type_config \r\n"
			+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
			+ "WHERE 1=1 AND input_type_config.organizationId = ?2\r\n", countQuery = "SELECT \r\n" + "COUNT(*)\r\n"
					+ "FROM input_type_config \r\n"
					+ "-- LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
					+ "WHERE 1=1 \r\n" + "AND input_type_config.organizationId = ?2", nativeQuery = true)
	Page<Map<String, Object>> getFeildsByLanguageAndOrganization(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT input_type_config.ID AS field_id,input_type_config.name AS tech_name ,\r\n"
			+ "field_language_lines.lang_name,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.label'),'\\\"','') AS actual_label,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.placeholder'),'\\\"','') AS actual_placeholder,\r\n"
			+ "field_language_lines.label,field_language_lines.place_holder,\r\n"
			+ "field_language_lines.hint,field_language_lines.info,\r\n"
			+ "field_language_lines.created_by,field_language_lines.updated_by,\r\n"
			+ "field_language_lines.header_id,field_language_lines.lang_code,\r\n"
			+ "field_language_lines.lang_id,field_language_lines.status,field_language_lines.id,\r\n"
			+ "field_language_lines.org_id FROM input_type_config \r\n"
			+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
			+ "WHERE 1=1 AND input_type_config.organizationId = ?2\r\n"
			+ "AND field_language_lines.lang_name IS NULL", nativeQuery = true)
	List<Map<String, Object>> getNewFeildsLang(Integer langId, Integer orgId);

//	@Query(value = "SELECT input_type_config.ID AS field_id,input_type_config.name AS tech_name ,\r\n"
//			+ "field_language_lines.lang_name,\r\n"
//			+ "REPLACE(json_extract(input_type_config.ui, '$.label'),'\\\"','') AS actual_label,\r\n"
//			+ "REPLACE(json_extract(input_type_config.ui, '$.placeholder'),'\\\"','') AS actual_placeholder,\r\n"
//			+ "field_language_lines.label,field_language_lines.place_holder,\r\n"
//			+ "field_language_lines.hint,field_language_lines.info,\r\n"
//			+ "field_language_lines.created_by,field_language_lines.updated_by,\r\n"
//			+ "field_language_lines.header_id,field_language_lines.lang_code,\r\n"
//			+ "field_language_lines.lang_id,field_language_lines.status,field_language_lines.id,\r\n"
//			+ "field_language_lines.org_id FROM input_type_config \r\n"
//			+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
//			+ "WHERE 1=1 AND input_type_config.organizationId = ?2 \r\n", countQuery = "SELECT \r\n" + "COUNT(*)\r\n"
//					+ "FROM input_type_config \r\n"
//					+ "-- LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
//					+ "WHERE 1=1 \r\n" + "AND input_type_config.organizationId = ?2", nativeQuery = true)
//	Page<Map<String, Object>> getFeildsByLanguageAndOrganization123(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT input_type_config.ID AS field_id,input_type_config.name AS tech_name ,\r\n"
			+ "field_language_lines.lang_name,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.label'),'\\\"','') AS actual_label,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.placeholder'),'\\\"','') AS actual_placeholder,\r\n"
			+ "field_language_lines.label,field_language_lines.place_holder,\r\n"
			+ "field_language_lines.hint,field_language_lines.info,\r\n"
			+ "field_language_lines.created_by,field_language_lines.updated_by,\r\n"
			+ "field_language_lines.header_id,field_language_lines.lang_code,\r\n"
			+ "field_language_lines.lang_id,field_language_lines.status,field_language_lines.id,\r\n"
			+ "field_language_lines.org_id FROM input_type_config \r\n"
			+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
			+ "WHERE 1=1 AND input_type_config.organizationId = ?2 AND field_language_lines.lang_name IS NULL\r\n", nativeQuery = true)
	List<Map<String, Object>> getNewFeildsLangNonExists(Integer langId, Integer orgId);

	@Query(value = "SELECT input_type_config.ID AS field_id,input_type_config.name AS tech_name ,\r\n"
			+ "field_language_lines.lang_name,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.label'),'\\\"','') AS actual_label,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.placeholder'),'\\\"','') AS actual_placeholder,\r\n"
			+ "field_language_lines.label,field_language_lines.place_holder,\r\n"
			+ "field_language_lines.hint,field_language_lines.info,\r\n"
			+ "field_language_lines.created_by,field_language_lines.updated_by,\r\n"
			+ "field_language_lines.header_id,field_language_lines.lang_code,\r\n"
			+ "field_language_lines.lang_id,field_language_lines.status,field_language_lines.id,\r\n"
			+ "field_language_lines.org_id FROM input_type_config \r\n"
			+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
			+ "WHERE 1=1 AND input_type_config.organizationId = ?2\r\n", countQuery = "SELECT \r\n" + "COUNT(*)\r\n"
					+ "FROM input_type_config \r\n"
					+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
					+ "WHERE 1=1 \r\n"
					+ "AND input_type_config.organizationId = ?2 AND field_language_lines.lang_name IS NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewFeildsNonExistsPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT input_type_config.ID AS field_id,input_type_config.name AS tech_name ,\r\n"
			+ "field_language_lines.lang_name,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.label'),'\\\"','') AS actual_label,\r\n"
			+ "REPLACE(json_extract(input_type_config.ui, '$.placeholder'),'\\\"','') AS actual_placeholder,\r\n"
			+ "field_language_lines.label,field_language_lines.place_holder,\r\n"
			+ "field_language_lines.hint,field_language_lines.info,\r\n"
			+ "field_language_lines.created_by,field_language_lines.updated_by,\r\n"
			+ "field_language_lines.header_id,field_language_lines.lang_code,\r\n"
			+ "field_language_lines.lang_id,field_language_lines.status,field_language_lines.id,\r\n"
			+ "field_language_lines.org_id FROM input_type_config \r\n"
			+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND field_language_lines.lang_id = ?1 AND field_language_lines.org_id = ?2\r\n"
			+ "WHERE 1=1 AND input_type_config.organizationId = ?2\r\n"
			+ "AND field_language_lines.lang_name IS NOT NULL", countQuery = "SELECT \r\n" + "COUNT(*)\r\n"
					+ "FROM input_type_config \r\n"
					+ "LEFT JOIN field_language_lines ON input_type_config.ID = field_language_lines.field_id AND lang_id = 3 AND field_language_lines.org_id = 1\r\n"
					+ "WHERE 1=1 \r\n"
					+ "AND input_type_config.organizationId = 1 AND field_language_lines.lang_name IS NOT NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewFeildsExistsPagination(Integer langId, Integer orgId, Pageable page);
}
