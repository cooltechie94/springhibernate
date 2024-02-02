package com.backend.crud;

import com.backend.crud.dao.StudentDAO;
import com.backend.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;
import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			readStudent(studentDAO);
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			queryForUpdatingStudent(studentDAO);
			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);

		};
	}
	private void readStudent(StudentDAO studentDAO) {

		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}
	private void createStudent(StudentDAO studentDAO) {
//		create student object
		System.out.println("Creating new student object");
		Student student = new Student("Jurgen","Klopp","piyush.prasad94@gmail.com");
//		Save student object
		studentDAO.save(student);
		System.out.println("Saving student object");
//		display ID of saved student
		System.out.println("Student's generated ID: "+ student.getId());
		System.out.println("Student's generated Name: "+ student.getFirstName() + student.getLastName());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		create student object
		System.out.println("Creating multiple student object");
		Student student1 = new Student("Virgil","van Dijk","virgil@liverpool.com");
		Student student2 = new Student("Trent","Arnold","trent@liverpool.com");
		Student student3 = new Student("Alisson","Becker","alisson@liverpool.com");

		//		Save student object
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}
	private void queryForStudents(StudentDAO studentDAO){
//		Get  a list of students
		List<Student> studentsList = studentDAO.findAll();
//		Display students
		for(Student student :studentsList){
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){
//		Get  a list of students
		List<Student> studentsList = studentDAO.findByLastName("Becker");
//		Display students
		for(Student student :studentsList){
			System.out.println(student);
		}
	}

	private void queryForUpdatingStudent(StudentDAO studentDAO){
//		Retrieve students based on ID: Primary key
		int studentId = 4;
		System.out.println("Student with ID as : "+studentId);
		Student myStudent = studentDAO.findById(studentId);
//		Change First Name to Scooby
		myStudent.setFirstName("Scooby");
//		Update the student
		studentDAO.update(myStudent);
//		Display the updated student
		System.out.println(myStudent);

	}

	private void deleteStudent(StudentDAO studentDAO){
//		Retrieve students based on ID: Primary key
		int studentId = 4;
		System.out.println("Student with ID as : "+studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted student with ID of  "+studentId);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students");

		int numberOfStudentRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number Of Student Rows Deleted : "+ numberOfStudentRowsDeleted);
	}

}
