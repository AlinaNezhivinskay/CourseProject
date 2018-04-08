package com.senla.educationsystem.api.dao;

import org.hibernate.Session;

import com.senla.educationsystem.api.dao.genericdao.GenericDAO;
import com.senla.educationsystem.model.bean.User;

public interface IUserDAO extends GenericDAO<User> {
	User getUserByLogin(Session session, String login);
}
