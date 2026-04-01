package com.uep.wap.controller;

import com.uep.wap.model.Category;
import com.uep.wap.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "/categories")
    public Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping(path = "/categories")
    public String addCategory(@RequestBody Category categoryDTO) {
        categoryService.addCategory(categoryDTO);
        return "Category added!";
    }
}