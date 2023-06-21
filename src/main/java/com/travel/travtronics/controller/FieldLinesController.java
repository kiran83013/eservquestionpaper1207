package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.model.FieldLines;
import com.travel.travtronics.request.FieldLinesRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.service.FieldLinesService;

@RestController
@RequestMapping("/field_lines")
public class FieldLinesController {

	@Autowired
	FieldLinesService fieldLinesService;

	@PostMapping(value = "/create-field-lines", consumes = "application/json", produces = "application/json")
	public APIResponse createFieldLines(@RequestBody List<FieldLines> lines) {
		return fieldLinesService.createFieldLines(lines);
	}

	@GetMapping(value = "/id-by-prcid", produces = "application/json")
	public APIResponse GetById(@RequestParam Long prcId) {
		return fieldLinesService.GetById(prcId);
	}

	@PutMapping(value = "/edit-field-lines", consumes = "application/json", produces = "application/json")
	public APIResponse editFieldLines(@RequestBody List<FieldLinesRequest> lines) {
		return fieldLinesService.editFieldLines(lines);
	}
}
