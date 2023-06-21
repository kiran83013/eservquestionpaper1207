package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.MasterSubmode;

public interface MasterSubmodeRepository extends JpaRepository<MasterSubmode, Long>{
	
	@Query(value = "SELECT msm.ID AS id, msm.Name AS NAME, msm.Code AS code, msm.Description AS description,msm.CreatedBy AS createdBy, msm.CreatedDate AS createdDate, msm.UpdatedBy AS updatedBy,\r\n" + 
			"msm.UpdatedDate AS updatedDate, msm.Status AS status, msm.ModeID AS modeId,mop.name AS modeName,msm.OrganizationId AS organizationId,mo.Name AS organizationName  FROM master_submode msm\r\n" + 
			"LEFT JOIN master_mop mop ON mop.ID = msm.ID\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = msm.OrganizationId\r\n" + 
			"WHERE msm.OrganizationId=?1",nativeQuery = true)
	List<Map<String, String>> findByList(Long organizationId);

	Page<MasterSubmode> findByOrganizationId(Long organizationId, Pageable pageable);

}
