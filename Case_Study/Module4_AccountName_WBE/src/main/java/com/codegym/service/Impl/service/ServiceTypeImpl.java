package com.codegym.service.Impl.service;

import com.codegym.entity.service.ServiceType;
import com.codegym.repository.service.ServiceTypeRepository;
import com.codegym.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Integer id) {
        return this.serviceTypeRepository.findById(id).orElse(null);
    }
}
