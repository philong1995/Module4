package com.codegym.repository;

import com.codegym.entity.INoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INoteTypeRepository extends JpaRepository<INoteType,Integer> {
}
