package com.codegym.service.service;

import com.codegym.entity.service.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
    RentType findById(Integer id);
}
