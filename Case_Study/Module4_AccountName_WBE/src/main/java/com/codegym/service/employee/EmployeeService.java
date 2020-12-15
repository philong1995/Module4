package com.codegym.service.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    void save(Employee employee);
    void delete(Integer id);
    Page<Employee> findAll(Pageable pageable);
    Page<Employee> searchEmployeeByName(String keyword,Pageable pageable);
}
