package com.codegym.repository;

import com.codegym.entity.MyBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyBlogRepository extends JpaRepository<MyBlog, Integer> {
    Page<MyBlog> findAllByNamePostsContaining(String keyword, Pageable pageable);

    List<MyBlog> findAllByNamePostsContaining(String name);
}
