package com.uep.wap.service;

import com.uep.wap.dto.BookmarkDTO;
import com.uep.wap.model.Bookmark;
import com.uep.wap.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarksService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    public void addBookmark(BookmarkDTO bookmarkDTO) {
        Bookmark bookmark = new Bookmark();
        bookmark.setDescription(bookmarkDTO.getDescription());
        bookmark.setUserId(bookmarkDTO.getUserId());
        bookmark.setQuestionId(bookmarkDTO.getQuestionId());
        bookmark.setCreatedAt(bookmarkDTO.getCreatedAt());
        bookmarkRepository.save(bookmark);
        System.out.println("Bookmark added!");
    }

    public Iterable<Bookmark> getAllBookmarks() {
        return bookmarkRepository.findAll();
    }
}