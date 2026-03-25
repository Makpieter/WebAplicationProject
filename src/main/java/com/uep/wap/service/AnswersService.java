package com.uep.wap.service;

import com.uep.wap.model.Answer;
import com.uep.wap.model.User;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.UserRepository;
import com.uep.wap.dto.AnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnswersService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    public void addAnswer(AnswerDTO answerDTO) {
        Answer answer = new Answer();

        answer.setDescription(answerDTO.getDescription());

        // pobranie usera z bazy
        User user = userRepository.findById(answerDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        answer.setAuthor(user);

        answer.setCreatedAt(new Date());
        answer.setUpdatedAt(new Date());
        answer.setVotes(0);
        answer.setAccepted(false);

        answerRepository.save(answer);

        System.out.println("Answer added!");
    }

    public Iterable<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }
}