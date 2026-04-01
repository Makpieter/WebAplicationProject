package com.uep.wap.controller;

import com.uep.wap.model.Question;
import com.uep.wap.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/questions")
    public Iterable<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping(path = "/questions")
    public String addQuestion(@RequestBody Question questionDTO) {
        questionService.addQuestion(questionDTO);
        return "Question added!";
    }
}