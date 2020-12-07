package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void delete(int id);
}
