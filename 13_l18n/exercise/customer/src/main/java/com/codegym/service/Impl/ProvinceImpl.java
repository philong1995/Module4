package com.codegym.service.Impl;

import com.codegym.entity.Province;
import com.codegym.repository.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

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
    public void delete(Integer id) {
        this.provinceRepository.deleteById(id);
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return this.provinceRepository.findAll(pageable);
    }

    @Override
    public Page<Province> searchProvince(String keyword, Pageable pageable) {
        return this.provinceRepository.findProvinceByNameProvinceContaining(keyword, pageable);
    }
}
