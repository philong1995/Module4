package com.codegym.service.impl;

import com.codegym.entity.Smartphone;
import com.codegym.repository.SmartphoneRepository;
import com.codegym.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return this.smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    public Smartphone save(Smartphone phone) {
        return this.smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone = findById(id);
        smartphoneRepository.delete(findById(id));
        return smartphone;
    }

}
