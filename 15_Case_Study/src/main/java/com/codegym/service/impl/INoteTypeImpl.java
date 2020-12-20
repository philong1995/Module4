package com.codegym.service.impl;

import com.codegym.entity.INoteType;
import com.codegym.repository.INoteTypeRepository;
import com.codegym.service.INoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class INoteTypeImpl implements INoteTypeService {
    @Autowired
    INoteTypeRepository iNoteTypeRepository;
    @Override
    public List<INoteType> findAll() {
        return this.iNoteTypeRepository.findAll();
    }

    @Override
    public INoteType findById(Integer id) {
        return this.iNoteTypeRepository.findById(id).orElse(null);
    }
}
