package com.codegym.repository;

import com.codegym.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    Page<Province> findProvinceByNameProvinceContaining(String keyword, Pageable pageable);
}
