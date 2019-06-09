package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/students", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public List<Student> getAllStudents() {		
		return studentService.getStudents();
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public Student addStudent(@RequestBody Student student) {		
		studentService.addStudent(student);
		return student;
	}
	
	@RequestMapping(value = "/students/{studentid}", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
	public Student updateStudent(@PathVariable("studentid") int id, @RequestBody Student student) {		
		studentService.updateStudent(id, student);
		return student;
	}
	
	@RequestMapping(value = "/students/{studentid}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
	public String deleteStudent(@PathVariable("studentid") int id) {		
		studentService.deleteStudent(id);
		return "\"status\":deleted";
	}
	
	@RequestMapping(value = "/students/{studentname}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public Student getStudent(@PathVariable("studentname") String name) {		
		Student student = studentService.getStudent(name);
		  return student;
	}

}
