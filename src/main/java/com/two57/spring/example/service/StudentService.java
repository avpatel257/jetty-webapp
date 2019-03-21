package com.two57.spring.example.service;

import com.two57.spring.example.exceptions.ResourceAlreadyExistsException;
import com.two57.spring.example.model.Student;

import java.util.List;

public interface StudentService {
	List<Student> findAll();

	Student find(String id);
	
	boolean exists(String id);
	
	Student save(Student student) throws ResourceAlreadyExistsException;
	
	Student update(String id, Student newStudent);
	
	void delete(Student student);
}
