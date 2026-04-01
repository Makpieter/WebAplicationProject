package com.uep.wap.service;

import com.uep.wap.model.*;
import com.uep.wap.repository.*;
import com.uep.wap.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CommentsService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public void addComment(CommentDTO commentDTO) {

        Comment comment = new Comment();

        comment.setContent(commentDTO.getContent());

        // USER
        User user = userRepository.findById(commentDTO.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        comment.setAuthor(user);

        // DATE
        comment.setCreatedAt(new Date());
        comment.setUpdatedAt(new Date());

        // RELATION (ważne!)
        if (commentDTO.getTargetQuestionId() != null) {
            Question question = questionRepository.findById(commentDTO.getTargetQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));
            comment.setTargetQuestion(question);
        }

        if (commentDTO.getTargetAnswerId() != null) {
            Answer answer = answerRepository.findById(commentDTO.getTargetAnswerId())
                    .orElseThrow(() -> new RuntimeException("Answer not found"));
            comment.setTargetAnswer(answer);
        }

        commentRepository.save(comment);

        System.out.println("Comment added!");
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}