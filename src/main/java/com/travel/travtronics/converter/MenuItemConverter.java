package com.travel.travtronics.converter;

import com.travel.travtronics.model.Departments;
import com.travel.travtronics.model.ServiceTypesHeader;
import com.travel.travtronics.response.MenuItemsResponse;
import com.travel.travtronics.response.MenuOfServiceResponse;

import java.util.ArrayList;
import java.util.List;

public class MenuItemConverter {
    public static MenuItemsResponse departmentAndServiceTypesConverter(Departments department, List<ServiceTypesHeader> serviceTypes) {
        MenuItemsResponse menuItem = new MenuItemsResponse();
        menuItem.setDepartmentId(department.getDepartmentId());
        menuItem.setDepartmentName(department.getName());
        List<MenuOfServiceResponse> services = new ArrayList<>();
        for (ServiceTypesHeader serviceType: serviceTypes) {
            MenuOfServiceResponse serviceItem = new MenuOfServiceResponse();
            serviceItem.setServiceTypeId(serviceType.getId());
            serviceItem.setServiceTypeName(serviceType.getName());
            serviceItem.setServiceTypeUrl(serviceType.getFormUrl());
            serviceItem.setIsServiceDynamic(serviceType.getIsDynamicForm());
            services.add(serviceItem);
        }
        menuItem.setServices(services);
        return menuItem;
    }
}
