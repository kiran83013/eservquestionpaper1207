package com.travel.travtronics.repository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Faq;
import com.travel.travtronics.model.SurveyLines;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FaqRepository extends JpaRepository<Faq, Long> {
    List<Faq> findAllByReferenceIdAndReferenceAndStatus(Long ReferenceId, String reference, Status active);

	List<Faq> findAllByOrganization(Long organization);

	Page<Faq> findByOrganization(Long organization, Pageable pageable);
}
