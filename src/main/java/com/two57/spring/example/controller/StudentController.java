package com.two57.spring.example.controller;

import com.two57.spring.example.model.Student;
import com.two57.spring.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "api/students")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Student> getStudents() throws InterruptedException {
        LOGGER.info("/students [GET]");
        return studentService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Student getStudentsById(@PathVariable(value="id") String id) {
    	LOGGER.info("/students/{} [GET]", id);
    	return this.studentService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.CREATED)
    public Student createStudent(@RequestBody @Valid Student student) {
    	LOGGER.info("/students [POST]: {}", student);
    	
		return this.studentService.save(student);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Student updateStudent(@PathVariable(value="id") String id, @RequestBody @Valid Student student) {
    	LOGGER.info("/students/{} [PUT] {}", id, student);
    	
		return this.studentService.update(id, student);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteStudentsById(@PathVariable(value="id") String id) {
    	LOGGER.info("/students/{} [DELETE]", id);
    	Student student = this.studentService.find(id);
    	this.studentService.delete(student);
    }

}
