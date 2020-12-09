package com.codegym.service;

import com.codegym.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();

    Province findById(Integer id);

    void save(Province province);

    void delete(Integer id);

    Page<Province> findAll(Pageable pageable);

    Page<Province> searchProvince(String keyword, Pageable pageable);
}
