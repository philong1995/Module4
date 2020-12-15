package com.codegym.service.customer;

import com.codegym.entity.customer.CustomerType;
import com.codegym.entity.employee.Division;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
    CustomerType findById(Integer id);
    void save(CustomerType customerType);
    void delete(Integer id);
}
