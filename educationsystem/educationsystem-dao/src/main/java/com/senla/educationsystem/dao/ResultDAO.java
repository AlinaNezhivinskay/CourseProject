package com.senla.educationsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.IResultDAO;
import com.senla.educationsystem.model.bean.Course_;
import com.senla.educationsystem.model.bean.Result;
import com.senla.educationsystem.model.bean.Result_;
import com.senla.educationsystem.model.bean.User_;

@Repository
public class ResultDAO extends AbstractDAO<Result> implements IResultDAO {

	public List<Result> getResultsByStudent(Session session, Integer studentId) throws Exception {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Result> criteriaQuery = cb.createQuery(Result.class);
		Root<Result> root = criteriaQuery.from(Result.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Result_.student).get(User_.id), studentId));
		return session.createQuery(criteriaQuery).getResultList();
	}

	public List<Result> getResultsByCourse(Session session, Integer courseId) throws Exception {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Result> criteriaQuery = cb.createQuery(Result.class);
		Root<Result> root = criteriaQuery.from(Result.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Result_.course).get(Course_.id), courseId));
		return session.createQuery(criteriaQuery).getResultList();
	}

}
