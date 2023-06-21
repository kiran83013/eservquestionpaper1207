package com.travel.travtronics.repository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceAssignment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceAssignmentRepository extends JpaRepository<ServiceAssignment,Long> {
    List<ServiceAssignment> findByHeaderIdAndStatus(Long headerId, Status active);

	Page<ServiceAssignment> findByOrganizationId(Long organizationId, Pageable pageable);
}
