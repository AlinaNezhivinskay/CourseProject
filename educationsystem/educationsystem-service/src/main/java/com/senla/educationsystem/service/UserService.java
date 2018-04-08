package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.IUserDAO;
import com.senla.educationsystem.api.dao.IUserInfoDAO;
import com.senla.educationsystem.api.service.IUserService;
import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.model.bean.UserInfo;

@Service
public class UserService implements IUserService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserInfoDAO userInfoDAO;

	@Transactional
	public synchronized boolean addUser(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		if (user != null) {
			UserInfo userInfo = user.getInfo();
			if (userInfo != null) {
				userInfoDAO.create(session, userInfo);
			}
		}
		boolean result = userDAO.create(session, user);
		return result;
	}

	@Transactional
	public synchronized boolean removeUser(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = userDAO.delete(session, user);
		return result;
	}

	@Transactional
	public boolean updateUser(User user) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = userDAO.update(session, user);
		return result;
	}

	@Transactional
	public List<User> getAllUsers() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = userDAO.getAll(User.class, session);
		return users;
	}

	@Transactional
	public User getUserById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		User user = userDAO.read(User.class, session, id);
		return user;
	}

	@Transactional
	public User getUserByLogin(String login) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		User user = userDAO.getUserByLogin(session, login);
		return user;
	}

	@Transactional
	public synchronized boolean addUserIfo(User user, UserInfo info) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		if (user != null && info != null) {
			userInfoDAO.create(session, info);
			user.setInfo(info);
		}
		boolean result = userDAO.update(session, user);
		return result;
	}

}
