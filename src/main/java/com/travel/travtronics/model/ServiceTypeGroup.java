package com.travel.travtronics.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "service_type_group")
public class ServiceTypeGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Description", nullable = false, columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "Department")
	private Long department;

	@Column(name = "OrganizationId", nullable = false)
	private Long organizationId;

	@Column(name = "CreatedBy", updatable = false)
	private String createdBy;

	@Column(name = "UpdatedBy")
	private String updatedBy;

	@CreationTimestamp
	@Column(name = "CreatedDate", updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "UpdatedDate")
	private Date updatedDate;

	@Column(name = "Status")
	@Enumerated(EnumType.STRING)
	private Status status;
}
