package com.senla.educationsystem.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.senla.educationsystem.api.dao.genericdao.GenericDAO;

public class AbstractDAO<T> implements GenericDAO<T> {

	public boolean create(Session session, T object) throws Exception {
		if (object == null) {
			return false;
		}
		session.save(object);
		return true;
	}

	public T read(Class<T> type, Session session, Integer key) throws Exception {
		T object = (T) session.get(type, key);
		return object;
	}

	public boolean update(Session session, T object) throws Exception {
		if (object == null) {
			return false;
		}
		session.update(object);
		return true;
	}

	public boolean saveOrUpdate(Session session, T object) throws Exception {
		if (object == null) {
			return false;
		}
		session.saveOrUpdate(object);
		return true;
	}

	public boolean delete(Session session, T object) throws Exception {
		if (object == null) {
			return false;
		}
		session.delete(object);
		return true;
	}

	public List<T> getAll(Class<T> type, Session session) throws Exception {
		CriteriaBuilder criteriaBulder = session.getCriteriaBuilder();
		CriteriaQuery<T> sriteriaQuery = criteriaBulder.createQuery(type);
		Root<T> root = sriteriaQuery.from(type);
		sriteriaQuery.select(root);
		Query<T> query = session.createQuery(sriteriaQuery);
		return query.getResultList();
	}

}
