package com.travel.travtronics.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Questions;
import com.travel.travtronics.repository.QuestionsRepository;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.MessageStatusResponse;

@Service
public class QuestionsService {

    @Autowired
    QuestionsRepository questionsRepository;

    public APIResponse createQuestion(Questions model) {
        Questions question = questionsRepository.save(model);
        return new APIResponse(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), Collections.singletonList(question));
    }

    public MessageStatusResponse modifyQuestion( Questions model, Long id) {
        Optional<Questions> findById =  questionsRepository.findById(id);
        if (!findById.isPresent())
            return new MessageStatusResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());
        else {
            questionsRepository.save(model);
            return new MessageStatusResponse(HttpStatus.OK.value(), HttpStatus.OK.name());
        }

    }

    public APIResponse getQuestion(Long id) {
        Optional< Questions> findById =  questionsRepository.findById(id);
        if (!findById.isPresent())
            return new APIResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), Collections.emptyList());
        else {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    Collections.singletonList(findById.get()));
        }
    }

    public APIResponse getQuestions(Long organization) {
        return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                 questionsRepository.findAllByOrganization(organization));
    }

    public APIResponse searchQuestions(String question) {
        if(question != null) {
            List<Questions> findById =  questionsRepository.findByQuestion(question);
            if(!findById.isEmpty())
                return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    findById);
            else {
                return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                        Collections.emptyList());
            }
        } else {
            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    Collections.emptyList());
        }

    }

	public APIResponsePaging getPagenationByOrganization(Long organization, int pageNo, int pageSize, String sortBy,SortType sortType) {
		Pageable pageable = PageRequest.of(pageNo, pageSize,
				sortType == SortType.asc ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending());
		if (organization != null ) {
			Page<Questions> menuData = questionsRepository.findByOrganization(organization, pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), menuData.getContent(),
					new ArrayList<>(), menuData.getNumber(), menuData.getTotalElements(), menuData.getTotalPages());
		} else {
			Page<Questions> esRegister = questionsRepository.findAll(pageable);
			return new APIResponsePaging(HttpStatus.OK.value(), HttpStatus.OK.name(), esRegister.getContent(),
					new ArrayList<>(), esRegister.getNumber(), esRegister.getTotalElements(),
					esRegister.getTotalPages());
		}
	}

	public APIResponse searchQuestion(String question, Long organization) {
		 if(question != null) {
	            List<Questions> findById =  questionsRepository.findByQuestionAndOrganization(question, organization);
	            if(!findById.isEmpty())
	                return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
	                    findById);
	            else {
	                return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
	                        Collections.emptyList());
	            }
	        } else {
	            return new APIResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
	                    Collections.emptyList());
	        }
	}
}
