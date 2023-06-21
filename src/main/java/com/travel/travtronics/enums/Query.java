package com.travel.travtronics.enums;

public class Query {

	public static final String INSERT_QUERY = "insert into  %s(name,code,description,created_by,created_date,updated_by,updated_date,status) "
			+ "values(:name,:code,:description,:created_by,:created_date,:updated_by,:updated_date,:status)";

	public static final String GET_BY_ID = "SELECT * FROM %s where ID=:ID";

	public static final String GET_ALL = "SELECT * FROM  %s";

	public static final String UPDATE_BY_ID = "update %s set name = :name, code = :code, description =:description , "
			+ "updated_by =:updated_by,updated_date=:updated_date ,status=:status where ID = :ID";

	public static final String CREATE_TABLE_SCHEMA = "CREATE TABLE IF NOT EXISTS %s(\r\n"
			+ "	  `ID` INT(11) NOT NULL AUTO_INCREMENT,\r\n" + "	  `name` VARCHAR(255) DEFAULT NULL,\r\n"
			+ "	  `code` VARCHAR(255) DEFAULT NULL,\r\n" + "	  `description` TEXT DEFAULT NULL,\r\n"
			+ "	  `created_by` INT(11) DEFAULT NULL,\r\n" + "	  `created_date` TIMESTAMP NULL DEFAULT NULL,\r\n"
			+ "	  `updated_by` INT(11) DEFAULT NULL,\r\n"
			+ "	  `updated_date` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(),\r\n"
			+ "	  `status` BIT(1) DEFAULT b'1',\r\n" + "	  PRIMARY KEY (`ID`)\r\n" + "	) ENGINE=INNODB";

	public static final String GET_BY_NAME = "select ID,name,code,description,created_by,created_date,updated_by,updated_date,status from {0} where name like {1} OR code like {1}";

	public static final String BASE_NEW_LANG_MASTER_FEILDS_COUNT = "SELECT \r\n" + "COUNT(*) AS count_info\r\n"
			+ "FROM \r\n" + "master_general_setup\r\n"
			+ "LEFT JOIN field_language_general_setup_master ON field_language_general_setup_master.general_master_setup_id=master_general_setup.id\r\n"
			+ "AND lang_id=?1 AND field_language_general_setup_master.org_id=?2\r\n"
			+ "WHERE 1=1 AND master_general_setup.org_id=?2";

	public static final String BASE_GET_LANG_MASTER_FEILDS_QUERY = "SELECT \r\n"
			+ "master_general_setup.id master_id,master_general_setup.name actual_name,\r\n"
			+ "master_general_setup.code  AS actual_code,\r\n"
			+ "master_general_setup.description AS actual_description,\r\n"
			+ "field_language_general_setup_master.lang_name,\r\n"
			+ "field_language_general_setup_master.name master_name,\r\n"
			+ "field_language_general_setup_master.code master_code,\r\n"
			+ "field_language_general_setup_master.description master_description,\r\n"
			+ "field_language_general_setup_master.created_by,\r\n"
			+ "field_language_general_setup_master.created_date,\r\n"
			+ "field_language_general_setup_master.updated_by,\r\n"
			+ "field_language_general_setup_master.updated_date,field_language_general_setup_master.id,\r\n"
			+ "field_language_general_setup_master.header_id,master_general_setup.category_id\r\n"
			+ "FROM  master_general_setup\r\n"
			+ "LEFT JOIN field_language_general_setup_master ON field_language_general_setup_master.general_master_setup_id=master_general_setup.id\r\n"
			+ "AND lang_id=?1 AND field_language_general_setup_master.org_id=?2\r\n"
			+ "WHERE 1=1 AND master_general_setup.org_id=?2";
	public static final String GET_NEW_LANG_MASTER_FEILDS = BASE_GET_LANG_MASTER_FEILDS_QUERY + "\r\n"
			+ "AND field_language_general_setup_master.lang_name IS NULL";
	public static final String GET_NEW_LANG_MASTER_FEILDS_COUNT = BASE_NEW_LANG_MASTER_FEILDS_COUNT + "\r\n"
			+ "AND field_language_general_setup_master.lang_name IS NULL";

