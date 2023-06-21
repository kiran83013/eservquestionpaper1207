package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.google.common.base.Optional;
import com.travel.travtronics.model.FeildLanguageAttachments;

public interface FieldLangAttachmentsRepository extends CrudRepository<FeildLanguageAttachments, Integer> {

	@Query(value = "SELECT `service_attachments`.`AttachmentsId` AS attachment_id,\r\n"
			+ "`service_attachments`.`Name` AS  actual_name,`field_language_attachments`.`lang_name`,\r\n"
			+ "`field_language_attachments`.`attachment_name`,`field_language_attachments`.`created_by`,\r\n"
			+ "`field_language_attachments`.`created_date` ,`field_language_attachments`.`updated_by`,`field_language_attachments`.`updated_date`,`field_language_attachments`.`id`,`field_language_attachments`.`header_id`\r\n"
			+ "FROM `service_attachments`\r\n"
			+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
			+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2\r\n"
			+ "AND `field_language_attachments`.`lang_name` IS  NULL", nativeQuery = true)
	List<Map<String, Object>> getNewAttachmentsList(Integer langId, Integer orgId);

	@Query(value = "SELECT `service_attachments`.`AttachmentsId` AS attachment_id,\r\n"
			+ "`service_attachments`.`Name` AS  actual_name,`field_language_attachments`.`lang_name`,\r\n"
			+ "`field_language_attachments`.`attachment_name`,`field_language_attachments`.`created_by`,\r\n"
			+ "`field_language_attachments`.`created_date` ,`field_language_attachments`.`updated_by`,`field_language_attachments`.`updated_date`,`field_language_attachments`.`id`,`field_language_attachments`.`header_id`\r\n"
			+ "FROM `service_attachments`\r\n"
			+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
			+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2\r\n"
			+ "AND `field_language_attachments`.`lang_name` IS  NULL", countQuery = "SELECT COUNT(1)\r\n"
					+ "FROM `service_attachments`\r\n"
					+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
					+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
					+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2\r\n"
					+ "AND `field_language_attachments`.`lang_name` IS  NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewAttachMentPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT `service_attachments`.`AttachmentsId` AS attachment_id,\r\n"
			+ "`service_attachments`.`Name` AS  actual_name,`field_language_attachments`.`lang_name`,\r\n"
			+ "`field_language_attachments`.`attachment_name`,`field_language_attachments`.`created_by`,\r\n"
			+ "`field_language_attachments`.`created_date` ,`field_language_attachments`.`updated_by`,`field_language_attachments`.`updated_date`,`field_language_attachments`.`id`,`field_language_attachments`.`header_id`\r\n"
			+ "FROM `service_attachments`\r\n"
			+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
			+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2", countQuery = "SELECT COUNT(1)\r\n"
					+ "FROM `service_attachments`\r\n"
					+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
					+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
					+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2", nativeQuery = true)
	Page<Map<String, Object>> getNewAttachMentAllPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT `service_attachments`.`AttachmentsId` AS attachment_id,\r\n"
			+ "`service_attachments`.`Name` AS  actual_name,`field_language_attachments`.`lang_name`,\r\n"
			+ "`field_language_attachments`.`attachment_name`,`field_language_attachments`.`created_by`,\r\n"
			+ "`field_language_attachments`.`created_date` ,`field_language_attachments`.`updated_by`,`field_language_attachments`.`updated_date`,`field_language_attachments`.`id`,`field_language_attachments`.`header_id`\r\n"
			+ "FROM `service_attachments`\r\n"
			+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
			+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2\r\n"
			+ "AND `field_language_attachments`.`lang_name` IS NOT  NULL", countQuery = "SELECT COUNT(1)\r\n"
					+ "FROM `service_attachments`\r\n"
					+ "LEFT JOIN `field_language_attachments` ON `field_language_attachments`.`attachment_id`=`service_attachments`.`AttachmentsId`\r\n"
					+ "AND lang_id=?1 AND `field_language_attachments`.`org_id`=?2\r\n"
					+ "WHERE 1=1 AND `service_attachments`.`OrganizationId`=?2\r\n"
					+ "AND `field_language_attachments`.`lang_name` IS NOT  NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewAttachMentNonExistsPagination(Integer langId, Integer orgId, Pageable page);

	@Query("select a from FeildLanguageAttachments a where a.orgId=?1 and a.attachmentId=?2 and a.langCode=?3")
	Optional<FeildLanguageAttachments> getLocalizationInfo(int orgId, Integer attachmentId, String langCode);

}
