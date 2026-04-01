package com.uep.wap.controller;

import com.uep.wap.model.Category;
import com.uep.wap.service.CategoriesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {

    private final CategoriesService categoriesService;

    public CategoryController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping(path = "/categories")
    public Iterable<Category> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @PostMapping(path = "/categories")
    public String addCategory(@RequestBody Category categoryDTO) {
        categoriesService.addCategory(categoryDTO);
        return "Category added!";
    }
}