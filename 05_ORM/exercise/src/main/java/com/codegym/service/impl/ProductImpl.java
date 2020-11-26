package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Samsung Galaxy Note10+", 17000000, 10, "Full phụ kiện", "Samsung"));
        products.put(2, new Product(2, "Iphone 11 Pro Max", 27000000, 10, "Full phụ kiện", "Apple"));
        products.put(3, new Product(3, "Xiaomi Readmi Note 7", 7000000, 10, "Full phụ kiện", "Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getIdProduct(),product);

    }

    @Override
    public Product findByID(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