	public static final String GET_NON_NEW_LANG_MASTER_FEILDS = BASE_GET_LANG_MASTER_FEILDS_QUERY + "\r\n"
			+ "AND field_language_general_setup_master.lang_name IS NOT NULL";
	public static final String GET_NON_NEW_LANG_MASTER_FEILDS_COUNT = BASE_NEW_LANG_MASTER_FEILDS_COUNT + "\r\n"
			+ "AND field_language_general_setup_master.lang_name IS NOT NULL";
	public static final String GET_SANCTION_INFO = "SELECT config.id AS sanction_id,config.name sanction_name, config.type sanction_type_id, \r\n"
			+ "st.name sanction_type_name,GROUP_CONCAT(sst.sr_type) sr_type_id,config.description,config.sanction_image \r\n"
			+ "FROM e_services.sanction_config config \r\n"
			+ "JOIN e_services.master_general_setup st ON st.id=config.type \r\n"
			+ "JOIN e_services.sanction_group sg ON sg.id=config.sanction_group \r\n"
			+ "JOIN e_services.sanction_group_sr_types sst ON sst.sanction_group=sg.id \r\n"
			+ "JOIN e_services.sanction_party_relation rel ON rel.sanctionid=config.id \r\n" + "WHERE 1 = 1 \r\n"
			+ "AND rel.bizid = :bizId \r\n" + "AND rel.orgid = :orgId \r\n"
			+ "AND ((sst.is_online = TRUE AND :isOnline = true) OR (sst.is_offline = TRUE AND :isOffline = true)) \r\n"
			+ "GROUP BY config.id, config.name, config.type, st.name, config.description, config.sanction_image";

	public static final String GET_SERVICE_TYPE_MENU = "SELECT\r\n" + " menu.Id id,\r\n"
			+ "-- (json_object('departmentId',dept.DepartmentId,'departmentName',dept.Name)) as dept_details,\r\n"
			+ "dept.DepartmentId department_id,\r\n" + "dept.Name department_name,\r\n"
			+ "sr_type_header.ID service_type_id,\r\n" + "sr_type_header.Name service_type_name,\r\n"
			+ "sr_type_header.IsDynamicForm is_service_dynamic,\r\n"
			+ "sr_type_header.ServiceClass service_type_class,\r\n" + "sr_type_header.IsProcess is_process,\r\n"
			+ "sr_type_header.IsParent is_parent,\r\n" + "sr_type_header.FormUrl service_type_url\r\n" + "FROM \r\n"
			+ "e_services.service_menu_type_lines menu\r\n"
			+ "JOIN e_services.service_types_header sr_type_header ON sr_type_header.ID=menu.ServiceTypeHeader\r\n"
			+ "JOIN e_services.master_departments dept ON dept.DepartmentId=sr_type_header.DepartmentId\r\n"
			+ "WHERE\r\n" + "menu.ServiceMenuType= :menuType AND\r\n" + "menu.Organization= :orgId\r\n" + "AND\r\n"
			+ "menu.Status='Active'";

	public static final String GET_SERVICE_TYPE_INFO_DETAILS = "SELECT\n" + 
			"service_type.ID,\n" + 
			"service_type.`CreatedBy`,\n" + 
			"service_type.`CreatedDate`,\n" + 
			"service_type.`UpdatedBy`,\n" + 
			"service_type.`UpdatedDate`,\n" + 
			"service_type.`OrganizationId`,\n" + 
			"service_type.`DepartmentId`,\n" + 
			"service_type.`ServiceTypeGroup`,\n" + 
			"service_type.`Name`,service_type.`DesktopEnabled`,service_type.`MobileEnabled`,\n" + 
			"service_type.`IsDynamicForm`,service_type.`FormUrl`,service_type.`Status`,service_type.`Description`,service_type.`PreValidations`,\n" + 
			"service_type.`Instructions`,service_type.`IsProcess`,service_type.`IsParent`,service_type.`ServiceClass`,service_type.`ServiceCategory`,\n" + 
			"service_type.`ServiceType`,service_type.`is_stage`,service_type.`stages`,service_type.`ServiceTypeIconClass`,service_type.`Is_Pricing`,\n" + 
			"service_type.`Receipt_Confirm_Template`,\n" + 
			"(JSON_OBJECT('id',master_setup.id,'name',master_setup.`name`,'code',master_setup.`code`)) AS service_type_details\n" + 
			"FROM \n" + 
			"`e_services`.`service_types_header` service_type\n" + 
			"LEFT JOIN `master_general_setup` master_setup ON master_setup.`id`=service_type.`ServiceType`\n" + 
			"WHERE\n" + 
			"service_type.`ID`=?1";

}
