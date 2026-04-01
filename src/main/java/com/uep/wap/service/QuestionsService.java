package com.uep.wap.service;

import com.uep.wap.model.Question;
import com.uep.wap.repository.AnswerRepository;
import com.uep.wap.repository.QuestionRepository;
import com.uep.wap.repository.TagRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void addQuestion(QuestionDTO dto) {
        Question question = new Question();
        question.setTitle(dto.getTitle());
        question.setDescription(dto.getDescription());
        question.setCreatedAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : new Date());
        question.setUpdatedAt(dto.getUpdatedAt() != null ? dto.getUpdatedAt() : new Date());

        // Author
        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        question.setAuthor(author);

        // Tags
        Set<Tag> tags = new HashSet<>();
        if (dto.getTagIds() != null) {
            for (Long tagId : dto.getTagIds()) {
                Tag tag = tagRepository.findById(tagId)
                        .orElseThrow(() -> new RuntimeException("Tag not found: " + tagId));
                tags.add(tag);
            }
        }
        question.setTags(tags);

        // Accepted Answer (optional)
        if (dto.getAcceptedAnswerId() != null) {
            Answer accepted = answerRepository.findById(dto.getAcceptedAnswerId())
                    .orElseThrow(() -> new RuntimeException("Accepted answer not found"));
            question.setAcceptedAnswer(accepted);
        }

        // Status conversion (example: simple string → Enum)
        if (dto.getStatus() != null) {
            question.setStatus(Enum.valueOf(QuestionStatus.class, dto.getStatus()));
        }

        questionRepository.save(question);
        System.out.println("Question added!");
    }

    public Iterable<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}