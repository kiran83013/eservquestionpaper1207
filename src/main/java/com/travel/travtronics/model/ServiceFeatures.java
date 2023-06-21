package com.travel.travtronics.model;


import com.travel.travtronics.enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "service_features")
public class ServiceFeatures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description",columnDefinition = "LONGTEXT")
    private String description;

    @Column(name = "AttachmentURL")
    private String attachmentURL;

    @Column(name = "ServiceTypeId")
    private Long serviceTypeId;

    @Column(name = "OrganizationId")
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

    @Column(name="Status")
    @Enumerated(EnumType.STRING)
    private Status status;
}
