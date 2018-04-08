package com.senla.educationsystem.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.educationsystem.api.dao.genericdao.GenericDAO;
import com.senla.educationsystem.model.bean.Course;

public interface ICourseDAO extends GenericDAO<Course> {

	List<Course> getCoursesByLecturer(Session session, Integer lecturerId) throws Exception;
}
