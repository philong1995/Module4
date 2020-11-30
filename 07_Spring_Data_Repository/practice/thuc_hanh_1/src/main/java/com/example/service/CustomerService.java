package com.example.service;

import com.example.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void save(Customer customer);
    void remove(Integer id);
    Page<Customer> searchCustomerByName(String keyword, Pageable pageable);
}
