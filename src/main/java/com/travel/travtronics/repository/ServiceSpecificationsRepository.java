package com.travel.travtronics.repository;

import com.travel.travtronics.enums.Status;

import com.travel.travtronics.model.ServiceSpecifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceSpecificationsRepository extends JpaRepository<ServiceSpecifications, Long> {
    List<ServiceSpecifications> findByServiceTypeIdAndStatus(Long serviceTypeId, Status active);
}
