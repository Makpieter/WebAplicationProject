package com.uep.wap.service;

import com.uep.wap.dto.ModeratorActionDTO;
import com.uep.wap.dto.ModeratorActionType;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Question;
import com.uep.wap.model.ModeratorAction;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.ModeratorActionRepository;
import com.uep.wap.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ModeratorActionsService {

    @Autowired
    private ModeratorActionRepository moderatorActionRepository;

    @Autowired
    private QuestionRepository questionRepository; // ✅ instance, not class

    @Autowired
    private AnswerRepository answerRepository;     // ✅ instance, not class

    public void addModeratorAction(ModeratorActionDTO dto) {
        ModeratorAction action = new ModeratorAction();
        action.setDescription(dto.getDescription());

        // Convert string from DTO to enum safely
        if (dto.getActionType() != null) {
            action.setActionType(ModeratorActionType.valueOf(dto.getActionType().toUpperCase()));
        }

        // Assign target question if provided
        if (dto.getTargetQuestionId() != null) {
            Question question = questionRepository.findById(dto.getTargetQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            action.setTargetQuestion(question);
        }

        // Assign target answer if provided
        if (dto.getTargetAnswerId() != null) {
            Answer answer = answerRepository.findById(dto.getTargetAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            action.setTargetAnswer(answer);
        }

        // Set creation date
        action.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : new Date());

        // Save to DB
        moderatorActionRepository.save(action);
        System.out.println("Moderator action added!");
    }

    public Iterable<ModeratorAction> getAllModeratorActions() {
        return moderatorActionRepository.findAll();
    }
}