package com.codegym.repository.impl;

import com.codegym.entity.Student;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select s from student s", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    public Student findById(Integer id) {
//        TypedQuery<Student> typedQuery =
//                BaseRepository.entityManager.createQuery(
//                        "select s from student s where s.id = :idStudent", Student.class);
//        typedQuery.setParameter("idStudent", id);

//        TypedQuery<Student> typedQuery2 =
//                BaseRepository.entityManager.createQuery(
//                        "select s from student s where s.id = ?1", Student.class);
//        typedQuery2.setParameter(1, id);

//        return typedQuery.getSingleResult();
        return BaseRepository.entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }
}
