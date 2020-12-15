package com.codegym.service.Impl.customer;

import com.codegym.entity.customer.CustomerType;
import com.codegym.repository.customer.CustomerTypeRepository;
import com.codegym.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return this.customerTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {
        this.customerTypeRepository.save(customerType);
    }

    @Override
    public void delete(Integer id) {
        this.customerTypeRepository.deleteById(id);
    }
}
