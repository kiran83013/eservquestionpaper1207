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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travtronics.enums.Status;

import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Question")
    private String question;

    @Column(name = "Description")
    private String description;

    @Column(name = "Type")
    @JsonProperty("type")
    private Integer type;

    @Column(name = "Source")
    private String source;

    @Column(name = "Service")
    private String service;

    @Column(name = "Options")
    private String options;

    @Column(name = "Organization")
    private Long organization;

    @Column(name = "Department")
    private Long department;

    @Column(name = "Reference")
    private Long reference;

    @Column(name = "ReferenceType")
    private String referenceType;

    @Column(name = "Language")
    private Long language;

    @Column(name = "CreatedBy", updatable = false)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CreatedDate", updatable = false)
    private Date createdDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "UpdatedDate")
    private Date updatedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private Status status;
}
