package com.student.api.Student.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.api.Student.API.model.Student;
import com.student.api.Student.API.repository.StudentRepository;


// @Service annotation tells the springboot that this is a Service layer
@Service 
public class StudentService {

	// Service layer contians all the business logic.
	// we need to create a connection b/w service layer and repository layer
	// so we created a object of StudentRepository layer class
	@Autowired
	StudentRepository studentRepo;
	
	public void saveStudent(Student std) {
		System.out.println("Student Object Recieved in Service Layer");
		//call repository layer to saveStudent
		studentRepo.saveStudent(std);
		System.out.println("Student got saved into database");
	}
	
	public Student getStudentById(String id) {
		return studentRepo.getStudentById(id);
	}
	// updating the id 
	public Student updateStudentById(String id, Student std) {
		return studentRepo.updateStudentById(id,std);
	}
	
}
