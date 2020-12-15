package com.codegym.service.employee;

import com.codegym.entity.employee.Position;

import java.util.List;

public interface PositionService{
    List<Position> findAll();
    Position findById(Integer id);
    void save(Position position);
    void delete(Integer id);
}
