package com.travel.travtronics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.travel.travtronics.model.CommunicationModuleLink;

public interface CommunicationModuleRepository
		extends JpaRepository<CommunicationModuleLink, Integer>, JpaSpecificationExecutor<CommunicationModuleLink> {

}
