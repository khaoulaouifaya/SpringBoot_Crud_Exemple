package com.frontApp.services;

import java.util.List;

import com.frontApp.models.Student;

public interface IstudentService {

	
	Student saveStudent(Student s);
	Student updateStudent(long id);
	void deleteStudent(long id);
	List<Student> getStudents();
	Student getOne(long id);
	
}
