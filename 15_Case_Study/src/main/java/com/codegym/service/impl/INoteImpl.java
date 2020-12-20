package com.codegym.service.impl;

import com.codegym.entity.INote;
import com.codegym.repository.INoteRepository;
import com.codegym.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class INoteImpl implements INoteService {
    @Autowired
    INoteRepository iNoteRepository;

    @Override
    public List<INote> findAll() {
        return this.iNoteRepository.findAll();
    }

    @Override
    public INote findById(Integer id) {
        return this.iNoteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(INote iNote) {
        this.iNoteRepository.save(iNote);
    }

    @Override
    public void delete(Integer id) {
        this.iNoteRepository.deleteById(id);
    }

    @Override
    public Page<INote> findAll(Pageable pageable) {
        return this.iNoteRepository.findAll(pageable);
    }

    @Override
    public Page<INote> search(String keyword, Pageable pageable) {
        return this.iNoteRepository.findAllByTittleContaining(keyword, pageable);
    }
}
