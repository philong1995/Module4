package com.codegym.service;

import com.codegym.entity.MyBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MyBlogService {

    List<MyBlog> findAll();

    MyBlog findById(int id);

    void save (MyBlog blog);

    void remove(int id);

    Page<MyBlog> findAll(Pageable pageable);

    Page<MyBlog> searchPostByName(String keyword, Pageable pageable);
}

