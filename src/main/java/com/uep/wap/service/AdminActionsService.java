package com.uep.wap.service;

import com.uep.wap.model.*;
import com.uep.wap.repository.*;
import com.uep.wap.dto.AdminActionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminActionsService {

    @Autowired
    private AdminActionRepository adminActionRepository;

    @Autowired
    private UserRepository userRepository;

    public void addAction(AdminActionDTO dto) {

        AdminAction action = new AdminAction();

        action.setActionType(dto.getActionType());
        action.setTargetSetting(dto.getTargetSetting());

        // target user
        if (dto.getTargetUserId() != null) {
            User targetUser = userRepository.findById(dto.getTargetUserId())
                    .orElseThrow(() -> new RuntimeException("Target user not found"));
            action.setTargetUser(targetUser);
        }

        // admin performing action
        User admin = userRepository.findById(dto.getAdminId())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        action.setActionTakenBy(admin);

        action.setCreatedAt(new Date());

        adminActionRepository.save(action);

        System.out.println("Admin action saved!");
    }

    public Iterable<AdminAction> getAllActions() {
        return adminActionRepository.findAll();
    }
}