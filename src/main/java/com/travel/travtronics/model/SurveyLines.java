package com.travel.travtronics.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.travtronics.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "survey_lines")
public class SurveyLines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Question")
    private Long question;

    @Column(name = "Reference")
    private String reference;

    @Column(name = "ReferenceId")
    private Long referenceId;
    
    @Column(name = "OrganizationId")
    private Long organizationId;

    @Column(name = "SurveyHeader")
    private Long surveyHeader;

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
