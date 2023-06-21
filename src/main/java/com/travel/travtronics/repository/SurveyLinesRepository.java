package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.SurveyLines;

public interface SurveyLinesRepository extends JpaRepository<SurveyLines, Long> {

	List<SurveyLines> findAllByReferenceIdAndReferenceAndStatus(Long ReferenceId, String reference, Status active);

	List<SurveyLines> findByOrganizationId(Long organizationId);

	Page<SurveyLines> findByOrganizationId(Long organizationId, Pageable pageable);
}
