package com.example.backend.service;


import com.example.backend.model.Category;

import java.util.List;

public interface ICategoryService {
    Category createCategory(Category category);
    List<Category>getAllCategories();
    Category getCategoryById(Long id);
    Category updateCategory(Long id, Category category);
    void deleteCategoryById(Long id);
}
