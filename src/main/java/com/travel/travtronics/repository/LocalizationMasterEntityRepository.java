package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.travtronics.model.LocalizationMasterEntity;

public interface LocalizationMasterEntityRepository extends JpaRepository<LocalizationMasterEntity, Integer> {

	List<LocalizationMasterEntity> getNewLangMasterFeilds(Integer langId, Integer orgId);

	Page<LocalizationMasterEntity> getNewLangMasterFeilds(Integer langId, Integer orgId, Pageable page);

	Page<LocalizationMasterEntity> getALLangMasterFeilds(Integer langId, Integer orgId, Pageable page);

	Page<LocalizationMasterEntity> getNonNewangMasterFeilds(Integer langId, Integer orgId, Pageable page);

}
