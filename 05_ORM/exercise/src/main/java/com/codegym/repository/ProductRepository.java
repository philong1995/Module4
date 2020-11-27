package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    void save(Product product);
    Product findByID(int id);
    void update(int id, Product product);
    void remove(int id);
}
