package com.travel.travtronics.model;

import com.travel.travtronics.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "service_assignment")
public class ServiceAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "HeaderId")
    private Long headerId;
    
    @Column(name = "OrganizationId")
    private Long organizationId;

    @Column(name = "Team")
    private Long team;

    @Column(name = "DefaultStatus")
    private Long defaultStatus;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private Status status;

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

}
