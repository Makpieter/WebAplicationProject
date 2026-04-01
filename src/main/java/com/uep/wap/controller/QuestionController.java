package com.uep.wap.controller;

import com.uep.wap.model.Question;
import com.uep.wap.service.QuestionsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class QuestionController {

    private final QuestionsService questionsService;

    public QuestionController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping(path = "/questions")
    public Iterable<Question> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @PostMapping(path = "/questions")
    public String addQuestion(@RequestBody Question questionDTO) {
        questionsService.addQuestion(questionDTO);
        return "Question added!";
    }
}