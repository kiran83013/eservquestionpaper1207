package com.travel.travtronics.controller;

import com.travel.travtronics.enums.SortType;
import com.travel.travtronics.model.Questions;
import com.travel.travtronics.request.ItemRequest;
import com.travel.travtronics.response.APIResponse;
import com.travel.travtronics.response.APIResponsePaging;
import com.travel.travtronics.response.MessageStatusResponse;
import com.travel.travtronics.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @PostMapping(value = "create-question")
    public APIResponse createQuestion(@RequestBody Questions model) {
        return questionsService.createQuestion(model);
    }

    @PutMapping(value = "modify-question/{id}")
    public MessageStatusResponse modifyComponent(@RequestBody Questions model, @PathVariable Long id) {
        return questionsService.modifyQuestion(model, id);
    }

    @GetMapping(value = "get-question/{id}")
    public APIResponse getQuestion(@PathVariable Long id) {
        return questionsService.getQuestion(id);
    }

    @GetMapping(value = "get-questions")
    public APIResponse getQuestions(@RequestParam Long organization) {
        return questionsService.getQuestions(organization);
    }



    @GetMapping(value = "search-questions/{question}")
    public APIResponse SearchQuestions(@PathVariable String question) {
        return questionsService.searchQuestions(question);
    }
    
    @GetMapping(value = "/get")
    public APIResponsePaging getPagenationByOrganization(@RequestParam(required = false) Long organization,
                                                @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "asc", required = false) SortType sortType) {
        return  questionsService.getPagenationByOrganization(organization, pageNo, pageSize, sortBy, sortType);
    }
   
    @GetMapping(value = "search-questions")
    public APIResponse SearchQuestion(@RequestParam(required = false) String question, @RequestParam(required = false) Long organization) {
        return questionsService.searchQuestion(question,organization);
    }
}
