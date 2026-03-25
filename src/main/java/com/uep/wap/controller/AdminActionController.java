package com.uep.wap.controller;

import com.uep.wap.dto.AdminActionDTO;
import com.uep.wap.model.AdminAction;
import com.uep.wap.service.AdminActionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AdminActionController {

    private final AdminActionService adminActionService;

    public AdminActionController(AdminActionService adminActionService) {
        this.adminActionService = adminActionService;
    }

    @GetMapping(path = "/admin-actions")
    public Iterable<AdminAction> getAllActions() {
        return adminActionService.getAllActions();
    }

    @PostMapping(path = "/admin-actions")
    public String addAction(@RequestBody AdminActionDTO dto) {
        adminActionService.addAction(dto);
        return "Admin action added!";
    }
}