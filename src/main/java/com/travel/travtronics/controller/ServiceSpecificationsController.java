package com.travel.travtronics.controller;

import com.travel.travtronics.model.ServiceFeatures;
import com.travel.travtronics.model.ServiceSpecifications;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.service.ServiceFeaturesService;
import com.travel.travtronics.service.ServiceSpecificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service_specifications")
public class ServiceSpecificationsController {

    @Autowired
    ServiceSpecificationsService serviceSpecificationsService;

    @PostMapping(path = "/saveAndUpdate")
    public APIResponse saveAndUpdate(@RequestBody List<ServiceSpecifications> specifications) {
        return serviceSpecificationsService.saveAndUpdate(specifications);
    }

    @GetMapping(value = "/getByServiceTypeId", produces = "application/json")
    public APIResponse GetById(@RequestParam Long serviceTypeId) {
        return serviceSpecificationsService.getByServiceTypeId(serviceTypeId);
    }
}
