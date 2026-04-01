package com.uep.wap.controller;

import com.uep.wap.model.ModeratorAction;
import com.uep.wap.service.ModeratorActionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ModeratorActionController {

    private final ModeratorActionService moderatorActionService;

    public ModeratorActionController(ModeratorActionService moderatorActionService) {
        this.moderatorActionService = moderatorActionService;
    }

    @GetMapping(path = "/moderator-actions")
    public Iterable<ModeratorAction> getAllModeratorActions() {
        return moderatorActionService.getAllModeratorActions();
    }

    @PostMapping(path = "/moderator-actions")
    public String addModeratorAction(@RequestBody ModeratorAction actionDTO) {
        moderatorActionService.addModeratorAction(actionDTO);
        return "Moderator action added!";
    }
}