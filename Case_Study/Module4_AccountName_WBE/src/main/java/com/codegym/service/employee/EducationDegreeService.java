package com.codegym.service.employee;

import com.codegym.entity.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAll();
    EducationDegree findById(Integer id);
    void save(EducationDegree educationDegree);
    void delete(Integer id);
}
