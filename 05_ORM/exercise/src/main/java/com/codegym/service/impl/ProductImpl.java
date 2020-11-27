package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);

    }

    @Override
    public Product findByID(int id) {
        return this.productRepository.findByID(id);
    }

    @Override
    public void update(int id, Product product) {
        this.productRepository.update(id,product);
    }

    @Override
    public void remove(int id) {
        this.productRepository.remove(id);
    }
}
