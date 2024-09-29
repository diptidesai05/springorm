package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;


public class StudentDaoImpl implements StudentDao {
	
	private HibernateTemplate hibernateTemplate;

	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}


	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	@Override
	@Transactional
	public int insert(Student student) {
		
		Integer i=(Integer)hibernateTemplate.save(student);
		//System.out.println("in studentDaoImpl i "+i);
		return i;
	}


	@Override
	public Student getStudent(int studentId) {
		
		Student stud = hibernateTemplate.get(Student.class, studentId);
		return stud;
	}


	@Override
	public List<Student> getAllStudents() {
		
		List<Student> studlist=hibernateTemplate.loadAll(Student.class);
		
		return studlist;
	}


	@Override
	@Transactional
	public void delete(Student student) {
		
		Student stud=hibernateTemplate.get(Student.class, student.getStudentId());
		hibernateTemplate.delete(stud);
		
	}

	@Override
	@Transactional
	public void update(Student student) {
		
		hibernateTemplate.update(student);
		
	}


	@Override
	@Transactional
	public void deleteAll() {
		
		List<Student> studlist=hibernateTemplate.loadAll(Student.class);
		hibernateTemplate.deleteAll(studlist);
	}
	

}
