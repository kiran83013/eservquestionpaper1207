package com.travel.travtronics.response;

import lombok.Data;

import java.util.List;

@Data
public class MenuItemsResponse {
    private Long departmentId;
    private String departmentName;
    private List<MenuOfServiceResponse> services;
}
