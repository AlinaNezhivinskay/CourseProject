package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.Group;

public interface IGroupService {
	boolean addGroup(Group group) throws Exception;

	boolean removeGroup(Group group) throws Exception;

	boolean updateGroup(Group group) throws Exception;

	List<Group> getAllGroups() throws Exception;

	Group getGroupById(Integer id) throws Exception;

}
