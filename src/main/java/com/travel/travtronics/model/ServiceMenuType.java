package com.travel.travtronics.model;

import com.travel.travtronics.enums.Status;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "service_menu_type")
public class ServiceMenuType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Organization", nullable = false)
    private Long organization;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description",columnDefinition = "LONGTEXT", nullable = false)
    private String description;

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

    @Column(name="Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
