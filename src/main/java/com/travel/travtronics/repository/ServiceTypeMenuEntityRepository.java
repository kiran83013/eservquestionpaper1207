package com.travel.travtronics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travel.travtronics.dto.SanctionConfigDto;
import com.travel.travtronics.model.ServiceTypeMenuEntity;

public interface ServiceTypeMenuEntityRepository extends JpaRepository<ServiceTypeMenuEntity, Long> {

	@Query(value = com.travel.travtronics.enums.Query.GET_SERVICE_TYPE_MENU, nativeQuery = true)
	List<ServiceTypeMenuEntity> findByServiceMenuTypeAndOrganization(@Param("menuType") Long serviceMenuTypeId,
			@Param("orgId") Long orgId);

	@Query(nativeQuery = true)
	List<SanctionConfigDto> findAllSanctions(@Param("bizId") Integer bizId, @Param("orgId") Long orgId,
			@Param("isOnline") Boolean isOnline, @Param("isOffline") Boolean isOffline);

}
