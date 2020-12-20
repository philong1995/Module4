package com.codegym.service;

import com.codegym.entity.INote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface INoteService {
    List<INote> findAll();
    INote findById(Integer id);
    void save(INote iNote);
    void delete(Integer id);
    Page<INote> findAll(Pageable pageable);
    Page<INote> search(String keyword,Pageable pageable);
}
