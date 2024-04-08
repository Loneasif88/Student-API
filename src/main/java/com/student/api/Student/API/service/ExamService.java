package com.student.api.Student.API.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.api.Student.API.repository.StudentRepository;

@Service
public class ExamService {
	
	
	@Autowired
	StudentRepository studentRepo;
	public Integer getMarksById(String id) {
		return studentRepo.getMarksById(id);
	}
	
	// calling updateMarks of repository layer
	public void updateStudentMarks(String id, int marks) {
		studentRepo.updateStudentMarks(id, marks);
	} 
	// now used Autowired 
	
}
