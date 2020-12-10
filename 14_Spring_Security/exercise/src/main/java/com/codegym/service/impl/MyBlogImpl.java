package com.codegym.service.impl;

import com.codegym.entity.MyBlog;
import com.codegym.repository.MyBlogRepository;
import com.codegym.service.MyBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBlogImpl implements MyBlogService {
    @Autowired
    private MyBlogRepository blogRepository;

    @Override
    public List<MyBlog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public MyBlog findById(int id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(MyBlog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        this.blogRepository.deleteById(id);
    }

    @Override
    public Page<MyBlog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
    }

    @Override
    public Page<MyBlog> searchPostByName(String keyword, Pageable pageable) {
        return this.blogRepository.findAllByNamePostsContaining(keyword, pageable);
    }
}
