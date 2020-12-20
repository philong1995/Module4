package com.codegym.repository;

import com.codegym.entity.INote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INoteRepository extends JpaRepository<INote,Integer> {
    Page<INote> findAllByTittleContaining(String keyword, Pageable pageable);
}
