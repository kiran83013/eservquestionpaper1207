package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.AgreementLinesConverter;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.AgreementLines;
import com.travel.travtronics.repository.AgreementLinesRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.AgreementLinesResponse;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

@Service
public class AgreementLinesService {

	@Autowired
	AgreementLinesRepository agreementLinesRepository;

	public APIResponse createAgreementLines(AgreementLines agreement) {
		try {
			List<AgreementLines> list = new ArrayList<>();
			AgreementLines save = agreementLinesRepository.save(agreement);
			list.add(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

//	public APIResponse GetById(Long agreementLineId) {
//		try {
//			Optional<Map<String,String>> opt = agreementLinesRepository.findByAgreementLineId(agreementLineId);
//			List<AgreementLines> list = new ArrayList<>();
//			if (opt.isPresent()) {
//				list.add(opt.get());
//				return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
//			} else {
//				return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
//					new ArrayList<>());
//		}
//	}

	public APIResponse editAgreement(AgreementLines agreement) {
		List<AgreementLines> list = new ArrayList<>();
		try {
			Optional<AgreementLines> opt = agreementLinesRepository.findById(agreement.getAgreementLineId());
			if (opt.isPresent()) {
				agreement.setCreatedBy(opt.get().getCreatedBy());
				AgreementLines save = agreementLinesRepository.save(agreement);
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

	public APIResponse getAll(Long organizationId) {
		try {
			List<Map<String, String>> list = agreementLinesRepository.findByOrganizationId(organizationId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	/**public APIResponse getAllByAgreementId(Long agreementId) {
		try {
			List<Map<String, String>> list = agreementLinesRepository.findAllByAgreementId(agreementId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}**/

//	public APIResponsePaging getPagenationByOrganization(Long organizationId, int pageNo, int pageSize, String sortBy,
//			SortType sortType) {
//		Pageable pageable = PageRequest.of(pageNo, pageSize,
//				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
//		if (organizationId != null) {
//			Page<AgreementLines> findByOrganizationId = agreementLinesRepository.findByOrganizationId(organizationId,
//					pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findByOrganizationId.getContent(),
//					new ArrayList<>(), findByOrganizationId.getNumber(), findByOrganizationId.getTotalElements(),
//					findByOrganizationId.getTotalPages());
//		} else {
//			Page<AgreementLines> findAll = agreementLinesRepository.findAll(pageable);
//			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), findAll.getContent(),
//					new ArrayList<>(), findAll.getNumber(), findAll.getTotalElements(), findAll.getTotalPages());
//		}
//	}

	public APIResponse GetById(Long agreementLineId) {
		try {
			List<Map<String, String>> list = agreementLinesRepository.findAllByAgreementLineId(agreementLineId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponsePaging getPagenationByOrganizationAndAgreementId(Long organizationId, Long agreementId,int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organizationId!= null) {
			Page<AgreementLines> findByOrganizationId = agreementLinesRepository.findByOrganizationIdAndAgreementId(organizationId,agreementId,
					pageable);
			Page<AgreementLinesResponse> item = findByOrganizationId.map(model -> {
				AgreementLinesResponse response = AgreementLinesConverter.convertModelToResponse(model);
				Optional<String> orgName = agreementLinesRepository.getOrgName(response.getOrganizationId());
				Optional<String> agreementName = agreementLinesRepository.getAgreementName(response.getAgreementId());
				Optional<String> srtypeName = agreementLinesRepository.getSrTypeName(response.getSrtype());
				Optional<String> categoryName = agreementLinesRepository.getCategoryName(response.getCategory());
				if (orgName.isPresent())
					response.setOrgName(orgName.get());
				if (agreementName.isPresent())
					response.setAgreementName(agreementName.get());
				if (srtypeName.isPresent())
					response.setSrTypeName(srtypeName.get());
				if (categoryName.isPresent())
					response.setCategoryName(categoryName.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		} 
		if (agreementId!=null) {
			Page<AgreementLines> findByOrganizationId = agreementLinesRepository.findByAgreementId(agreementId,
					pageable);
			Page<AgreementLinesResponse> item = findByOrganizationId.map(model -> {
				AgreementLinesResponse response = AgreementLinesConverter.convertModelToResponse(model);
				Optional<String> orgName = agreementLinesRepository.getOrgName(response.getOrganizationId());
				Optional<String> agreementName = agreementLinesRepository.getAgreementName(response.getAgreementId());
				Optional<String> srtypeName = agreementLinesRepository.getSrTypeName(response.getSrtype());
				Optional<String> categoryName = agreementLinesRepository.getCategoryName(response.getCategory());
				if (orgName.isPresent())
					response.setOrgName(orgName.get());
				if (agreementName.isPresent())
					response.setAgreementName(agreementName.get());
				if (srtypeName.isPresent())
					response.setSrTypeName(srtypeName.get());
				if (categoryName.isPresent())
					response.setCategoryName(categoryName.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}else {
			Page<AgreementLines> findByOrganizationId = agreementLinesRepository.findAll(pageable);
			Page<AgreementLinesResponse> item = findByOrganizationId.map(model -> {
				AgreementLinesResponse response = AgreementLinesConverter.convertModelToResponse(model);
				Optional<String> orgName = agreementLinesRepository.getOrgName(response.getOrganizationId());
				Optional<String> agreementName = agreementLinesRepository.getAgreementName(response.getAgreementId());
				Optional<String> srtypeName = agreementLinesRepository.getSrTypeName(response.getSrtype());
				Optional<String> categoryName = agreementLinesRepository.getCategoryName(response.getCategory());
				if (orgName.isPresent())
					response.setOrgName(orgName.get());
				if (agreementName.isPresent())
					response.setAgreementName(agreementName.get());
				if (srtypeName.isPresent())
					response.setSrTypeName(srtypeName.get());
				if (categoryName.isPresent())
					response.setCategoryName(categoryName.get());
				return response;
			});
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), item.getContent(),
					new ArrayList<>(), item.getNumber(), item.getTotalElements(), item.getTotalPages());
		}
	}

	
}
