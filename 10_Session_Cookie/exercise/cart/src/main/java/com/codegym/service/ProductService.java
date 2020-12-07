package com.codegym.service;

import com.codegym.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void delete(int id);

    Page<Product> findAll(Pageable pageable);

    Page<Product> searchProductByName(String keyword,Pageable pageable);
}
