package com.student.api.Student.API.controller;
import com.student.api.Student.API.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.api.Student.API.service.ExamService;
import com.student.api.Student.API.service.StudentService;

@RestController
public class StudentController {
	// 1. if we are creating controller then we need to tell the springboot that this is a controller class.
	// by using @RestController annotation to let springboot know this is a controller class.
	
	// 2. how can we create end points (url) for that we need create a function to run on that endPoint
	//by creating this function as endpoint of some url we use annotations @GETMapping because we are bringing the data so its GET method
	
	// to use postMappint or PUTMapping we need to create connection between  controller layer and Service Layer
	// her we are creating an object of Service layer
	@Autowired
	// by using Autowired spring boot is going to handle the objects by itself 
	// its called IOC (inversioin of controll) 
	// by using the it we are not creating the object by over-selves . Spring boot is going to control the objects
	StudentService studentService;
	
	// Inject dependency of Exam service call into Student Controller class
	@Autowired
	ExamService examService;
	
	
	@GetMapping("student/details")
	public String getStudentsDetails() {
		return "Welcome Ramadan";
	}
	
	//@PUtMapping annotations is used to upload the data to the server
	@PutMapping("student/upload")  //while hitting the end point we need to send the data of the student to the service layer
	
	// we need to pass data to the student object into JSON Format from postman 
	// spring boot will convert it into java object
	// and we need to tell this fuction that your need to catch the data from request body(JSON) by @RequestBody
	public String putStudentsDetails(@RequestBody Student student) {
		System.out.println("Requested Recieved from controller layer");
		studentService.saveStudent(student);
		//System.out.println("Student got saved ")
		
		return "Student got Saved:";
	}
	
	// now we want to pass student id in the url 
	@GetMapping("/student/detail")
	public Student getStudentDetailsById(@RequestParam String id) {
		return studentService.getStudentById(id);   
		// from backend this id is converted into java format 
		// and then it matches the student in the database
		// and converts the student details into json format 
	}
	
	@PutMapping("student/detail/update")
	public Student updateStudentDetailsById(@RequestParam String id, @RequestBody Student std) {
		return studentService.updateStudentById(id, std);
	}
	
	@GetMapping("/student/marks")
	public Integer getStudentMarks(@RequestParam String id) {
		return examService.getMarksById(id);
	}
	
	// PutMapping for Updating the Marks
	@PutMapping("student/update/marks")
	public void updateStudentMarks(@RequestParam String id, @RequestParam int marks) {
		// call the Exam service method
		examService.updateStudentMarks(id, marks);
	}
	
	
}
