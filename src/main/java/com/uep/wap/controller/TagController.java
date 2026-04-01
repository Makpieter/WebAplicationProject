package com.uep.wap.controller;

import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Tag;
import com.uep.wap.service.TagsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TagController {

    private final TagsService tagsService;

    public TagController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @GetMapping(path = "/tags")
    public Iterable<Tag> getAllTags() {
        return tagsService.getAllTags();
    }

    @PostMapping(path = "/tags")
    public String addTag(@RequestBody TagDTO tagDTO) {
        tagsService.addTag(tagDTO);
        return "Tag added!";
    }
}