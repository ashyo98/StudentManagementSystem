package com.example.student.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.student.model.Student;

@Component
public interface UserRepository extends CrudRepository<Student, Integer> {

}
