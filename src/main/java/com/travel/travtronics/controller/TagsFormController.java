package com.travel.travtronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.TagsForm;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.TagsFormService;

@RestController
@RequestMapping("/tags")
public class TagsFormController {

	@Autowired
	TagsFormService tagsformService;

	@PostMapping(value = "create", consumes = "application/json", produces = "application/json")
	public APIResponse createTags(@RequestBody TagsForm tform) {
		return tagsformService.createTags(tform);
	}

	@GetMapping(value = "id", produces = "application/json")
	public APIResponse GetById(@RequestParam Long tagId) {
		return tagsformService.GetById(tagId);
	}

	@PutMapping(value = "edit", consumes = "application/json", produces = "application/json")
	public APIResponse editTags(@RequestBody TagsForm tform) {
		return tagsformService.editTags(tform);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public APIResponse getAll(@RequestParam Long organizationId) {
		return tagsformService.getAll(organizationId);
	}
	
	@GetMapping(value = "/list-tags-pagination")
	public APIResponsePaging getTagsPagenationByOrganization(
			@RequestParam(required = false) Long organizationId, @RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestParam(defaultValue = "tagId") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return tagsformService.getTagsPagenationByOrganization(organizationId, pageNo, pageSize, sortBy,
				sortType);
	}
}
