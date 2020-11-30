package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Province;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    Province findById(Integer id);
    void save(Province province);
    void remove(Integer id);
}
