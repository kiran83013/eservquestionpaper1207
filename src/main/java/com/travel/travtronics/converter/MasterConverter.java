package com.travel.travtronics.converter;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.travel.travtronics.dto.MasterRequest;
import com.travel.travtronics.model.MasterModel;
import com.travel.travtronics.response.MasterResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MasterConverter {

	public static MapSqlParameterSource convertJsonToMap(MasterRequest request) {

		String dateTime = LocalDateTime.now().toString();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("name", request.getName());
		mapSqlParameterSource.addValue("code", request.getCode());
		mapSqlParameterSource.addValue("description", request.getDescription());
		mapSqlParameterSource.addValue("created_by", request.getCreatedBy());
		mapSqlParameterSource.addValue("status", request.getStatus());
		mapSqlParameterSource.addValue("created_date", dateTime);
		mapSqlParameterSource.addValue("updated_by", request.getUpdatedBy());
		mapSqlParameterSource.addValue("updated_date", dateTime);
		return mapSqlParameterSource;
	}

	public static MapSqlParameterSource convertUpdateJsonToMap(MasterRequest request, Integer id) {
		String dateTime = LocalDateTime.now().toString();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("ID", id);
		mapSqlParameterSource.addValue("name", request.getName());
		mapSqlParameterSource.addValue("code", request.getCode());
		mapSqlParameterSource.addValue("description", request.getDescription());
		mapSqlParameterSource.addValue("updated_date", dateTime);
		mapSqlParameterSource.addValue("updated_by", request.getUpdatedBy());
		mapSqlParameterSource.addValue("status", request.getStatus());
		return mapSqlParameterSource;
	}

	public static MasterResponse convertModelToJson(MasterModel model) {
		MasterResponse response = new MasterResponse();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setCode(model.getCode());
		response.setDescription(model.getDescription());
		response.setStatus(model.getStatus());
		response.setCreatedBy(model.getCreatedBy());
		response.setUpdatedBy(model.getUpdatedBy());
		response.setUpdatedDate(model.getUpdatedDate());
		response.setCreatedDate(model.getCreatedDate());
		return response;
	}

//	public static List<MasterResponse> convertModelToJson(List<MasterModel> model) {
//		List<MasterResponse> response = new ArrayList();
//		response.set(1, element)
//		response.setName(model.get(2).getName());
//		response.setCode(model.get(3).getCode());
//		response.setOrgId(model.get(4).getOrgId());
//		response.setDescription(model.get(5).getDescription());
//		response.setStatus(model.get(6).getStatus());
//		response.setCreatedBy(model.get(7).getCreatedBy());
//		response.setUpdatedBy(model.get(8).getUpdatedBy());
//		response.setUpdatedDate(model.get(9).getUpdatedDate());
//		response.setCreatedDate(model.get(10).getCreatedDate());
//		return response;
//	}
}
