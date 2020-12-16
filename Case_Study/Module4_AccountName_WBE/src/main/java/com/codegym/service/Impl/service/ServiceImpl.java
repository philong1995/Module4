package com.codegym.service.Impl.service;

import com.codegym.entity.service.Service;
import com.codegym.repository.service.ServiceRepository;
import com.codegym.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return this.serviceRepository.findAll();
    }

    @Override
    public Service findById(Integer id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        this.serviceRepository.save(service);
    }

    @Override
    public void delete(Integer id) {
        this.serviceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public Page<Service> searchServiceByName(String keyword, Pageable pageable) {
        return this.serviceRepository.findAllByNameContaining(keyword, pageable);
    }
}
