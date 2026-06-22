package com.uep.wap.controller;

import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.model.Question;
import com.uep.wap.service.QuestionsService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(questionsService.getQuestionById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /** Returns the saved Question (with its id) so the frontend can navigate to it. */
    @PostMapping(path = "/questions")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDTO questionDTO) {
        try {
            Question saved = questionsService.addQuestion(questionDTO);
            return ResponseEntity.ok(saved);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(path = "/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id,
                                                   @RequestBody QuestionDTO questionDTO) {
        try {
            Question updated = questionsService.updateQuestion(id, questionDTO);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
