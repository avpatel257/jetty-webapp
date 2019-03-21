package com.two57.spring.example.service.impl;

import com.two57.spring.example.dao.StudentDao;
import com.two57.spring.example.exceptions.ResourceAlreadyExistsException;
import com.two57.spring.example.exceptions.ResourceNotFoundException;
import com.two57.spring.example.model.Student;
import com.two57.spring.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao fakeStudentDao;

	@Override
	public List<Student> findAll() {
		return fakeStudentDao.findAll();
	}

	@Override
	public Student find(String id) {
		Student student = fakeStudentDao.find(id);
		if (student == null) {
			throw new ResourceNotFoundException("Student with id " + id + " not found");
		}
		return student;
	}
	
	@Override
	public boolean exists(String id) {
		return fakeStudentDao.find(id) != null;
	}

	@Override
	public Student save(Student student) throws ResourceAlreadyExistsException {
		if (this.fakeStudentDao.find(student.getId()) != null) {
			throw new ResourceAlreadyExistsException("Student with id " + student.getId() + " already exists");
		}
		
		return this.fakeStudentDao.save(student);
	}

	@Override
	public Student update(String id, Student newStudent) {
    	
    	if (!id.equals(newStudent.getId()) && this.exists(newStudent.getId())) {
    		throw new ResourceAlreadyExistsException("Student with id " + newStudent.getId().toString() + " already exists");
    	}
		
		return this.fakeStudentDao.update(id, newStudent);
	}

	@Override
	public void delete(Student student) {
		this.fakeStudentDao.delete(student);
	}
}
