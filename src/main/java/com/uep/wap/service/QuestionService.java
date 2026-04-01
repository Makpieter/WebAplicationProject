package com.uep.wap.service;

import com.uep.wap.model.Question;
import com.uep.wap.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void addQuestion(Question questionDTO) {
        Question question = new Question();
        question.setId(questionDTO.getId());
        question.setTitle(questionDTO.getTitle());
        question.setDescription(questionDTO.getDescription());
        question.setTags(questionDTO.getTags());
        question.setAuthor(questionDTO.getAuthor());
        question.setCreatedAt(questionDTO.getCreatedAt());
        question.setUpdatedAt(questionDTO.getUpdatedAt());
        question.setStatus(questionDTO.getStatus());
        question.setAcceptedAnswer(questionDTO.getAcceptedAnswer());
        questionRepository.save(question);
        System.out.println("Question added!");
    }

    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}