package com.codegym.service.service;

import com.codegym.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    Service findById(Integer id);
    void save(Service service);
    void delete(Integer id);
    Page<Service> findAll(Pageable pageable);
    Page<Service> searchServiceByName(String keyword,Pageable pageable);
}
