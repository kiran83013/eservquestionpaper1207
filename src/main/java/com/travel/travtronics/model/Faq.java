package com.travel.travtronics.model;

import com.travel.travtronics.enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "faqs")
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Organization")
    private Long organization;

    @Column(name = "Department")
    private Long department;

    @Column(name = "Reference")
    private String reference;

    @Column(name = "ReferenceId")
    private Long referenceId;


    @Column(name = "Question")
    private Long question;

    @Column(name = "Answer")
    private String answer;

    @Column(name = "DeviceId")
    private String deviceId;

    @Column(name = "DeviceType")
    private String deviceType;

    @Column(name = "IpAddress")
    private String ipAddress;

    @Column(name = "Attribute1")
    private String attribute1;

    @Column(name = "Attribute2")
    private String attribute2;

    @Column(name = "Attribute3")
    private String attribute3;


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
