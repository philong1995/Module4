package com.codegym.service.Impl.employee;

import com.codegym.entity.employee.EducationDegree;
import com.codegym.repository.employee.EducationDegreeRepository;
import com.codegym.service.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.educationDegreeRepository.findAll();
    }

    @Override
    public EducationDegree findById(Integer id) {
        return this.educationDegreeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {
        this.educationDegreeRepository.save(educationDegree);
    }

    @Override
    public void delete(Integer id) {
        this.educationDegreeRepository.deleteById(id);
    }
}
