package com.codegym.service.Impl.employee;

import com.codegym.entity.employee.Division;
import com.codegym.repository.employee.DivisionRepository;
import com.codegym.service.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }

    @Override
    public Division findById(Integer id) {
        return this.divisionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {
        this.divisionRepository.save(division);
    }

    @Override
    public void delete(Integer id) {
        this.divisionRepository.deleteById(id);
    }
}
