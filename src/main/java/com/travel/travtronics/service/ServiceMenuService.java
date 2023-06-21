package com.travel.travtronics.service;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.ServiceAttachments;
import com.travel.travtronics.model.ServiceMenu;
import com.travel.travtronics.model.ServiceMenuType;
import com.travel.travtronics.repository.ServiceMenuRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMenuService {
    @Autowired
    ServiceMenuRepository serviceMenuRepository;

    /*
     * Create or Update ServiceMenu Data
     */
    public APIResponse create(List<ServiceMenu> serviceMenuType) {

       /* List<ServiceMenu> serviceMenu = serviceMenuRepository.saveAll(serviceMenuType);
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceMenu);*/
        try {
            List<ServiceMenu> save = serviceMenuRepository.saveAll(serviceMenuType);
            return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), save);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
                    new ArrayList<>());
        }
    }

    /*
     * Update ServiceMenu Data
     */
    public APIResponse update(ServiceMenu serviceMenuType) {
        if(serviceMenuRepository.existsById(serviceMenuType.getId())) {
            ServiceMenu serviceMenu = serviceMenuRepository.save(serviceMenuType);
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(serviceMenu));
        } else {
            return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
                    new ArrayList<>());
        }
    }
    /*
     * Get ServiceMenu Data based given id
     */
    public APIResponse getById(Long id) {
        Optional<ServiceMenu> opt = serviceMenuRepository.findById(id);
        if(opt.isPresent()) {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), Collections.singletonList(opt));
        } else {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), new ArrayList<>());
        }
    }
    /*
     * Get ServiceMenu Data based given ServiceMenuType
     */
    public APIResponse getByServiceMenuType(Long id) {
        List<ServiceMenu> opt = serviceMenuRepository.findByServiceMenuTypeAndStatus(id, Status.Active);
        if(!opt.isEmpty()) {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),opt);
        } else {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), new ArrayList<>());
        }
    }
    /*
     * Get All ServiceMenu Data
     */
   /* public APIResponsePaging getServiceMenu(String name, int pageNo, int pageSize, String sortBy, SortType sortType) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, sortType ==  SortType.asc ? Sort.by(sortBy).ascending(): Sort.by(sortBy).descending());
        if(name != null && !name.isEmpty() ) {
            Page<ServiceMenu> menuData = serviceMenuRepository.findByNameContaining(name, pageable);
            return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(), new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
        } else {
            Page<ServiceMenu> serviceMenuTypeData = serviceMenuRepository.findAll(pageable);
            return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), serviceMenuTypeData.getContent(), new ArrayList<>(), serviceMenuTypeData.getNumber(), serviceMenuTypeData.getTotalElements(), serviceMenuTypeData.getTotalPages());
        }
    }*/

	public APIResponsePaging getPagenationByOrganization(Long organization, int pageNo, int pageSize, String sortBy,SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organization != null ) {
			Page<ServiceMenu> menuData = serviceMenuRepository.findByOrganization(organization, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<ServiceMenu> esRegister = serviceMenuRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}
}
