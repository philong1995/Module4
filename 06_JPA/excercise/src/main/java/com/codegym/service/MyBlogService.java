package com.codegym.service;

import com.codegym.entity.MyBlog;

import java.util.List;

public interface MyBlogService {

    List<MyBlog> findAll();

    MyBlog findById(int id);

    void save (MyBlog blog);

    void remove (int id);
}
