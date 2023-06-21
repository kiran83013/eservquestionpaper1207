package com.travel.travtronics.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travel.travtronics.dto.ServiceTypeHeaderResponse;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceTypesHeader;

public interface ServiceTypesRepository extends JpaRepository<ServiceTypesHeader, Long> {

	@Query(value = "SELECT st.ID AS id, st.CreatedBy AS createdBy, st.CreatedDate AS createdDate, \r\n"
			+ "st.UpdatedBy AS updatedBy, st.UpdatedDate AS updatedDate, \r\n"
			+ "st.DepartmentId AS departmentId, st.Description AS description,\r\n"
			+ "st.Status AS status, st.name, md.Name AS departmentName,\r\n"
			+ "st.OrganizationId AS organizationId, mo.name AS organizationName,\r\n"
			+ "st.ParentId AS parentId, mp.name AS parentName, st.Is_Pricing AS isPricing, st.Receipt_Confirm_Template AS receiptConfirmTemplate\r\n"
			+ "FROM service_types_header st\r\n"
			+ "LEFT JOIN master_departments md ON md.DepartmentId= st.DepartmentId\r\n"
			+ "LEFT JOIN master_organization mo ON mo.OrganizationId = st.OrganizationId\r\n"
			+ "LEFT JOIN master_parent mp ON mp.ID= st.ParentId\r\n"
			+ "WHERE st.Status='Active' AND st.organizationId = ?1", nativeQuery = true)
	List<Map<String, String>> findAllByList(String organizationId);

	Optional<ServiceTypesHeader> findById(Long id);

	@Query(nativeQuery = true)
	Optional<ServiceTypeHeaderResponse> findByServiceTypeId(Long id);

	@Query("select sh from ServiceTypesHeader sh  where sh.departmentId= :departmentId and sh.status='Active'")
	List<ServiceTypesHeader> getServiceHeaderByDeptId(@Param("departmentId") String departmentId);

	List<ServiceTypesHeader> findByOrganizationIdAndDepartmentIdAndStatus(String organizationId, String departmentId,
			Status status);

	@Query(value = "SELECT sth.ID,sth.Name,sth.DepartmentId,md.Name AS DepartmentName\r\n"
			+ "FROM service_types_header sth\r\n"
			+ "LEFT JOIN master_departments md ON md.DepartmentId = sth.DepartmentId\r\n" + "WHERE\r\n"
			+ "sth.OrganizationId = ?\r\n" + "AND\r\n" + "sth.DepartmentId = ?\r\n" + "AND\r\n"
			+ "sth.IsProcess = 1\r\n" + "AND\r\n" + "sth.IsParent = ?", nativeQuery = true)
	List<Map<String, String>> findByHeaderRelation(String organizationId, String departmentId, Boolean isParent);

	@Query("select sh from ServiceTypesHeader sh  where sh.isProcess= false or (sh.isProcess=true and sh.isParent=true) and sh.organizationId=?1 and sh.status='Active'")
	List<ServiceTypesHeader> getServiceTypeForMenu(String organizationId);

