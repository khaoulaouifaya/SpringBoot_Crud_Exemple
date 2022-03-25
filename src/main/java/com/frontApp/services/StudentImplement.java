package com.frontApp.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontApp.dao.studentRepo;
import com.frontApp.models.Student;

@Service
public class StudentImplement implements IstudentService{

	@Autowired
	studentRepo dao;
	
	
	@Transactional
	public Student saveStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.save(s);
	}

	@Transactional
	public Student updateStudent(long id) {
		// TODO Auto-generated method stub
		Student s=dao.findById(id).get();
		s.setNom(s.getNom());
		s.setPrenom(s.getPrenom());
		return dao.save(s);
	}

	@Transactional
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Transactional
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		 List<Student>ls=(List<Student>) dao.findAll();
		return ls;
	}

	@Transactional
	public Student getOne(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

}
