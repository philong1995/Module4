package com.codegym.service.Impl.employee;

import com.codegym.entity.employee.Position;
import com.codegym.repository.employee.PositionRepository;
import com.codegym.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return this.positionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        this.positionRepository.save(position);
    }

    @Override
    public void delete(Integer id) {
        this.positionRepository.deleteById(id);
    }
}
