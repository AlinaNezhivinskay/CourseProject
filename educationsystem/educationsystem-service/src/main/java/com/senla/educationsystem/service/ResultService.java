package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.IResultDAO;
import com.senla.educationsystem.api.service.IResultService;
import com.senla.educationsystem.model.bean.Result;

@Service
public class ResultService implements IResultService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IResultDAO resultDAO;

	@Transactional
	public synchronized boolean addResult(Result result) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean dbResult = resultDAO.create(session, result);
		return dbResult;
	}

	@Transactional
	public synchronized boolean removeResult(Result result) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean dbResult = resultDAO.delete(session, result);
		return dbResult;
	}

	@Transactional
	public synchronized boolean updateResult(Result result) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean dbResult = resultDAO.update(session, result);
		return dbResult;
	}

	@Transactional
	public List<Result> getAllResults() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Result> results = resultDAO.getAll(Result.class, session);
		return results;
	}

	@Transactional
	public Result getResultById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Result result = resultDAO.read(Result.class, session, id);
		return result;
	}

	@Transactional
	public List<Result> getResultsByStudent(Integer studentId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Result> results = resultDAO.getResultsByStudent(session, studentId);
		return results;
	}

	@Transactional
	public List<Result> getResultsByCourse(Integer courseId) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Result> results = resultDAO.getResultsByCourse(session, courseId);
		return results;
	}
}
