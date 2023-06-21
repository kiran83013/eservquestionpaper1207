package com.travel.travtronics.model;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.springframework.data.annotation.Immutable;

import com.travel.travtronics.dto.SanctionConfigDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Immutable
@Getter
@Setter
@NamedNativeQuery(name = "ServiceTypeMenuEntity.findAllSanctions", query = com.travel.travtronics.enums.Query.GET_SANCTION_INFO, resultSetMapping = "findAllSanctions")
@SqlResultSetMapping(name = "findAllSanctions", classes = @ConstructorResult(targetClass = SanctionConfigDto.class, columns = {
		@ColumnResult(name = "sanction_id", type = Integer.class),@ColumnResult(name = "sanction_name", type = String.class),
		@ColumnResult(name = "sanction_type_id", type = Integer.class),@ColumnResult(name = "sanction_type_name", type = String.class),
		@ColumnResult(name = "sr_type_id", type = String.class),@ColumnResult(name = "description", type = String.class),
		@ColumnResult(name = "sanction_image", type = String.class) }))
public class ServiceTypeMenuEntity {

	@Id
	@Column(name = "id", insertable = false, updatable = false)
	private Long id;

	@Column(name = "department_id", insertable = false, updatable = false)
	private Long departmentId;

	@Column(name = "department_name", insertable = false, updatable = false)
	private String departmentName;

	@Column(name = "service_type_id", insertable = false, updatable = false)
	private Long serviceTypeId;

	@Column(name = "service_type_name", insertable = false, updatable = false)
	private String serviceTypeName;

	@Column(name = "service_type_url", insertable = false, updatable = false)
	private String serviceTypeUrl;

	@Column(name = "is_service_dynamic", insertable = false, updatable = false)
	private Long isServiceDynamic;

	@Column(name = "service_type_class", insertable = false, updatable = false)
	private Long serviceTypeClass;

	@Column(name = "is_process", insertable = false, updatable = false)
	private Boolean isProcess;
	@Column(name = "is_parent", insertable = false, updatable = false)
	private Boolean isParent;

}
