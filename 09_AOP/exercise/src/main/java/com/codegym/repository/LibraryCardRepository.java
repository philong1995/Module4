package com.codegym.repository;

import com.codegym.entity.Book;
import com.codegym.entity.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
    Page<LibraryCard> findAllByNameStudentContaining(String keyword, Pageable pageable);
}
