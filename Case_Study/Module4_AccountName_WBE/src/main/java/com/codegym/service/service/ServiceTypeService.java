package com.codegym.service.service;

import com.codegym.entity.service.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
    ServiceType findById(Integer id);
}
