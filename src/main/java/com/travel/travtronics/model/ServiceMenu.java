package com.travel.travtronics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.travel.travtronics.dto.SanctionConfigDto;
import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "service_menu_type_lines")
public class ServiceMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Organization", nullable = false)
	private Long organization;

	@Column(name = "ServiceMenuType", nullable = false)
	private Long serviceMenuType;

	@Column(name = "ServiceTypeHeader", nullable = false)
	private Long serviceTypeHeader;

	@Column(name = "Description", columnDefinition = "LONGTEXT", nullable = false)
	private String description;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "CreatedBy", updatable = false)
	private Long createdBy;

	@Column(name = "UpdatedBy")
	private Long updatedBy;

	@CreationTimestamp
	@Column(name = "CreatedDate", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UpdatedDate")
	private Date updatedDate;

	@Column(name = "Status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

}
