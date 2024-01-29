package com.backend.crud;

import com.backend.crud.dao.StudentDAO;
import com.backend.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			createStudent(studentDAO);
		};
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

}
