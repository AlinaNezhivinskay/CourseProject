package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.ILessonDAO;
import com.senla.educationsystem.api.service.ILessonService;
import com.senla.educationsystem.model.bean.Group;
import com.senla.educationsystem.model.bean.Lesson;

@Service
public class LessonService implements ILessonService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ILessonDAO lessonDAO;

	@Transactional
	public synchronized boolean addLesson(Lesson lesson) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lessonDAO.create(session, lesson);
		return result;
	}

	@Transactional
	public synchronized boolean removeLesson(Lesson lesson) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lessonDAO.delete(session, lesson);
		return result;
	}

	@Transactional
	public synchronized boolean updateLesson(Lesson lesson) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lessonDAO.update(session, lesson);
		return result;
	}

	@Transactional
	public List<Lesson> getAllLessons() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Lesson> lessons = lessonDAO.getAll(Lesson.class, session);
		return lessons;
	}

	@Transactional
	public Lesson getLessonById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Lesson lesson = lessonDAO.read(Lesson.class, session, id);
		return lesson;
	}

	@Transactional
	public List<Lesson> getLessonsByCourse(Integer courseId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Lesson> lessons = lessonDAO.getLessonsByCourse(session, courseId);
		return lessons;
	}

	@Transactional
	public List<Lesson> getLessonsByLecture(Integer lectureId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Lesson> lessons = lessonDAO.getLessonsByLecture(session, lectureId);
		return lessons;
	}

	@Transactional
	public boolean addGroupToLesson(Lesson lesson, Group group) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		if (lesson != null && group != null) {
			lesson.addGroup(group);
			lessonDAO.update(session, lesson);
		}
		boolean result = lessonDAO.update(session, lesson);
		return result;
	}

}
