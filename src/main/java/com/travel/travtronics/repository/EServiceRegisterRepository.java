package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.EServiceRegister;

public interface EServiceRegisterRepository extends JpaRepository<EServiceRegister, Long> {

	Optional<EServiceRegister> findById(Long id);
	
	@Query(value = "SELECT esr.ID AS id,esr.ServiceName AS serviceName,esr.ServiceUrl AS serviceUrl, esr.ModuleId AS moduleId,\r\n" + 
			"esr.StartDate AS startDate, esr.EndDate AS endDate, esr.CreatedBy AS createdBy,\r\n" + 
			"esr.CreatedDate AS createdDate, esr.UpdatedBy AS updatedBy, esr.UpdatedDate AS UpdatedDate,\r\n" + 
			"esr.Description AS description, esr.Status AS status,esr.OrganizationId AS organizationId,\r\n" + 
			"m.ModuleName AS moduleName, esr.IsBpf AS isBpf, esr.IsServiceUrl AS isServiceUrl, esr.IsQuartz AS isQuartz,\r\n" + 
			"esr.Output AS output, esr.Template AS template, esr.IsExternalUrl AS isExternalUrl\r\n" + 
			"FROM e_service_register esr\r\n" + 
			"LEFT JOIN e_services.module m ON m.ModuleId = esr.ModuleId WHERE esr.OrganizationId =?1", nativeQuery = true)
	List<Map<String, String>> findByOrganizationId(Long organizationId);

	Page<EServiceRegister> findByOrganizationId(Long organizationId, Pageable pageable);

	@Query(value = "SELECT * FROM e_service_register WHERE ID = ?1 AND Status = 'Active'", nativeQuery = true)
	Optional<EServiceRegister> getServiceRegisterInfoById(String serviceId);

}
