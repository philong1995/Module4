package com.codegym.repository;

import com.codegym.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    // select *
    // from student
    // where name like '%abc%'
    List<Student> findByNameContaining(String abc);

    // select *
    // from student
    // where name like '%name%' and gender like %gender%
    List<Student> findByNameContainingAndGenderContaining(String name, String gender);

    @Query(value = "select * from student where gender = ?", nativeQuery = true)
    List<Student> getAllByGender(String abc);

}
