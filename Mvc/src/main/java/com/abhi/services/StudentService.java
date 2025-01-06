package com.abhi.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abhi.model.Student;

@Repository
public class StudentService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Student> getAllStudents() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Student", Student.class).getResultList();
	}

	public void addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}

	public Student getStudentById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Student.class, id);
	}

	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
	}

	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = session.get(Student.class, id);
		if (student != null) {
			session.delete(student);
		}
	}
}
