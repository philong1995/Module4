package com.codegym.repository;

import com.codegym.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
