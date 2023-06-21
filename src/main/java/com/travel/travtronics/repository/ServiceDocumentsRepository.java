package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceDocuments;

public interface ServiceDocumentsRepository extends JpaRepository<ServiceDocuments, Long>{

//	List<ServiceDocuments> findByHeaderId(Long headerId);

	List<ServiceDocuments> findByHeaderIdAndStatus(Long headerId, Status active);

	Page<ServiceDocuments> findByOrganizationId(Long organizationId, Pageable pageable);

}
