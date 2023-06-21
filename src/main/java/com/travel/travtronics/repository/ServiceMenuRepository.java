package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceMenu;

public interface ServiceMenuRepository extends JpaRepository<ServiceMenu, Long> {

	List<ServiceMenu> findByServiceMenuTypeAndStatus(Long serviceMenuType, Status status);

	List<ServiceMenu> findByServiceMenuTypeAndOrganizationAndStatus(Long serviceMenuType, Long organization,
			Status status);

//    Page<ServiceMenu> findByNameContaining(String name, Pageable pageable);
	Page<ServiceMenu> findByOrganization(Long organization, Pageable pageable);

}
