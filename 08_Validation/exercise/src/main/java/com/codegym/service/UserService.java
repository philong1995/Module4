package com.codegym.service;

import com.codegym.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void delete(int id);

    Page<User> findAll(Pageable pageable);

    Page<User> searchUserByFirstName(String keyword,Pageable pageable);
}
