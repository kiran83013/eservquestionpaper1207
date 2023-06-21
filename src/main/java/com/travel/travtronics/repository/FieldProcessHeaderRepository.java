package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.FieldProcessHeader;

public interface FieldProcessHeaderRepository extends JpaRepository<FieldProcessHeader, Long> {

//	@Query(value = "",nativeQuery = true)
//	List<Map<String, String>> findByList(Long organizationId);

	@Query(value = "SELECT p.ID AS prcId, p.Type AS type,  p.Category AS category, p.Created_By AS createdby, p.Created_Date AS createdDate, p.Description AS description, p.Organization_Id AS organizationId,\r\n"
			+ "p.Owner AS owner, p.Process_Name AS processName,  p.Sr_Type_Id AS srTypeId, sth.Name AS srTypeName, p.status AS status, p.Team AS team, p.Updated_By AS updatedBy, p.Updated_Date AS updatedDate,\r\n"
			+ "p.WF_Status AS wf_Status, p.Department_Id AS departmentId FROM e_services.process p\r\n"
			+ "LEFT JOIN service_types_header sth ON sth.ID = p.Sr_Type_Id\r\n"
			+ "WHERE p.Organization_Id =?1", nativeQuery = true)
	List<Map<String, String>> findAllByOrganizationId(Long organizationId);

	Page<FieldProcessHeader> findByOrganizationId(Long organizationId, Pageable pageable);

	@Query(value = "SELECT stages.Sr_Type AS stage_sr_type,stages.Stage_Name AS stage_name,\r\n" + 
			"service_types_header.Name AS name,stages.Seq_No seq_no, service_types_header.ServiceTypeIconClass AS serviceTypeIconClass\r\n" + 
			"FROM process \r\n" + 
			"JOIN stages ON process.Sr_Type_Id = stages.Parent_Sr_Type\r\n" + 
			"JOIN service_types_header ON stages.Sr_Type = service_types_header.ID\r\n" + 
			"WHERE Sr_Type_Id = ? AND stages.status='Active'\r\n" + 
			"ORDER BY stages.Seq_No ASC", nativeQuery = true)
	List<Map<String, Object>> getSrStages(Integer srTypeId);

	@Query(value = "SELECT Process_Name process_name,Sr_Type_Id sr_type_id,service_types_header.Name sr_type_name, service_types_header.ServiceTypeIconClass AS serviceTypeIconClass\r\n" + 
			"FROM process\r\n" + 
			"JOIN service_types_header ON process.Sr_Type_Id = service_types_header.ID\r\n" + 
			"WHERE process.Sr_Type_Id=? AND process.status='Active'", nativeQuery = true)
	Map<String, Object> getSrProcessHeader(Integer srTypeId);

	@Query(value = "SELECT p.ID AS prcId, p.Type AS type,  p.Category AS category, p.Created_By AS createdby, p.Created_Date AS createdDate, p.Description AS description, p.Organization_Id AS organizationId,\r\n"
			+ "p.Owner AS owner, p.Process_Name AS processName,  p.Sr_Type_Id AS srTypeId, sth.Name AS srTypeName, p.status AS status, p.Team AS team, p.Updated_By AS updatedBy, p.Updated_Date AS updatedDate,\r\n"
			+ "p.WF_Status AS wf_Status, p.Department_Id AS departmentId FROM e_services.process p\r\n"
			+ "LEFT JOIN service_types_header sth ON sth.ID = p.Sr_Type_Id\r\n" + "WHERE p.ID =?1", nativeQuery = true)
	List<Map<String, String>> findAllById(Long id);
	
	@Query(value = "SELECT sth.name AS NAME FROM service_types_header sth  WHERE sth.ID=?1", nativeQuery = true)
	Optional<String> getSrTypeName(Long srTypeId);

}
