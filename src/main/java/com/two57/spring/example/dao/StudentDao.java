package com.two57.spring.example.dao;

import com.two57.spring.example.model.Student;

import java.util.List;

public interface StudentDao {

	List<Student> findAll();
	
	Student find(String id);
	
	Student save(Student student);
	
	Student update(String id, Student newStudent);
	
	void delete(Student student);
	
	void deleteById(String id);
}
