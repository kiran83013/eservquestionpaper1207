package com.travel.travtronics.service;

import com.travel.travtronics.enums.Status;

import com.travel.travtronics.model.ServiceSpecifications;
import com.travel.travtronics.repository.ServiceSpecificationsRepository;
import com.travel.travtronics.response.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceSpecificationsService {

    @Autowired
    ServiceSpecificationsRepository serviceSpecificationsRepository;

    public APIResponse saveAndUpdate(List<ServiceSpecifications> features) {
        List<ServiceSpecifications> list = serviceSpecificationsRepository.saveAll(features);
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
    }

    public APIResponse getByServiceTypeId(Long headerId) {
        List<ServiceSpecifications> opt = serviceSpecificationsRepository.findByServiceTypeIdAndStatus(headerId, Status.Active);
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), opt);
    }
}
