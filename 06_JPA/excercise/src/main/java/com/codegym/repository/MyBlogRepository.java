package com.codegym.repository;

import com.codegym.entity.MyBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyBlogRepository extends JpaRepository<MyBlog, Integer> {

}