	@Query(value = "SELECT sth.Id AS id,\r\n" + "sth.CreatedBy AS createdBy,\r\n"
			+ "sth.CreatedDate AS createdDate,\r\n" + "sth.DepartmentId AS departmentId,\r\n"
			+ "md.Name AS departmentName,\r\n" + "sth.Description AS description,\r\n" + "sth.Name AS name,\r\n"
			+ "sth.OrganizationId AS organizationId,\r\n" + "mo.Name AS organizationName,\r\n"
			+ "sth.ParentId AS parentId,\r\n" + "mp.name AS ParentName,\r\n" + "sth.Status AS status,\r\n"
			+ "sth.UpdatedBy AS updatedBy,\r\n" + "sth.UpdatedDate AS updatedDate,\r\n"
			+ "sth.Instructions AS instructions,\r\n" + "sth.PreValidations AS preValidations,\r\n"
			+ "sth.DesktopEnabled AS desktopEnabled,\r\n" + "sth.FormUrl AS formUrl,\r\n"
			+ "sth.IsDynamicForm AS isDynamicForm,\r\n" + "sth.MobileEnabled AS mobileEnabled,\r\n"
			+ "sth.ServiceTypeGroup AS serviceTypeGroup,\r\n" + "stg.Name AS serviceTypeGroupName,\r\n"
			+ "sth.IsProcess AS isProcess,\r\n" + "sth.IsParent AS isParent,\r\n"
			+ "sth.ServiceCategory AS serviceCategory,\r\n" + "sth.ServiceClass AS serviceClass,\r\n"
			+ "sth.ServiceType AS serviceType,\r\n" + "sth.is_stage AS isStage,\r\n" + "sth.stages AS stages,\r\n"
			+ "sth.ServiceTypeIconClass AS serviceTypeIconClass\r\n" + "FROM service_types_header AS sth\r\n"
			+ "LEFT JOIN master_departments AS md ON md.DepartmentId = sth.DepartmentId\r\n"
			+ "LEFT JOIN master_organization AS mo ON mo.OrganizationId = sth.OrganizationId\r\n"
			+ "LEFT JOIN master_parent AS mp ON mp.ID = sth.ParentId\r\n"
			+ "LEFT JOIN service_type_group AS stg ON stg.Id = sth.ServiceTypeGroup\r\n" + "WHERE\r\n"
			+ "sth.DepartmentId = ?2\r\n" + "AND\r\n" + "sth.OrganizationId = ?1\r\n" + "AND\r\n"
			+ "sth.ServiceTypeGroup = ?3\r\n" + "AND\r\n" + "sth.Status = \"Active\"", nativeQuery = true)
	List<Map<String, String>> findByOrganizationIdAndDepartmentIdAndServiceTypeGroup(String organizationId,
			String departmentId, String serviceTypeGroup);

//	@Query(value = "SELECT sth.Id AS id,\r\n" + "sth.CreatedBy AS createdBy,\r\n"
//			+ "sth.CreatedDate AS createdDate,\r\n" + "sth.DepartmentId AS departmentId,\r\n"
//			+ "md.Name AS departmentName,\r\n" + "sth.Description AS description,\r\n" + "sth.Name AS name,\r\n"
//			+ "sth.OrganizationId AS organizationId,\r\n" + "mo.Name AS organizationName,\r\n"
//			+ "sth.ParentId AS parentId,\r\n" + "mp.name AS ParentName,\r\n" + "sth.Status AS status,\r\n"
//			+ "sth.UpdatedBy AS updatedBy,\r\n" + "sth.UpdatedDate AS updatedDate,\r\n"
//			+ "sth.Instructions AS instructions,\r\n" + "sth.PreValidations AS preValidations,\r\n"
//			+ "sth.DesktopEnabled AS desktopEnabled,\r\n" + "sth.FormUrl AS formUrl,\r\n"
//			+ "sth.IsDynamicForm AS isDynamicForm,\r\n" + "sth.MobileEnabled AS mobileEnabled,\r\n"
//			+ "sth.ServiceTypeGroup AS serviceTypeGroup,\r\n" + "stg.Name AS serviceTypeGroupName,\r\n"
//			+ "sth.IsProcess AS isProcess,\r\n" + "sth.IsParent AS isParent,\r\n"
//			+ "sth.ServiceCategory AS serviceCategory,\r\n" + "sth.ServiceClass AS serviceClass,\r\n"
//			+ "sth.ServiceType AS serviceType,\r\n" + "sth.is_stage AS isStage,\r\n" + "sth.stages AS stages,\r\n"
//			+ "sth.ServiceTypeIconClass AS serviceTypeIconClass\r\n" + "FROM service_types_header AS sth\r\n"
//			+ "LEFT JOIN master_departments AS md ON md.DepartmentId = sth.DepartmentId\r\n"
//			+ "LEFT JOIN master_organization AS mo ON mo.OrganizationId = sth.OrganizationId\r\n"
//			+ "LEFT JOIN master_parent AS mp ON mp.ID = sth.ParentId\r\n"
//			+ "LEFT JOIN service_type_group AS stg ON stg.Id = sth.ServiceTypeGroup\r\n" + "WHERE\r\n"
//			+ "sth.OrganizationId = ?1\r\n" + "AND\r\n" + "sth.Status = \"Active\"", nativeQuery = true)
	List<ServiceTypesHeader> findByOrganizationId(String organizationId);

//	@Query(value = "SELECT sth.Id AS id,\r\n" + "sth.CreatedBy AS createdBy,\r\n"
//			+ "sth.CreatedDate AS createdDate,\r\n" + "sth.DepartmentId AS departmentId,\r\n"
//			+ "md.Name AS departmentName,\r\n" + "sth.Description AS description,\r\n" + "sth.Name AS name,\r\n"
//			+ "sth.OrganizationId AS organizationId,\r\n" + "mo.Name AS organizationName,\r\n"
//			+ "sth.ParentId AS parentId,\r\n" + "mp.name AS ParentName,\r\n" + "sth.Status AS status,\r\n"
//			+ "sth.UpdatedBy AS updatedBy,\r\n" + "sth.UpdatedDate AS updatedDate,\r\n"
//			+ "sth.Instructions AS instructions,\r\n" + "sth.PreValidations AS preValidations,\r\n"
//			+ "sth.DesktopEnabled AS desktopEnabled,\r\n" + "sth.FormUrl AS formUrl,\r\n"
//			+ "sth.IsDynamicForm AS isDynamicForm,\r\n" + "sth.MobileEnabled AS mobileEnabled,\r\n"
//			+ "sth.ServiceTypeGroup AS serviceTypeGroup,\r\n" + "stg.Name AS serviceTypeGroupName,\r\n"
//			+ "sth.IsProcess AS isProcess,\r\n" + "sth.IsParent AS isParent,\r\n"
//			+ "sth.ServiceCategory AS serviceCategory,\r\n" + "sth.ServiceClass AS serviceClass,\r\n"
//			+ "sth.ServiceType AS serviceType,\r\n" + "sth.is_stage AS isStage,\r\n" + "sth.stages AS stages,\r\n"
//			+ "sth.ServiceTypeIconClass AS serviceTypeIconClass\r\n" + "FROM service_types_header AS sth\r\n"
//			+ "LEFT JOIN master_departments AS md ON md.DepartmentId = sth.DepartmentId\r\n"
//			+ "LEFT JOIN master_organization AS mo ON mo.OrganizationId = sth.OrganizationId\r\n"
//			+ "LEFT JOIN master_parent AS mp ON mp.ID = sth.ParentId\r\n"
//			+ "LEFT JOIN service_type_group AS stg ON stg.Id = sth.ServiceTypeGroup\r\n" + "WHERE\r\n"
//			+ "sth.DepartmentId = ?2\r\n" + "AND\r\n" + "sth.OrganizationId = ?1\r\n" + "AND\r\n"
//			+ "sth.Status = \"Active\"", nativeQuery = true)

