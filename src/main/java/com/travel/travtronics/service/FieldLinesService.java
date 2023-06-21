package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.FieldLinesConverter;
import com.travel.travtronics.model.FieldLines;
import com.travel.travtronics.repository.FieldLinesRepository;
import com.travel.travtronics.request.FieldLinesRequest;
import com.travel.travtronics.response.APIResponse;

@Service
public class FieldLinesService {

	@Autowired
	FieldLinesRepository fieldLinesRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public APIResponse createFieldLines(List<FieldLines> lines) {
		try {
			List<FieldLines> list = new ArrayList<>();
			List<FieldLines> save = fieldLinesRepository.saveAll(lines);
			list.addAll(save);
			return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),
					new ArrayList<>());
		}
	}

	public APIResponse GetById(Long prcId) {
		try {
			List<Map<String, String>> list = fieldLinesRepository.findAllByPrcId(prcId);
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), new ArrayList<>());
		}
	}

	public APIResponse editFieldLines(List<FieldLinesRequest> lines) {
		List<FieldLines> list = fieldLinesRepository.saveAll(
				lines.stream().map(FieldLinesConverter::convertFieldLinesToModel).collect(Collectors.toList()));
		logger.info("fieldlines-modified");
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), list);
	}

}
