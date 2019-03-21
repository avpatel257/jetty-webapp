package com.two57.spring.example.service;

import com.two57.spring.example.exceptions.ResourceAlreadyExistsException;
import com.two57.spring.example.model.Course;

import java.util.List;

public interface CourseService {
	List<Course> findAll();

	Course find(Integer id);
	
	boolean exists(Integer id);
	
	Course save(Course course) throws ResourceAlreadyExistsException;
	
	Course update(Integer id, Course newCourse);
	
	void delete(Course course);
}
