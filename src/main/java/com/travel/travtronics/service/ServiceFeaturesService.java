package com.travel.travtronics.service;


import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.ServiceDocuments;
import com.travel.travtronics.model.ServiceFeatures;

import com.travel.travtronics.repository.ServiceFeaturesRepository;

import com.travel.travtronics.response.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceFeaturesService {

    @Autowired
    ServiceFeaturesRepository serviceFeaturesRepository;

    public APIResponse saveAndUpdate(List<ServiceFeatures> features) {
        List<ServiceFeatures> list = serviceFeaturesRepository.saveAll(features);
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
    }

    public APIResponse getByServiceTypeId(Long headerId) {
        List<ServiceFeatures> opt = serviceFeaturesRepository.findByServiceTypeIdAndStatus(headerId, Status.Active);
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
    }
}
