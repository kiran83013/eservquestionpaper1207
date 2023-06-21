package com.travel.travtronics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.dto.MasterRequest;
import com.travel.travtronics.exception.NotFoundException;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.service.MasterService;

@RestController
@RequestMapping("/master/{tableName}")
public class MasterController {

	
	private final MasterService service;

	public MasterController(MasterService service) {
		super();
		this.service = service;
	}
	@PostMapping()
    public MessageStatusResponse save(@PathVariable String tableName, @Valid @RequestBody List<MasterRequest> requestList) {
       
    	return service.save(tableName, requestList);
    }

    @GetMapping("/all")
    public APIResponse getAll(@PathVariable String tableName) {
        return service.getAll(tableName);
    }

    @GetMapping("/id/{id}")
    public APIResponse getById(@PathVariable String tableName, @PathVariable Integer id) throws NotFoundException {
        return service.getById(tableName, id);
    }

    @GetMapping("/name/{name}")
    public APIResponse getByName(@PathVariable String tableName, @PathVariable String name) {
        return service.getByName(tableName, name);
    }

    @PutMapping("/{id}")
    public MessageStatusResponse updateById(@PathVariable String tableName, @PathVariable Integer id, @Valid @RequestBody MasterRequest request) throws NotFoundException {
        return service.updateById(tableName, id, request);
    }
    
//    @GetMapping("/orgId/{orgId}")
//    public APIResponse getByOrgId(@PathVariable String tableName, @PathVariable String orgId) throws NotFoundException {
//        return service.getByOrgId(tableName, orgId);
//    }
//	
}
