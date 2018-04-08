package com.senla.educationsystem.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.senla.educationsystem.api.dao.IUserDAO;
import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.model.bean.User_;

@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	public User getUserByLogin(Session session, String login) {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = cb.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(root);
		criteriaQuery.where(cb.equal(root.get(User_.login), login));
		return session.createQuery(criteriaQuery).getSingleResult();
	}

}
