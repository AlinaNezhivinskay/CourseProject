package com.senla.educationsystem.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.educationsystem.api.dao.genericdao.GenericDAO;
import com.senla.educationsystem.model.bean.Lesson;

public interface ILessonDAO extends GenericDAO<Lesson> {

	List<Lesson> getLessonsByCourse(Session session, Integer courseid) throws Exception;

	List<Lesson> getLessonsByLecture(Session session, Integer lectureId) throws Exception;
}
