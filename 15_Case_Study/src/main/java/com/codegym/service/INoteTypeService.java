package com.codegym.service;

import com.codegym.entity.INoteType;

import java.util.List;

public interface INoteTypeService {
    List<INoteType> findAll();
    INoteType findById(Integer id);
}
