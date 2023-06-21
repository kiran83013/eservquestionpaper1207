package com.travel.travtronics.repository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceTypeGroup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceTypeGroupRepository extends JpaRepository<ServiceTypeGroup, Long> {
    List<ServiceTypeGroup> findByDepartmentAndStatus(Long department, Status status);

	List<ServiceTypeGroup> findAllByOrganizationId(Long organizationId);

	Page<ServiceTypeGroup> findByOrganizationId(Long organizationId, Pageable pageable);
}
