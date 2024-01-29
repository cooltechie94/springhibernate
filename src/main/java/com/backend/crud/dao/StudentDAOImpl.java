package com.backend.crud.dao;

import com.backend.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repo annotation helps enable component scanning and exception handling
@Repository
public class StudentDAOImpl implements StudentDAO{

//    Define field for entity manager
    private EntityManager entityManager;

//    Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    implement save()
    @Transactional // used since we perform a transaction, in this case an update
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent); //saves the student to DB
    }
}
