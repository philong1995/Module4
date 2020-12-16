package com.codegym.service.Impl.service;

import com.codegym.entity.service.RentType;
import com.codegym.repository.service.RentTypeRepository;
import com.codegym.service.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RentTypeImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return this.rentTypeRepository.findById(id).orElse(null);
    }
}
