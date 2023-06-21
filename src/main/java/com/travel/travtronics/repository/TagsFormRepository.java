package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.travel.travtronics.model.TagsForm;

public interface TagsFormRepository extends JpaRepository<TagsForm, Long>{
	
	@Query(value = "SELECT t.tag_id AS tagId, t.tag_name AS tagName, t.tag_description AS description, t.status AS status, t.categoryId AS categoryId, t.typeId AS typeId,t.organizationId AS organizationId,mo.Name AS organizationName,\r\n" + 
			"t.created_by AS createdby, t.created_date AS createdDate, t.updated_by AS updatedBy, t.updated_date AS updatedDate,mtc.name AS categoryName, mtt.name AS typeName FROM tags t\r\n" + 
			"LEFT JOIN master_tags_ctgy mtc ON mtc.ID = t.categoryId\r\n" + 
			"LEFT JOIN master_tags_type mtt ON mtt.ID = t.typeId\r\n" + 
			"LEFT JOIN master_organization mo ON mo.OrganizationId = t.OrganizationId\r\n" + 
			"WHERE t.OrganizationId =?1",nativeQuery = true)
	List<Map<String, String>> findByList(Long organizationId);

	Page<TagsForm> findByOrganizationId(Long organizationId, Pageable pageable);

}
