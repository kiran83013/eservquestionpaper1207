package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.travel.travtronics.model.FeildLangFaq;
import com.travel.travtronics.response.LangQuestionAnswerResponse;

public interface FeildLangFaqRepository extends CrudRepository<FeildLangFaq, Integer> {

	@Query(value = "SELECT\r\n" + "faqs.Id AS faq_id,\r\n"
			+ "questions.Question AS actual_question,questions.`Id` actual_question_id,\r\n"
			+ "faqs.Answer AS actual_answer,\r\n"
			+ "field_language_questions.`question_name`  AS lang_question,faqs.`Reference` AS reference_type,faqs.`ReferenceId` AS reference_id,\r\n"
			+ "`field_language_faqs`.`answer` AS lang_answer,`field_language_faqs`.`id` AS id,`field_language_faqs`.`header_id`,\r\n"
			+ "`field_language_faqs`.`lang_code`,`field_language_faqs`.`created_by`,`field_language_faqs`.`created_date`,\r\n"
			+ "`field_language_faqs`.`updated_by`,`field_language_faqs`.`updated_date`,\r\n"
			+ "`service_types_header`.`ID` AS sr_type_id,`service_types_header`.`Name` AS sr_type_name\r\n"
			+ "FROM faqs \r\n" + "\r\n" + "JOIN questions ON faqs.Question = questions.Id\r\n"
			+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
			+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
			+ "\r\n" + "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
			+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
			+ "AND field_language_faqs.`org_id` = ?2 \r\n" + "AND field_language_faqs.`lang_id` = ?1\r\n" + "WHERE \r\n"
			+ "faqs.`Organization` = ?2 AND`faqs`.`Reference`='SRTYPE'  AND `field_language_faqs`.`lang_name` IS  NULL", nativeQuery = true)
	List<Map<String, Object>> getNewLangFaq(Integer langId, Integer orgId);

