package com.senla.educationsystem.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.IUserInfoDAO;
import com.senla.educationsystem.api.service.IUserInfoService;
import com.senla.educationsystem.model.bean.UserInfo;

@Service
public class UserInfoService implements IUserInfoService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IUserInfoDAO userInfoDAO;

	@Transactional
	public synchronized boolean updateUserInfo(UserInfo userInfo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = userInfoDAO.update(session, userInfo);
		return result;
	}

}
