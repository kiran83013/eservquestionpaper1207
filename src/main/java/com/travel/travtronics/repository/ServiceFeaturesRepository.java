package com.travel.travtronics.repository;


import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceFeatures;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceFeaturesRepository extends JpaRepository<ServiceFeatures, Long> {
    List<ServiceFeatures> findByServiceTypeIdAndStatus(Long serviceTypeId, Status active);
}
