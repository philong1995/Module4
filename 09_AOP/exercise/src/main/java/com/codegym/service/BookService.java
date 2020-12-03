package com.codegym.service;

import com.codegym.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);

    void borrowBook(String id_card, int id_book);

    void payBook(int id_card, int id_book) throws Exception;

    int getAmount(int id);

    Page<Book> findAll(Pageable pageable);

    Page<Book> searchBookByName(String keyword,Pageable pageable);
}