	@Query(value = "SELECT\r\n" + "faqs.Id AS faq_id,\r\n"
			+ "questions.Question AS actual_question,questions.`Id` actual_question_id,\r\n"
			+ "faqs.Answer AS actual_answer,\r\n"
			+ "field_language_questions.`question_name`  AS lang_question,faqs.`Reference` AS reference_type,faqs.`ReferenceId` AS reference_id,\r\n"
			+ "`field_language_faqs`.`answer` AS lang_answer,`field_language_faqs`.`id` AS id,`field_language_faqs`.`header_id`,\r\n"
			+ "`field_language_faqs`.`lang_code`,`field_language_faqs`.`created_by`,`field_language_faqs`.`created_date`,\r\n"
			+ "`field_language_faqs`.`updated_by`,`field_language_faqs`.`updated_date`,\r\n"
			+ "`service_types_header`.`ID` AS sr_type_id,`service_types_header`.`Name` AS sr_type_name\r\n"
			+ "FROM faqs \r\n" + "\r\n" + "JOIN questions ON faqs.Question = questions.Id\r\n"
			+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
			+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
			+ "\r\n" + "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
			+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
			+ "AND field_language_faqs.`org_id` = ?2 \r\n" + "AND field_language_faqs.`lang_id` = ?1\r\n" + "WHERE \r\n"
			+ "faqs.`Organization` = ?2 AND`faqs`.`Reference`='SRTYPE'  AND `field_language_faqs`.`lang_name` IS  NULL", countQuery = "SELECT COUNT(1)\r\n"
					+ "FROM faqs JOIN questions ON faqs.Question = questions.Id\r\n"
					+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
					+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
					+ "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
					+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
					+ "AND field_language_faqs.`org_id` = ?2 AND field_language_faqs.`lang_id` = ?1 \r\n" + "WHERE\r\n"
					+ "faqs.`Organization` = ?2 AND `faqs`.`Reference`='SRTYPE'  AND `field_language_faqs`.`lang_name` IS  NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewLangfaqPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT\r\n" + "faqs.Id AS faq_id,\r\n"
			+ "questions.Question AS actual_question,questions.`Id` actual_question_id,\r\n"
			+ "faqs.Answer AS actual_answer,\r\n"
			+ "field_language_questions.`question_name`  AS lang_question,faqs.`Reference` AS reference_type,faqs.`ReferenceId` AS reference_id,\r\n"
			+ "`field_language_faqs`.`answer` AS lang_answer,`field_language_faqs`.`id` AS id,`field_language_faqs`.`header_id`,\r\n"
			+ "`field_language_faqs`.`lang_code`,`field_language_faqs`.`created_by`,`field_language_faqs`.`created_date`,\r\n"
			+ "`field_language_faqs`.`updated_by`,`field_language_faqs`.`updated_date`,\r\n"
			+ "`service_types_header`.`ID` AS sr_type_id,`service_types_header`.`Name` AS sr_type_name\r\n"
			+ "FROM faqs \r\n" + "\r\n" + "JOIN questions ON faqs.Question = questions.Id\r\n"
			+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
			+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
			+ "\r\n" + "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
			+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
			+ "AND field_language_faqs.`org_id` = ?2 \r\n" + "AND field_language_faqs.`lang_id` = ?1\r\n" + "WHERE \r\n"
			+ "faqs.`Organization` = ?2 AND`faqs`.`Reference`='SRTYPE'  AND `field_language_faqs`.`lang_name` IS NOT NULL", countQuery = "SELECT COUNT(1)\r\n"
					+ "FROM faqs JOIN questions ON faqs.Question = questions.Id\r\n"
					+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
					+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
					+ "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
					+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
					+ "AND field_language_faqs.`org_id` = ?2 AND field_language_faqs.`lang_id` = ?1 \r\n" + "WHERE\r\n"
					+ "faqs.`Organization` = ?2 AND `faqs`.`Reference`='SRTYPE'  AND `field_language_faqs`.`lang_name` IS NOT NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewLangfaqExistsPagination(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT\r\n" + "faqs.Id AS faq_id,\r\n"
			+ "questions.Question AS actual_question,questions.`Id` actual_question_id,\r\n"
			+ "faqs.Answer AS actual_answer,\r\n"
			+ "field_language_questions.`question_name`  AS lang_question,faqs.`Reference` AS reference_type,faqs.`ReferenceId` AS reference_id,\r\n"
			+ "`field_language_faqs`.`answer` AS lang_answer,`field_language_faqs`.`id` AS id,`field_language_faqs`.`header_id`,\r\n"
			+ "`field_language_faqs`.`lang_code`,`field_language_faqs`.`created_by`,`field_language_faqs`.`created_date`,\r\n"
			+ "`field_language_faqs`.`updated_by`,`field_language_faqs`.`updated_date`,\r\n"
			+ "`service_types_header`.`ID` AS sr_type_id,`service_types_header`.`Name` AS sr_type_name\r\n"
			+ "FROM faqs \r\n" + "\r\n" + "JOIN questions ON faqs.Question = questions.Id\r\n"
			+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
			+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
			+ "\r\n" + "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
			+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
			+ "AND field_language_faqs.`org_id` = ?2 \r\n" + "AND field_language_faqs.`lang_id` = ?1\r\n" + "WHERE \r\n"
			+ "faqs.`Organization` = ?2 AND`faqs`.`Reference`='SRTYPE'", countQuery = "SELECT COUNT(1)\r\n"
					+ "FROM faqs JOIN questions ON faqs.Question = questions.Id\r\n"
					+ "LEFT JOIN `service_types_header` ON `faqs`.`ReferenceId`=`service_types_header`.`ID`\r\n"
					+ "LEFT JOIN `field_language_questions` ON faqs.Question = `field_language_questions`.`question_id` AND field_language_questions.`lang_id` = ?1\r\n"
					+ "LEFT JOIN `field_language_faqs` ON faqs.Question = `field_language_faqs`.`question_id` \r\n"
					+ "AND faqs.`ReferenceId` =  field_language_faqs.reference_id  AND `faqs`.`Reference` = field_language_faqs.reference_type\r\n"
					+ "AND field_language_faqs.`org_id` = ?2 AND field_language_faqs.`lang_id` = ?1 \r\n" + "WHERE\r\n"
					+ "faqs.`Organization` = ?2 AND `faqs`.`Reference`='SRTYPE'\r\n" + "	", nativeQuery = true)
	Page<Map<String, Object>> getNewAllLangfaqPagination(Integer langId, Integer orgId, Pageable page);

	@Query("select new com.travel.travtronics.response.LangQuestionAnswerResponse(faq.questionName,faq.answer) "
			+ "from FeildLangFaq faq where faq.referenceId=?1 and faq.referenceType=?2 and faq.langCode=?3 and faq.orgId=?4")
	Optional<LangQuestionAnswerResponse> getLocalizedFaqInfo(Integer referenceId, String referenceType, String langCode,
			int orgId);

}
