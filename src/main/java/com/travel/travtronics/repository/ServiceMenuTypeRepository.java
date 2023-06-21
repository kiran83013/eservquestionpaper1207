package com.travel.travtronics.repository;


import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceMenuType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceMenuTypeRepository extends JpaRepository<ServiceMenuType, Long> {
    List<ServiceMenuType> findByOrganizationAndStatus(Long organization, Status status);

    Page<ServiceMenuType> findByNameContaining(String name, Pageable pageable);

	Page<ServiceMenuType> findByOrganization(Long organization, Pageable pageable);

	Page<ServiceMenuType> findByOrganizationAndNameContaining(Long organization, String name, Pageable pageable);
}
