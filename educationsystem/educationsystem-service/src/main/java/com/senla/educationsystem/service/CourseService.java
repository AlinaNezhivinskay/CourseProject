package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.ICourseDAO;
import com.senla.educationsystem.api.service.ICourseService;
import com.senla.educationsystem.model.bean.Course;

@Service
public class CourseService implements ICourseService {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ICourseDAO courseDAO;

	@Transactional
	public synchronized boolean addCourse(Course course) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = courseDAO.create(session, course);
		return result;
	}

	@Transactional
	public synchronized boolean removeCourse(Course course) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = courseDAO.delete(session, course);
		return result;
	}

	@Transactional
	public synchronized boolean updateCourse(Course course) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = courseDAO.update(session, course);
		return result;
	}

	@Transactional
	public List<Course> getAllCourses() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Course> courses = courseDAO.getAll(Course.class, session);
		return courses;
	}

	@Transactional
	public Course getCourseById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Course course = courseDAO.read(Course.class, session, id);
		return course;
	}

	@Transactional
	public List<Course> getCoursesByLecturer(Integer lecturerId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Course> courses = courseDAO.getCoursesByLecturer(session, lecturerId);
		return courses;
	}

}
