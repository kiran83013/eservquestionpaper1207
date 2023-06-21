package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.google.common.base.Optional;
import com.travel.travtronics.model.FieldLangDocuments;

public interface FieldLangDocumentsRepository extends CrudRepository<FieldLangDocuments, Integer> {

	@Query(value = "SELECT  `service_documents`.`Id` AS doc_id,`service_documents`.`Name` AS actual_name,\r\n"
			+ "`field_language_documents`.`lang_name`,`field_language_documents`.`document_name`,`field_language_documents`.`created_by`,\r\n"
			+ "`field_language_documents`.`created_date`,`field_language_documents`.`updated_by`,`field_language_documents`.`updated_date`,`field_language_documents`.`id`,`field_language_documents`.`header_id`  \r\n"
			+ "FROM `service_documents`\r\n"
			+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
			+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
			+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2\r\n"
			+ "AND `field_language_documents`.`lang_name` IS NULL", nativeQuery = true)
	List<Map<String, Object>> getNullDocsList(Integer langId, Integer orgId);

	@Query(value = "SELECT  `service_documents`.`Id` AS doc_id,`service_documents`.`Name` AS actual_name,\r\n"
			+ "`field_language_documents`.`lang_name`,`field_language_documents`.`document_name`,`field_language_documents`.`created_by`,\r\n"
			+ "`field_language_documents`.`created_date`,`field_language_documents`.`updated_by`,`field_language_documents`.`updated_date`,`field_language_documents`.`id`,`field_language_documents`.`header_id`  \r\n"
			+ "FROM `service_documents`\r\n"
			+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
			+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
			+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2\r\n"
			+ "AND `field_language_documents`.`lang_name` IS NULL", countQuery = "SELECT  COUNT(1)\r\n"
					+ "FROM `service_documents`\r\n"
					+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
					+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
					+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2\r\n"
					+ "AND `field_language_documents`.`lang_name` IS NULL", nativeQuery = true)
	Page<Map<String, Object>> getNullDocsListPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT  `service_documents`.`Id` AS doc_id,`service_documents`.`Name` AS actual_name,\r\n"
			+ "`field_language_documents`.`lang_name`,`field_language_documents`.`document_name`,`field_language_documents`.`created_by`,\r\n"
			+ "`field_language_documents`.`created_date`,`field_language_documents`.`updated_by`,`field_language_documents`.`updated_date`,`field_language_documents`.`id`,`field_language_documents`.`header_id`  \r\n"
			+ "FROM `service_documents`\r\n"
			+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
			+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
			+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2", countQuery = "SELECT  COUNT(1)\r\n"
					+ "FROM `service_documents`\r\n"
					+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
					+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
					+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2", nativeQuery = true)
	Page<Map<String, Object>> getAllDocsPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT  `service_documents`.`Id` AS doc_id,`service_documents`.`Name` AS actual_name,\r\n"
			+ "`field_language_documents`.`lang_name`,`field_language_documents`.`document_name`,`field_language_documents`.`created_by`,\r\n"
			+ "`field_language_documents`.`created_date`,`field_language_documents`.`updated_by`,`field_language_documents`.`updated_date`,`field_language_documents`.`id`,`field_language_documents`.`header_id`  \r\n"
			+ "FROM `service_documents`\r\n"
			+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
			+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
			+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2\r\n"
			+ "AND `field_language_documents`.`lang_name` IS NOT NULL", countQuery = "SELECT  COUNT(1)\r\n"
					+ "FROM `service_documents`\r\n"
					+ "LEFT JOIN `field_language_documents` ON `field_language_documents`.`document_id`=`service_documents`.`Id`\r\n"
					+ "AND lang_id=?1 AND `field_language_documents`.`org_id`=?2   \r\n"
					+ "WHERE 1=1 AND `service_documents`.`OrganizationId`=?2\r\n"
					+ "AND `field_language_documents`.`lang_name` IS NOT NULL", nativeQuery = true)
	Page<Map<String, Object>> getNotNullDocsPagination(Integer langId, Integer orgId, Pageable page);

	@Query("select doc from FieldLangDocuments doc where doc.orgId=?1 and doc.docId=?2 and doc.langCode=?3")
	Optional<FieldLangDocuments> getLocalizationInfo(int orgId, Integer docId, String langCode);

}
