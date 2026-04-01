package com.uep.wap.service;

import com.uep.wap.dto.ModeratorActionDTO;
import com.uep.wap.dto.ModeratorActionType;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Question;
import com.uep.wap.model.ModeratorAction;
import com.uep.wap.repository.ModeratorActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorActionsService {

    @Autowired
    private ModeratorActionRepository moderatorActionRepository;

    public void addModeratorAction(ModeratorActionDTO dto) {
        ModeratorAction action = new ModeratorAction();
        action.setDescription(dto.getDescription());
        action.setActionType(ModeratorActionType.valueOf(dto.getActionType()));

        if (dto.getTargetQuestionId() != null) {
            Question question = questionRepository.findById(dto.getTargetQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            action.setTargetQuestion(question);
        }

        if (dto.getTargetAnswerId() != null) {
            Answer answer = answerRepository.findById(dto.getTargetAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            action.setTargetAnswer(answer);
        }

        action.setCreatedAt(dto.getCreatedAt());
        moderatorActionRepository.save(action);
        System.out.println("Moderator action added!");
    }

    public Iterable<ModeratorAction> getAllModeratorActions() {
        return moderatorActionRepository.findAll();
    }
}