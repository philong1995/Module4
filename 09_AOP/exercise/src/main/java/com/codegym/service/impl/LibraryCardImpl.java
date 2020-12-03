package com.codegym.service.impl;

import com.codegym.entity.LibraryCard;
import com.codegym.repository.LibraryCardRepository;
import com.codegym.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryCardImpl implements LibraryCardService {
    @Autowired
    LibraryCardRepository libraryCardRepository;

    @Override
    public List<LibraryCard> findAll() {
        return this.libraryCardRepository.findAll();
    }

    @Override
    public LibraryCard findById(int id) {
        return this.libraryCardRepository.findById(id).orElse(null);
    }

    @Override
    public void save(LibraryCard libraryCard) {
        this.libraryCardRepository.save(libraryCard);
    }

    @Override
    public void delete(int id) {
        this.libraryCardRepository.deleteById(id);
    }

    @Override
    public Page<LibraryCard> findAll(Pageable pageable) {
        return this.libraryCardRepository.findAll(pageable);
    }

    @Override
    public Page<LibraryCard> searchCardByNameStudent(String keyword, Pageable pageable) {
        return this.libraryCardRepository.findAllByNameStudentContaining(keyword, pageable);
    }
}
