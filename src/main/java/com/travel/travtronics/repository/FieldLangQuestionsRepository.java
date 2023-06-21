package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.travel.travtronics.model.FieldLangQuestions;

public interface FieldLangQuestionsRepository extends CrudRepository<FieldLangQuestions, Integer> {

	@Query(value = "SELECT `questions`.`Id` AS question_id,`questions`.`Question` AS actual_name,`field_language_questions`.`lang_name`,`field_language_questions`.`question_name`,\r\n"
			+ "`field_language_questions`.`created_by`,`field_language_questions`.`created_date`,`field_language_questions`.`updated_by`,`field_language_questions`.`updated_date`,"
			+ "`field_language_questions`.`id`,`field_language_questions`.`header_id`\r\n" + "FROM `questions`\r\n"
			+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `questions`.`Organization`=?2\r\n"
			+ "AND `field_language_questions`.`lang_name` IS NULL", nativeQuery = true)
	List<Map<String, Object>> getNewLangQuestions(Integer langId, Integer orgId);

	@Query(value = "SELECT `questions`.`Id` AS question_id,`questions`.`Question` AS actual_name,`field_language_questions`.`lang_name`,`field_language_questions`.`question_name`,\r\n"
			+ "`field_language_questions`.`created_by`,`field_language_questions`.`created_date`,`field_language_questions`.`updated_by`,`field_language_questions`.`updated_date`,"
			+ "`field_language_questions`.`id`,`field_language_questions`.`header_id`\r\n" + "FROM `questions`\r\n"
			+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `questions`.`Organization`=?2\r\n"
			+ "AND `field_language_questions`.`lang_name` IS NULL", countQuery = "SELECT COUNT(1)\r\n"
					+ " FROM `questions`\r\n"
					+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
					+ "WHERE 1=1 AND `questions`.`Organization`=?2\r\n"
					+ "AND `field_language_questions`.`lang_name` IS NULL", nativeQuery = true)
	Page<Map<String, Object>> getNewLangQuestions(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT `questions`.`Id` AS question_id,`questions`.`Question` AS actual_name,`field_language_questions`.`lang_name`,`field_language_questions`.`question_name`,\r\n"
			+ "`field_language_questions`.`created_by`,`field_language_questions`.`created_date`,`field_language_questions`.`updated_by`,`field_language_questions`.`updated_date`,"
			+ "`field_language_questions`.`id`,`field_language_questions`.`header_id`\r\n" + "FROM `questions`\r\n"
			+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `questions`.`Organization`=?2", countQuery = "SELECT COUNT(1)\r\n" + "FROM `questions`\r\n"
					+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
					+ "WHERE 1=1 AND `questions`.`Organization`=?2", nativeQuery = true)
	Page<Map<String, Object>> getAllLangQuestions(Integer langId, Integer orgId, Pageable page);

	@Query(value = "SELECT `questions`.`Id` AS question_id,`questions`.`Question` AS actual_name,`field_language_questions`.`lang_name`,`field_language_questions`.`question_name`,\r\n"
			+ "`field_language_questions`.`created_by`,`field_language_questions`.`created_date`,`field_language_questions`.`updated_by`,`field_language_questions`.`updated_date`,"
			+ "`field_language_questions`.`id`,`field_language_questions`.`header_id`\r\n" + "FROM `questions`\r\n"
			+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
			+ "WHERE 1=1 AND `questions`.`Organization`=?2\r\n"
			+ "AND `field_language_questions`.`lang_name` IS NOT NULL", countQuery = "SELECT COUNT(1)\r\n"
					+ " FROM `questions`\r\n"
					+ "LEFT JOIN `field_language_questions` ON `field_language_questions`.`question_id`=`questions`.`Id` AND lang_id=?1 AND `field_language_questions`.`org_id`=?2\r\n"
					+ "WHERE 1=1 AND `questions`.`Organization`=?2\r\n"
					+ "AND `field_language_questions`.`lang_name` IS NOT NULL", nativeQuery = true)
	Page<Map<String, Object>> getExistsLangQuestions(Integer langId, Integer orgId, Pageable page);

}
