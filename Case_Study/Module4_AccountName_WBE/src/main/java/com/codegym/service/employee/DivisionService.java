package com.codegym.service.employee;

import com.codegym.entity.employee.Division;

import java.util.List;

public interface DivisionService {
    List<Division> findAll();
    Division findById(Integer id);
    void save(Division division);
    void delete(Integer id);
}