	@Query(value = "SELECT sth.Id AS id,\r\n" + "sth.CreatedBy AS createdBy,\r\n"
			+ "sth.CreatedDate AS createdDate,\r\n" + "sth.DepartmentId AS departmentId,\r\n"
			+ "md.Name AS departmentName,\r\n" + "sth.Description AS description,\r\n" + "sth.Name AS name,\r\n"
			+ "sth.OrganizationId AS organizationId,\r\n" + "mo.Name AS organizationName,\r\n"
			+ "sth.ParentId AS parentId,\r\n" + "mp.name AS ParentName,\r\n" + "sth.Status AS status,\r\n"
			+ "sth.UpdatedBy AS updatedBy,\r\n" + "sth.UpdatedDate AS updatedDate,\r\n"
			+ "sth.Instructions AS instructions,\r\n" + "sth.PreValidations AS preValidations,\r\n"
			+ "sth.DesktopEnabled AS desktopEnabled,\r\n" + "sth.FormUrl AS formUrl,\r\n"
			+ "sth.IsDynamicForm AS isDynamicForm,\r\n" + "sth.MobileEnabled AS mobileEnabled,\r\n"
			+ "sth.ServiceTypeGroup AS serviceTypeGroup,\r\n" + "stg.Name AS serviceTypeGroupName,\r\n"
			+ "sth.IsProcess AS isProcess,\r\n" + "sth.IsParent AS isParent,\r\n"
			+ "sth.ServiceCategory AS serviceCategory,\r\n" + "sth.ServiceClass AS serviceClass,\r\n"
			+ "sth.ServiceType AS serviceType,\r\n" + "sth.is_stage AS isStage,\r\n" + "sth.stages AS stages,\r\n"
			+ "sth.ServiceTypeIconClass AS serviceTypeIconClass\r\n" + "FROM service_types_header AS sth\r\n"
			+ "LEFT JOIN master_departments AS md ON md.DepartmentId = sth.DepartmentId\r\n"
			+ "LEFT JOIN master_organization AS mo ON mo.OrganizationId = sth.OrganizationId\r\n"
			+ "LEFT JOIN master_parent AS mp ON mp.ID = sth.ParentId\r\n"
			+ "LEFT JOIN service_type_group AS stg ON stg.Id = sth.ServiceTypeGroup\r\n" + "WHERE\r\n"
			+ "sth.OrganizationId = ?1\r\n" + "AND\r\n" + "sth.ServiceTypeGroup = ?2\r\n" + "AND\r\n"
			+ "sth.Status = \"Active\"", nativeQuery = true)
	List<Map<String, String>> findByOrganizationIdAndServiceTypeGroup(String organizationId, String serviceTypeGroup);

