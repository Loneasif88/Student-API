package com.student.api.Student.API.repository;
import com.student.api.Student.API.model.Student; //importing the student class
import java.util.HashMap;

import org.springframework.stereotype.Repository;

// @Repository annotation tells the springboot that this is a Repository layer
@Repository	 
public class StudentRepository {
	
	// repository contains the operation realtad to database
	
	// right now we are creating an hashmap ds for db to store 
	// STUDENTID VS STUDENT OBJECT
	
	HashMap<String, Student> studentDB = new HashMap<>();    
	// now i want to create another hashmap for storing id and marks
	HashMap<String, Integer>  studentMarks = new HashMap<>();
	
	public void saveStudent(Student std) {
		System.out.println("Request Recieved Repository layer");
		String id =  std.getId();
		// save into the database (hashmap)
		System.out.println("Adding student object into repository layer");
		studentDB.put(id, std);
		// student got inserted into hmap
		//printing the hashmap
		System.out.println(studentDB);
		System.out.println("Student got inserted into the db");
	}
	public Student getStudentById(String id) {
		return studentDB.get(id);
	}
	
	public Student updateStudentById(String id,Student std) {
		if(!studentDB.containsKey(id)) {
			return null;
		}
		studentDB.put(id,std);
		System.out.println(studentDB);
		return studentDB.get(id);
	}
	
	// Method for getting the marks of a student
	public Integer getMarksById(String id) {
		return studentMarks.get(id);
	}
	//Method for updating the marks
	public void updateStudentMarks(String id, int marks) {
		studentMarks.put(id, marks);
	}
	
	
}
