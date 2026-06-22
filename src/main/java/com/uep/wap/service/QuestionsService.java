package com.uep.wap.service;

import com.uep.wap.dto.QuestionDTO;
import com.uep.wap.dto.QuestionStatus;
import com.uep.wap.model.Answer;
import com.uep.wap.model.Question;
import com.uep.wap.model.Tag;
import com.uep.wap.model.User;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.QuestionRepository;
import com.uep.wap.repository.TagRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionsService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private AnswerRepository answerRepository;

    /** Create a new question and return the saved entity (with generated id). */
    public Question addQuestion(QuestionDTO dto) {
        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setDescription(dto.getDescription());
        question.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : new Date());
        question.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : new Date());
        question.setStatus(dto.getStatus() != null ? dto.getStatus() : QuestionStatus.OPEN);

        // Author
        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found: " + dto.getAuthorId()));
        question.setAuthor(author);

        // Tags (zero or more)
        Set<Tag> tags = new HashSet<>();
        if (dto.getTagIds() != null) {
            for (Long tagId : dto.getTagIds()) {
                Tag tag = tagRepository.findById(tagId)
                        .orElseThrow(() -> new RuntimeException("Tag not found: " + tagId));
                tags.add(tag);
            }
        }
        question.setTags(tags);

        // Accepted answer (optional, typically null on creation)
        if (dto.getAcceptedAnswerId() != null) {
            Answer accepted = answerRepository.findById(dto.getAcceptedAnswerId())
                    .orElseThrow(() -> new RuntimeException("Accepted answer not found"));
            question.setAcceptedAnswer(accepted);
        }

        return questionRepository.save(question);
    }

    /** Update an existing question by id and return the saved entity. */
    public Question updateQuestion(Long id, QuestionDTO dto) {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found: " + id));

        question.setTitle(dto.getTitle());
        question.setDescription(dto.getDescription());
        question.setUpdatedAt(new Date());

        if (dto.getStatus() != null) {
            question.setStatus(dto.getStatus());
        }

        // Replace tag set with the new selection
        Set<Tag> tags = new HashSet<>();
        if (dto.getTagIds() != null) {
            for (Long tagId : dto.getTagIds()) {
                Tag tag = tagRepository.findById(tagId)
                        .orElseThrow(() -> new RuntimeException("Tag not found: " + tagId));
                tags.add(tag);
            }
        }
        question.setTags(tags);

        return questionRepository.save(question);
    }

    /** Fetch a single question by id. */
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found: " + id));
    }

    /** Fetch all questions. */
    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}
