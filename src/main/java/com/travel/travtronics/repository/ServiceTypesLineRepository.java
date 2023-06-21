package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceTypeLines;

public interface ServiceTypesLineRepository extends JpaRepository<ServiceTypeLines, Long> {

	List<ServiceTypeLines> findAllByHeaderIdAndStatus(Long id, Status active);

	List<ServiceTypeLines> findAllByHeaderIdAndStatusAndIsPricing(Long id, Status active, Long isPricing);

}
