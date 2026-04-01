package com.uep.wap.service;

import com.uep.wap.model.Category;
import com.uep.wap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(Category categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        categoryRepository.save(category);
        System.out.println("Category added!");
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}