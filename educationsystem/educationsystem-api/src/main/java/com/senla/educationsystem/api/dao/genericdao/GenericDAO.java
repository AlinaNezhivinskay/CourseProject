package com.senla.educationsystem.api.dao.genericdao;

import java.util.List;

import org.hibernate.Session;

public interface GenericDAO<T> {
	boolean create(Session session, T object) throws Exception;

	T read(Class<T> type, Session session, Integer key) throws Exception;

	boolean update(Session session, T object) throws Exception;

	boolean saveOrUpdate(Session session, T object) throws Exception;

	boolean delete(Session session, T object) throws Exception;

	List<T> getAll(Class<T> type, Session session) throws Exception;
}
