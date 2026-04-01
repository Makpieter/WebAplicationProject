package com.uep.wap.controller;

import com.uep.wap.dto.BookmarkDTO;
import com.uep.wap.model.Bookmark;
import com.uep.wap.service.BookmarksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class BookmarkController {

    private final BookmarksService bookmarksService;

    public BookmarkController(BookmarksService bookmarksService) {
        this.bookmarksService = bookmarksService;
    }

    @GetMapping(path = "/bookmarks")
    public Iterable<Bookmark> getAllBookmarks() {
        return bookmarksService.getAllBookmarks();
    }

    @PostMapping(path = "/bookmarks")
    public String addBookmark(@RequestBody BookmarkDTO bookmarkDTO) {
        bookmarksService.addBookmark(bookmarkDTO);
        return "Bookmark added!";
    }
}