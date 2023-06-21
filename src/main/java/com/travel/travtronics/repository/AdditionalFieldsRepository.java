package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.AdditionalFields;

public interface AdditionalFieldsRepository extends JpaRepository<AdditionalFields, Long>{

	List<AdditionalFields> findAllByHeaderIdAndStatusAndIsPricing(Long id, Status active, Long isPricing);

	List<AdditionalFields> findAllByHeaderIdAndStatus(Long headerId, Status active);

	List<AdditionalFields> findAllByHeaderIdAndTransitionIdAndStatus(Long headerId, Long transitionId, Status active);

//	Collection<AdditionalFieldsRequest> findAllByHeaderIdAndTransitionIdAndStatus(Long headerId, Long transitionId,
//			Status active);


}
