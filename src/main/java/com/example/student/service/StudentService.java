package com.example.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.student.dao.UserRepository;
import com.example.student.model.Student;

@Component
public class StudentService {

	@Autowired
	private UserRepository userRepository;
	
	private List<Student> students;
	
	public StudentService(UserRepository userRepository) {
		this.userRepository = userRepository;
		students = new ArrayList<Student>();
	    Iterable<Student> iter = this.userRepository.findAll();
	    for (Student student : iter) 
	    	students.add(student);
		
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		userRepository.save(student);
		students.add(student);
	}
	
	public Student getStudent(String name) {
		for (Student student : students) 
			if (student.getName().startsWith(name))
				return student;
		return null;
	}
	
	public void updateStudent(int id, Student student) {
		for (Student stud : students) 
			if (stud.getId() == id) {
				stud.setAddress(student.getAddress());
				stud.setDob(student.getDob());
				stud.setId(student.getId());
				stud.setName(student.getName());
				userRepository.save(stud);
			}
	}
	
	public void deleteStudent(int id) {
		for ( Student student : students) {
			if (student.getId() == id) {
				students.remove(student);
				userRepository.delete(student);
			}
		}
	}
	
}
