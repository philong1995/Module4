package com.codegym.repository;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    List<Customer> findCustomerByFullNameContaining(String name);

    Page<Customer> findCustomerByFullNameContaining(String keyword, Pageable pageable);
}
