package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.EServiceRegisterConverter;
import com.travel.travtronics.dto.EServiceRegisterCustomRepository;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.EServiceRegister;
import com.travel.travtronics.model.MasterModule;
import com.travel.travtronics.repository.EServiceRegisterRepository;
import com.travel.travtronics.repository.MasterModuleRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.EServiceRegisterResponse;

@Service
public class EServiceRegisterService {

	@Autowired
	EServiceRegisterRepository esrRepository;

	@Autowired
	EServiceRegisterCustomRepository esCustomRepository;

	public APIResponse create(EServiceRegister eservice) {
		List<EServiceRegister> list = new ArrayList<>();
		try {
			EServiceRegister save = esrRepository.save(eservice);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getId(Long id) {
		List<EServiceRegister> list = new ArrayList<>();
		try {
			Optional<EServiceRegister> opt = esrRepository.findById(id);
			if (opt.isPresent()) {
				list.add(opt.get());
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse edit(EServiceRegister eservice) {
		List<EServiceRegister> list = new ArrayList<>();
		try {
			Optional<EServiceRegister> opt = esrRepository.findById(eservice.getId());
			if (opt.isPresent()) {
				eservice.setCreatedBy(opt.get().getCreatedBy());

				EServiceRegister save = esrRepository.save(eservice);
				list.add(save);
				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
			} else {
				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse getAllByOrganization(Long organizationId) {
		try {
//			List<Map<String, String>> list =bpfsrRepository.findByList();
			List<Map<String, String>> list = esrRepository.findByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	@Autowired
	MasterModuleRepository mmRepository;
//
//	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,
//			SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null ) {
//			Page<EServiceRegister> menuData = esrRepository.findByOrganizationId(organizationId, pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
//					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
//		} else {
//			Page<EServiceRegister> esRegister = esrRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
//					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
//					esRegister.getTotalPages());
//		}

//		if (organizationId != null) {
//			Page<EServiceRegister> menuData = esrRepository.findByOrganizationId(organizationId, pageable);
//			Page<EServiceRegisterResponse> item = menuData.map(model -> {
//				EServiceRegisterResponse response = EServiceRegisterConverter.convertEServiceRegisterToModel(model);
//				Optional<MasterModule> findById = mmRepository.findById(response.getModuleId());
//				response.setModuleName(findById.isPresent() ? findById.get().getName() : null);
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		} else {
//			Page<EServiceRegister> menuData = esrRepository.findAll(pageable);
//			Page<EServiceRegisterResponse> item = menuData.map(model -> {
//				EServiceRegisterResponse response = EServiceRegisterConverter.convertEServiceRegisterToModel(model);
//				Optional<MasterModule> findById = mmRepository.findById(response.getModuleId());
//				response.setModuleName(findById.isPresent() ? findById.get().getName() : null);
//				return response;
//			});
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
//					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
//		}
//	}

	public APIResponsePaging getPagenationByOrganization(Long organizationId, String serviceName, int pageNo,
			int pageSize, String sortBy, SortType sortType) {

		Pageable pageable = PageRequest.of(pageNo, pageSize);

		Page<EServiceRegister> serviceMenuTypeData = esCustomRepository.fetchEServiceRegisterPagination(serviceName,
				organizationId, pageable, sortBy, sortType);
		Page<EServiceRegisterResponse> item = serviceMenuTypeData.map(model -> {
			EServiceRegisterResponse response = EServiceRegisterConverter.convertEServiceRegisterToModel(model);
			Optional<MasterModule> findById = mmRepository.findById(response.getModuleId());
			response.setModuleName(findById.isPresent() ? findById.get().getName() : null);
			return response;
		});

		return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(), new ArrayList<>(),
				item.getNumber(), item.getTotalElements(), item.getTotalPages());
	}
}
