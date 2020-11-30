package com.example.service.impl;

import com.example.entity.Province;
import com.example.repository.ProvinceRepository;
import com.example.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return this.provinceRepository.findAll();
    }

    @Override
    public Province findById(Integer id) {
        return this.provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        this.provinceRepository.save(province);
    }

    @Override
    public void remove(Integer id) {
        this.provinceRepository.deleteById(id);
    }
}
