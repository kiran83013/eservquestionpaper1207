package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.FieldLines;

public interface FieldLinesRepository extends JpaRepository<FieldLines, Long> {

//	Optional<FieldLines> findByPrcId(Long prcId);

	/*
	 * @Query(value
	 * ="SELECT s.Line_Id AS lineId, s.Parent_Sr_Type AS parentSrType, s.Description AS description, s.Organization_Id AS organizationId, s.Prc_Id AS prcId, s.Seq_No AS seqNo,\r\n"
	 * +
	 * "s.Sr_Type AS srType, sth.Name AS srTypeName, s.Stage_Name,s.status AS status, s.WF_Status AS WF_Status, s.Department_Id AS departmentId, s.Created_By AS createdby, \r\n"
	 * +
	 * "s.Created_Date AS createdDate, s.Updated_By AS updatedBy, s.Updated_Date AS updatedDate FROM stages s\r\n"
	 * + "LEFT JOIN service_types_header sth ON sth.ID = s.Sr_Type\r\n" +
	 * "WHERE s.Prc_Id =?1",nativeQuery = true) List<Map<String, String>>
	 * findAllByPrcId(Long prcId);
	 */

	List<FieldLines> findBySrType(Long srTypeId);

	@Query(value = "SELECT s.Line_Id AS lineId, s.Parent_Sr_Type AS parentSrType, s.Description AS description, s.Organization_Id AS organizationId, s.Prc_Id AS prcId, s.Seq_No AS seqNo,\r\n" + 
			"s.Sr_Type AS srType, sth.Name AS srTypeName, s.Stage_Name,s.status AS status, s.WF_Status AS wf_Status, s.Department_Id AS departmentId, s.Created_By AS createdby,\r\n" + 
			"s.Created_Date AS createdDate, s.Updated_By AS updatedBy, s.Updated_Date AS updatedDate FROM stages s \r\n" + 
			"INNER JOIN service_types_header sth ON sth.ID = s.Sr_Type AND s.status = 'Active' \r\n" + 
			"WHERE s.Prc_Id =?1\r\n" + 
			"", nativeQuery = true)
	List<Map<String, String>> findAllByPrcId(Long prcId);

//	List<Map<String, String>> findAllByPrcIdAndSeqNoAndSortType(Long prcId, Long seqNo, SortType sortType);

}
