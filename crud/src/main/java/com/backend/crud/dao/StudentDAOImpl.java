package com.backend.crud.dao;

import java.util.List;
import com.backend.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    //    implement save()
    @Transactional // used since we perform a transaction, in this case an update
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent); //saves the student to DB
    }

    @Override
    public List<Student> findAll(){
//        create a query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student order by lastName desc", Student.class);
//        return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName){
//        create a query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:lastNameParameter", Student.class);
//        Set query parameters
        theQuery.setParameter("lastNameParameter", theLastName );
//        return query results
        return theQuery.getResultList();
    }



    @Override
    @Transactional
    public void update(Student theStudent){
//        Update the student
        entityManager.merge(theStudent);
    }


    @Override
    @Transactional
    public void delete(Integer studentId){
//      Retrieve student
        Student theStudent = entityManager.find(Student.class, studentId);
//      Delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll(){
        int numRowsDeleted = entityManager.createQuery("" +
                "DELETE FROM Student")
                .executeUpdate();
        return numRowsDeleted;
    }
}
