package com.frontApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frontApp.models.Student;

@Repository
public interface studentRepo extends CrudRepository<Student, Long>{

}
