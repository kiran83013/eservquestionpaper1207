package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.converter.FaqConverter;
import com.travel.travtronics.dto.FaqResponseDto;
import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.enums.Status;
import com.travel.travtronics.model.Faq;
import com.travel.travtronics.model.Questions;
import com.travel.travtronics.repository.FaqRepository;
import com.travel.travtronics.repository.FeildLangFaqRepository;
import com.travel.travtronics.repository.QuestionsRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.LangQuestionAnswerResponse;

@Service
public class FaqService {

	@Autowired
	FaqRepository faqRepository;

	@Autowired
	QuestionsRepository questionsRepository;

	@Autowired
	FeildLangFaqRepository faqLangRepository;

	public APIResponse createOrUpdateFaqs(List<Faq> model) {
		List<Faq> faq = faqRepository.saveAll(model);
		return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), Collections.singletonList(faq));
	}

	public APIResponse getFaqByReference(Long referenceId, String reference) {
		List<Faq> find = faqRepository.findAllByReferenceIdAndReferenceAndStatus(referenceId, reference, Status.Active);
		if (!find.isEmpty()) {
			List<FaqResponseDto> faqResponse = FaqConverter.convertFaqQuestionModelToJson(find).stream().map(model -> {
				model.setQuestionModel(getFaqQuestions(model.getQuestion()));
				return model;
			}).collect(Collectors.toList());

			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), faqResponse);
		} else {
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
		}
	}

	private Optional<Questions> getFaqQuestions(Long Id) {
		Optional<Questions> question = questionsRepository.findById(Id);
		return question;
	}

	public APIResponse getFaq(Long id) {
		Optional<Faq> findById = faqRepository.findById(id);
		if (!findById.isPresent())
			return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
		else {
			return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
					Collections.singletonList(findById.get()));
		}
	}

	public APIResponse getFaqs(Long organization) {
		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
				faqRepository.findAllByOrganization(organization));
	}

	public APIResponsePaging getPagenationByOrganization(Long organization, int pageNo, int pageSize, String sortBy,
			SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organization != null) {
			Page<Faq> menuData = faqRepository.findByOrganization(organization, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<Faq> esRegister = faqRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}

	public APIResponse getFaqByReferenceLocalization(Long referenceId, String reference, String langCode) {

		List<Faq> faqInfo = faqRepository.findAllByReferenceIdAndReferenceAndStatus(referenceId, reference,
				Status.Active);

		List<FaqResponseDto> collectedLocalizationFaqInfo = FaqConverter.convertFaqQuestionModelToJson(faqInfo).stream()
				.peek(faq -> {
					Optional<Questions> faqQuestions = getFaqQuestions(faq.getQuestion());

					if (!langCode.equalsIgnoreCase("en")) {

						Optional<LangQuestionAnswerResponse> localizedFaqInfo = faqLangRepository.getLocalizedFaqInfo(
								referenceId.intValue(), reference, langCode, faq.getOrganization().intValue());

						if (localizedFaqInfo.isPresent()) {
							faq.setQuestionName(localizedFaqInfo.get().getQuestionName());
							faq.setAnswer(localizedFaqInfo.get().getAnswer());
						}

					} else {
						faq.setQuestionId(faq.getQuestion());
						faq.setQuestionName(faqQuestions.isPresent() ? faqQuestions.get().getQuestion() : "");
					}

				}).collect(Collectors.toList());

		return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(), collectedLocalizationFaqInfo);
	}

}
