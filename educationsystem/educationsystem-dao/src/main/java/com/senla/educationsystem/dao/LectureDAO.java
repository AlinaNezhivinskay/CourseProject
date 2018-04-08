package com.senla.educationsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.ILetureDAO;
import com.senla.educationsystem.model.bean.Course_;
import com.senla.educationsystem.model.bean.Lecture;
import com.senla.educationsystem.model.bean.Lecture_;

@Repository
public class LectureDAO extends AbstractDAO<Lecture> implements ILetureDAO {

	public List<Lecture> getLecturesByCourse(Session session, Integer courseId) throws Exception {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Lecture> criteriaQuery = cb.createQuery(Lecture.class);
		Root<Lecture> root = criteriaQuery.from(Lecture.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Lecture_.course).get(Course_.id), courseId));
		return session.createQuery(criteriaQuery).getResultList();
	}
}
