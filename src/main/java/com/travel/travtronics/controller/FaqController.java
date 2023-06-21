package com.travel.travtronics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Faq;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.service.FaqService;

@RestController
@RequestMapping("faq")
public class FaqController {

	@Autowired
	FaqService faqService;

	@PostMapping(value = "create-or-update-faqs")
	public APIResponse createOrUpdateFaqs(@RequestBody List<Faq> model) {
		return faqService.createOrUpdateFaqs(model);
	}

	@GetMapping(value = "get-faq/{id}")
	public APIResponse getFaq(@PathVariable Long id) {
		return faqService.getFaq(id);
	}

	@GetMapping(value = "get-faqs")
	public APIResponse getFaqs(@RequestParam Long organization) {
		return faqService.getFaqs(organization);
	}

	@GetMapping(value = "get-faq-by-reference/{referenceId}/{reference}")
	public APIResponse getSurveyByReference(@PathVariable Long referenceId, @PathVariable String reference) {
		return faqService.getFaqByReference(referenceId, reference);

	}

	@GetMapping(value = "/get")
	public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organization,
			@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
		return faqService.getPagenationByOrganization(organization, pageNo, pageSize, sortBy, sortType);
	}

	@GetMapping(value = "get-faq-localization-by-reference/{referenceId}/{reference}/{langCode}")
	public APIResponse getFaqByReferenceLocalization(@PathVariable Long referenceId, @PathVariable String reference,
			@PathVariable String langCode) {
		return faqService.getFaqByReferenceLocalization(referenceId, reference, langCode);

	}
}
