package com.uep.wap.controller;

import com.uep.wap.dto.CommentDTO;
import com.uep.wap.model.Comment;
import com.uep.wap.service.CommentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CommentController {

    private final CommentsService commentsService;

    public CommentController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping(path = "/comments")
    public Iterable<Comment> getAllComments() {
        return commentsService.getAllComments();
    }

    @PostMapping(path = "/comments")
    public String addComment(@RequestBody CommentDTO commentDTO) {
        commentsService.addComment(commentDTO);
        return "Comment added!";
    }
}