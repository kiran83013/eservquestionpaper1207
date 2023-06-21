package com.travel.travtronics.controller;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.request.ServiceAssignmentRequest;
import com.travel.travtronics.request.ServicePricingRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.ServiceAssignmentService;
import com.travel.travtronics.service.ServicePricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service_assignment")
public class ServiceAssignmentController {

    @Autowired
    ServiceAssignmentService serviceAssignmentService;

    @PostMapping(path = "/saveAndUpdate")
    public APIResponse saveAndUpdate(@RequestBody List<ServiceAssignmentRequest> assignment) {
        return serviceAssignmentService.saveAndUpdate(assignment);
    }
    @GetMapping(value = "/headerId", produces = "application/json")
    public APIResponse GetByHeaderId(@RequestParam Long headerId) {
        return serviceAssignmentService.getHeaderById(headerId);
    }
    
    @GetMapping(value = "/get")
    public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organizationId,
                                                @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
        return  serviceAssignmentService.getPagenationByOrganization(organizationId, pageNo, pageSize, sortBy, sortType);
    }
}
