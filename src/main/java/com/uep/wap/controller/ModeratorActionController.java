package com.uep.wap.controller;

import com.uep.wap.dto.ModeratorActionDTO;
import com.uep.wap.model.ModeratorAction;
import com.uep.wap.service.ModeratorActionsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ModeratorActionController {

    private final ModeratorActionsService moderatorActionsService;

    public ModeratorActionController(ModeratorActionsService moderatorActionsService) {
        this.moderatorActionsService = moderatorActionsService;
    }

    @GetMapping(path = "/moderator-actions")
    public Iterable<ModeratorAction> getAllModeratorActions() {
        return moderatorActionsService.getAllModeratorActions();
    }

    @PostMapping(path = "/moderator-actions")
    public String addModeratorAction(@RequestBody ModeratorActionDTO actionDTO) {
        moderatorActionsService.addModeratorAction(actionDTO);
        return "Moderator action added!";
    }
}