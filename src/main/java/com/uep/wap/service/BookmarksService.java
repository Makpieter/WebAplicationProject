package com.uep.wap.service;

import com.uep.wap.dto.BookmarkDTO;
import com.uep.wap.model.Bookmark;
import com.uep.wap.model.Question;
import com.uep.wap.model.User;
import com.uep.wap.repository.BookmarkRepository;
import com.uep.wap.repository.QuestionRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarksService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void addBookmark(BookmarkDTO bookmarkDTO) {
        Bookmark bookmark = new Bookmark();
        bookmark.setDescription(bookmarkDTO.getDescription());

        // Fetch User entity
        User user = userRepository.findById(bookmarkDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        bookmark.setUser(user);

        // Fetch Question entity
        Question question = questionRepository.findById(bookmarkDTO.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));
        bookmark.setQuestion(question);

        bookmark.setCreatedAt(bookmarkDTO.getCreatedAt());

        bookmarkRepository.save(bookmark);
        System.out.println("Bookmark added!");
    }

    public Iterable<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }
}