package com.travel.travtronics.service;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.MasterConverter;
import com.travel.travtronics.dto.MasterRequest;
import com.travel.travtronics.enums.Query;
import com.travel.travtronics.exception.NotFoundException;
import com.travel.travtronics.model.MasterModel;
import com.travel.travtronics.repository.MasterDao;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.MasterResponse;
import com.travel.travtronics.response.MessageStatusResponse;

@Service
public class MasterService {

	private final MasterDao masterDao;

	public MasterService(MasterDao masterDao) {
		super();
		this.masterDao = masterDao;

	}

	public MessageStatusResponse save(String tableName, List<MasterRequest> requestList) {
		String sql = String.format(Query.INSERT_QUERY, tableName);
		List<MapSqlParameterSource> sqlParameterSources = requestList.stream().map(MasterConverter::convertJsonToMap)
				.collect(Collectors.toList());
		masterDao.save(sql, sqlParameterSources);
		return new MessageStatusResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name());
	}

	public APIResponse getAll(String tableName) {
		String sql = String.format(Query.GET_ALL, tableName);
		List<MasterResponse> responses = masterDao.getAll(sql).stream().map(MasterConverter::convertModelToJson)
				.collect(Collectors.toList());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), responses);
	}

	public APIResponse getById(String tableName, Integer id) throws NotFoundException {
		String sql = String.format(Query.GET_BY_ID, tableName);
		try {
			MasterModel model = masterDao.getById(sql, id);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(MasterConverter.convertModelToJson(model)));
		} catch (EmptyResultDataAccessException ex) {
			throw new NotFoundException(String.format("Given id : %d not found", id));
		}
	}

	public MessageStatusResponse updateById(String tableName, Integer id, MasterRequest request)
			throws NotFoundException {
		try {
			masterDao.getById(String.format(Query.GET_BY_ID, tableName), id);
			masterDao.updateById(String.format(Query.UPDATE_BY_ID, tableName),
					MasterConverter.convertUpdateJsonToMap(request, id));
			return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
		} catch (EmptyResultDataAccessException ex) {
			throw new NotFoundException(String.format("Given id : %d not found", id));
		}
	}

	public APIResponse getByName(String tableName, String name) {
		String sql = MessageFormat.format(Query.GET_BY_NAME, tableName, "'%" + name + "%'");
		System.out.println(sql);
		List<MasterResponse> responses = masterDao.getByName(sql).stream().map(MasterConverter::convertModelToJson)
				.collect(Collectors.toList());
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), responses);
	}

//	public APIResponse getByOrgId(String tableName, String orgId) throws NotFoundException {
//		String sql = String.format(Query.GET_BY_OrgId, tableName);
//		List<MasterResponse> responses = masterDao.getByOrgId(sql, orgId).stream().map(MasterConverter::convertModelToJson)
//				.collect(Collectors.toList());
//		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), responses);
//	}


}
