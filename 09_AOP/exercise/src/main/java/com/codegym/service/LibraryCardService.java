package com.codegym.service;

import com.codegym.entity.Book;
import com.codegym.entity.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibraryCardService {
    List<LibraryCard> findAll();

    LibraryCard findById(int id);

    void save(LibraryCard libraryCard);

    void delete(int id);

    Page<LibraryCard> findAll(Pageable pageable);

    Page<LibraryCard> searchCardByNameStudent(String keyword,Pageable pageable);
}
