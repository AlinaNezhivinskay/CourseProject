package com.senla.educationsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.ILessonDAO;
import com.senla.educationsystem.model.bean.Course;
import com.senla.educationsystem.model.bean.Course_;
import com.senla.educationsystem.model.bean.Lecture;
import com.senla.educationsystem.model.bean.Lecture_;
import com.senla.educationsystem.model.bean.Lesson;
import com.senla.educationsystem.model.bean.Lesson_;

@Repository
public class LessonDAO extends AbstractDAO<Lesson> implements ILessonDAO {

	public List<Lesson> getLessonsByCourse(Session session, Integer courseid) throws Exception {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Lesson> criteriaQuery = cb.createQuery(Lesson.class);
		Root<Lesson> lessonRoot = criteriaQuery.from(Lesson.class);
		Root<Lecture> lectureRoot = criteriaQuery.from(Lecture.class);
		Root<Course> courseRoot = criteriaQuery.from(Course.class);
		criteriaQuery.select(lessonRoot);
		criteriaQuery.where(cb.equal(lessonRoot.get(Lesson_.lecture).get(Lecture_.id), lectureRoot.get(Lecture_.id)));
		criteriaQuery.where(cb.equal(lectureRoot.get(Lecture_.course).get(Course_.id), courseRoot.get(Course_.id)));
		criteriaQuery.where(cb.equal(courseRoot.get(Course_.id), courseid));
		return session.createQuery(criteriaQuery).getResultList();
	}

	public List<Lesson> getLessonsByLecture(Session session, Integer lectureId) throws Exception {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Lesson> criteriaQuery = cb.createQuery(Lesson.class);
		Root<Lesson> root = criteriaQuery.from(Lesson.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(Lesson_.lecture).get(Lecture_.id), lectureId));
		return session.createQuery(criteriaQuery).getResultList();
	}

}