	@Query(value = "SELECT\r\n" + "* \r\n" + "FROM \r\n" + "`e_services`.`service_types_header`\r\n"
			+ "WHERE `ServiceClass`=5 AND `Status`='Active'", nativeQuery = true)
	List<ServiceTypesHeader> findByServiceTypeIconClass();

	List<ServiceTypesHeader> findByOrganizationIdAndDepartmentIdIn(String organizationId, List<String> departmentId);

	@Query(value = "SELECT esr.ServiceUrl AS serviceUrl FROM  e_service_register esr WHERE esr.ID =:service", nativeQuery = true)
	Optional<String> findByServiceUrl(@Param("service") String string);

	@Query(value = "SELECT esr.IsExternalUrl AS isExternalUrl FROM  e_service_register esr WHERE esr.ID =:service", nativeQuery = true)
	Optional<Boolean> findByIsExternalUrl(@Param("service") String service);

	@Query(value = "SELECT sth.ID AS id, sth.Name AS name, sth.Description AS description, GROUP_CONCAT(sd.URL) AS urls\r\n"
			+ "FROM e_services.service_types_header AS sth\r\n"
			+ "LEFT JOIN e_services.service_documents AS sd ON sd.HeaderId = sth.ID\r\n"
			+ "WHERE sth.ServiceClass = 1 AND sth.Status = 'Active'\r\n"
			+ "GROUP BY sth.ID, sth.Name, sth.Description", nativeQuery = true)
	List<Map<String, Object>> findAllProducts();

	@Query(value = "SELECT sth.ID AS id, sth.Name AS name, sth.Description AS description, GROUP_CONCAT(sd.URL) AS urls, mo.Name AS organizationName, sth.ServiceType AS serviceTypeId, mgs.name AS serviceTypeName, mgs.code AS serviceTypeCode\r\n"
			+ "FROM e_services.service_types_header AS sth\r\n"
			+ "LEFT JOIN e_services.service_documents AS sd ON sd.HeaderId = sth.ID\r\n"
			+ "LEFT JOIN e_services.master_organization AS mo ON mo.OrganizationId = sth.OrganizationId\r\n"
			+ "LEFT JOIN e_services.master_general_setup AS mgs ON mgs.id = sth.ServiceType\r\n"
			+ "WHERE sth.ServiceClass = 1 AND sth.Status = 'Active' AND sth.OrganizationId = 1\r\n"
			+ "GROUP BY sth.ID, sth.Name, sth.Description", nativeQuery = true)
	List<Map<String, Object>> findByOrgId(Long organizationId);

	@Query(value = "SELECT dept.Name AS DepartmentName FROM master_departments dept WHERE dept.DepartmentId =?1", nativeQuery = true)
	Optional<String> getDepartmentName(String departmentId);
    
	@Query(value = "SELECT msc.name AS ClassName FROM `master_service_class` msc WHERE msc.ID = ?1", nativeQuery = true)
	Optional<String> getClassName(Long serviceClass);

	@Query(value = "SELECT mgs.name AS typeName FROM master_general_setup mgs WHERE mgs.id = ?1", nativeQuery = true)
	Optional<String> getTypeName(Long serviceType);
	
	
}
