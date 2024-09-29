package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Student;

public interface StudentDao {
	
	public int insert(Student student);
	public void update(Student student);
	public void delete(Student student);
	public void deleteAll();
	public Student getStudent(int studentId);
	public List<Student> getAllStudents();

}
