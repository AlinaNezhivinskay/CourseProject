package com.senla.educationsystem.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.educationsystem.api.dao.IGroupDAO;
import com.senla.educationsystem.api.service.IGroupService;
import com.senla.educationsystem.model.bean.Group;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private IGroupDAO groupDAO;

	@Transactional
	public synchronized boolean addGroup(Group group) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = groupDAO.create(session, group);
		return result;
	}

	@Transactional
	public synchronized boolean removeGroup(Group group) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = groupDAO.delete(session, group);
		return result;
	}

	@Transactional
	public synchronized boolean updateGroup(Group group) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		boolean result = groupDAO.update(session, group);
		return result;
	}

	@Transactional
	public List<Group> getAllGroups() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Group> groups = groupDAO.getAll(Group.class, session);
		return groups;
	}

	@Transactional
	public Group getGroupById(Integer id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Group group = groupDAO.read(Group.class, session, id);
		return group;
	}

}
