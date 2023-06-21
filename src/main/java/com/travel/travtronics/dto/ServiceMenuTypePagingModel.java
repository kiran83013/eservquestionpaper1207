package com.travel.travtronics.dto;

import com.travel.travtronics.enums.Status;

public class ServiceMenuTypePagingModel {
    private Long organization;

    private Status status;

    public Long getOrganization() {
        return organization;
    }

    public void setOrganization(Long organization) {
        this.organization = organization;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
