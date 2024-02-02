package com.backend.crud.dao;

import com.backend.crud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    Student findById(Integer id);

    void update(Student theStudent);

    void delete(Integer studentId);

    int deleteAll();

}
