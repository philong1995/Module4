package com.codegym.service;

import com.codegym.entity.Category;

import java.util.List;


public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save (Category category);

    void remove(int id);
}
