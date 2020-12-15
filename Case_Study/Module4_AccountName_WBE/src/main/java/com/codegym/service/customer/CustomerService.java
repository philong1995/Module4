package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Integer id);
    void save(Customer customer);
    void delete(Integer id);
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> searchCustomerByName(String keyword,Pageable pageable);
}
