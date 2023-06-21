package com.travel.travtronics.model;

import com.travel.travtronics.enums.Status;
import lombok.Data;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "survey_header")
public class SurveyHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Organization")
    private Long organization;

    @Column(name = "Department")
    private Long department;

    @Column(name = "ReferenceName")
    private String referenceName;

    @Column(name = "ReferenceId")
    private Long referenceId;

//    @OneToMany(mappedBy = "surveyHeader", cascade = CascadeType.ALL)
//   // private Set<SurveyLines> surveyLines = new HashSet<>();
//    private List<SurveyLines> SurveyLines;

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
