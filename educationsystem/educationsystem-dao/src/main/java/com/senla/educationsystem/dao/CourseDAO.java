package com.senla.educationsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.ICourseDAO;
import com.senla.educationsystem.model.bean.Course;
import com.senla.educationsystem.model.bean.Course_;
import com.senla.educationsystem.model.bean.User_;

@Repository
public class CourseDAO extends AbstractDAO<Course> implements ICourseDAO {

	public List<Course> getCoursesByLecturer(Session session, Integer lecturerId) throws Exception {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);
		Root<Course> root = criteriaQuery.from(Course.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Course_.lecturer).get(User_.id), lecturerId));
		return session.createQuery(criteriaQuery).getResultList();
	}

}
