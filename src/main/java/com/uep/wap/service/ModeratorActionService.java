package com.uep.wap.service;

import com.uep.wap.model.ModeratorAction;
import com.uep.wap.repository.ModeratorActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorActionService {

    @Autowired
    private ModeratorActionRepository moderatorActionRepository;

    public void addModeratorAction(ModeratorAction actionDTO) {
        ModeratorAction action = new ModeratorAction();
        action.setId(actionDTO.getId());
        action.setDescription(actionDTO.getDescription());
        action.setActionType(actionDTO.getActionType());
        action.setTargetQuestion(actionDTO.getTargetQuestion());
        action.setTargetAnswer(actionDTO.getTargetAnswer());
        action.setCreatedAt(actionDTO.getCreatedAt());
        moderatorActionRepository.save(action);
        System.out.println("Moderator action added!");
    }

    public Iterable<ModeratorAction> getAllModeratorActions() {
        return moderatorActionRepository.findAll();
    }
}