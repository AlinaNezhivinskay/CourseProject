package com.senla.educationsystem.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.educationsystem.api.dao.genericdao.GenericDAO;
import com.senla.educationsystem.model.bean.Lecture;

public interface ILetureDAO extends GenericDAO<Lecture> {
	List<Lecture> getLecturesByCourse(Session session, Integer courseId) throws Exception;
}
