package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.ICourseDAO;
import com.senla.educationsystem.api.dao.ILetureDAO;
import com.senla.educationsystem.api.service.ILectureService;
import com.senla.educationsystem.model.bean.Course;
import com.senla.educationsystem.model.bean.Lecture;

@Service
public class LectureService implements ILectureService {
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ILetureDAO lectureDAO;

	@Autowired
	private ICourseDAO courseDAO;

	@Transactional
	public synchronized boolean addLecture(Lecture lecture) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lectureDAO.create(session, lecture);
		return result;
	}

	@Transactional
	public synchronized boolean removeLecture(Lecture lecture) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lectureDAO.delete(session, lecture);
		return result;
	}

	@Transactional
	public synchronized boolean updateLecture(Lecture lecture) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lectureDAO.update(session, lecture);
		return result;
	}

	@Transactional
	public List<Lecture> getAllLectures() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Lecture> users = lectureDAO.getAll(Lecture.class, session);
		return users;
	}

	@Transactional
	public Lecture getLectureById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Lecture lecture = lectureDAO.read(Lecture.class, session, id);
		return lecture;
	}

	@Transactional
	public List<Lecture> getLecturesByCourse(Integer courseId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Lecture> lectures = lectureDAO.getLecturesByCourse(session, courseId);
		return lectures;
	}

	@Transactional
	public synchronized void addLecturesToCourse(List<Lecture> lectures, Integer courseId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Course course = courseDAO.read(Course.class, session, courseId);
		if (course != null) {
			for (Lecture lecture : lectures) {
				lecture.setCourse(course);
				lectureDAO.create(session, lecture);
			}
		}
	}
}
