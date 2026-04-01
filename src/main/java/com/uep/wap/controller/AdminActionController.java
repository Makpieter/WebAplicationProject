package com.uep.wap.controller;

import com.uep.wap.dto.AdminActionDTO;
import com.uep.wap.model.AdminAction;
import com.uep.wap.service.AdminActionsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AdminActionController {

    private final AdminActionsService adminActionsService;

    public AdminActionController(AdminActionsService adminActionsService) {
        this.adminActionsService = adminActionsService;
    }

    @GetMapping(path = "/admin-actions")
    public Iterable<AdminAction> getAllActions() {
        return adminActionsService.getAllActions();
    }

    @PostMapping(path = "/admin-actions")
    public String addAction(@RequestBody AdminActionDTO dto) {
        adminActionsService.addAction(dto);
        return "Admin action added!";
    }
}