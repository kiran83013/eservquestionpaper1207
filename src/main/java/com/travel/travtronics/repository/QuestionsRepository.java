package com.travel.travtronics.repository;

import com.travel.travtronics.model.Questions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface QuestionsRepository extends JpaRepository<Questions, Long> {

    //Custom query
    @Query(value = "SELECT * FROM questions WHERE Question LIKE %:question%" , nativeQuery = true)
    List<Questions> findByQuestion(@Param("question") String question);

	List<Questions> findAllByOrganization(Long organization);

	Page<Questions> findByOrganization(Long organization, Pageable pageable);
 
	 @Query(value = "SELECT q.* FROM questions q WHERE Question LIKE %:question% AND q.organization= :organization", nativeQuery = true)
	List<Questions> findByQuestionAndOrganization(String question, Long organization);
}
