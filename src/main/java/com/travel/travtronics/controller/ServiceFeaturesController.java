package com.travel.travtronics.controller;


import com.travel.travtronics.model.ServiceFeatures;
import com.travel.travtronics.request.ServiceDocumentsRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.service.ServiceFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service_features")
public class ServiceFeaturesController {


    @Autowired
    ServiceFeaturesService serviceFeaturesService;

    @PostMapping(path = "/saveAndUpdate")
    public APIResponse saveAndUpdate(@RequestBody List<ServiceFeatures> features) {
        return serviceFeaturesService.saveAndUpdate(features);
    }

    @GetMapping(value = "/getByServiceTypeId", produces = "application/json")
    public APIResponse GetById(@RequestParam Long serviceTypeId) {
        return serviceFeaturesService.getByServiceTypeId(serviceTypeId);
    }
}
