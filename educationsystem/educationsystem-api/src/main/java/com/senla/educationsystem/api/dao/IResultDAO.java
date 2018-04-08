package com.senla.educationsystem.api.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.educationsystem.api.dao.genericdao.GenericDAO;
import com.senla.educationsystem.model.bean.Result;

public interface IResultDAO extends GenericDAO<Result> {

	List<Result> getResultsByStudent(Session session, Integer studentId) throws Exception;

	List<Result> getResultsByCourse(Session session, Integer courseId) throws Exception;

}
