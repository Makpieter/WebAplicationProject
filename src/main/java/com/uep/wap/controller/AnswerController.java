package com.uep.wap.controller;

import com.uep.wap.dto.AnswerDTO;
import com.uep.wap.model.Answer;
import com.uep.wap.service.AnswersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AnswerController {

    private final AnswersService answersService;

    public AnswerController(AnswersService answersService) {
        this.answersService = answersService;
    }

    @GetMapping(path = "/answers")
    public Iterable<Answer> getAllAnswers() {
        return answersService.getAllAnswers();
    }

    @PostMapping(path = "/answers")
    public String addAnswer(@RequestBody AnswerDTO answerDTO) {
        answersService.addAnswer(answerDTO);
        return "Answer added!";
    }
}