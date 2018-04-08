package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.ILessonTimeDAO;
import com.senla.educationsystem.api.service.ILessonTimeService;
import com.senla.educationsystem.model.bean.LessonTime;

@Service
public class LessonTimeService implements ILessonTimeService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ILessonTimeDAO lessonTimeDAO;

	@Transactional
	public synchronized boolean addLessonTime(LessonTime time) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lessonTimeDAO.create(session, time);
		return result;
	}

	@Transactional
	public synchronized boolean removeLessonTime(LessonTime time) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lessonTimeDAO.delete(session, time);
		return result;
	}

	@Transactional
	public synchronized boolean updateLessonTime(LessonTime time) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = lessonTimeDAO.update(session, time);
		return result;
	}

	@Transactional
	public List<LessonTime> getAllLessonTimes() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<LessonTime> times = lessonTimeDAO.getAll(LessonTime.class, session);
		return times;
	}

	@Transactional
	public LessonTime getLessonTimeById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		LessonTime lessonTime = lessonTimeDAO.read(LessonTime.class, session, id);
		return lessonTime;
	}

}
