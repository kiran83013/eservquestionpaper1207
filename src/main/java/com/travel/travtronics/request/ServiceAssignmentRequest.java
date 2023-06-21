package com.travel.travtronics.request;

import com.travel.travtronics.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class ServiceAssignmentRequest {

    private Long id;


    private Long team;

    private Long defaultStatus;

    private Long organizationId;

    private Long headerId;


    private Date startDate;


    private Date endDate;


    private String createdBy;


    private String updatedBy;


    private Status status;

}
