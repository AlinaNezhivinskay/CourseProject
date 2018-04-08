package com.senla.educationsystem.api.service;

import java.util.List;

import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.model.bean.UserInfo;

public interface IUserService {

	boolean addUser(User user) throws Exception;

	boolean removeUser(User user) throws Exception;

	boolean updateUser(User user) throws Exception;

	List<User> getAllUsers() throws Exception;

	User getUserById(Integer id) throws Exception;

	User getUserByLogin(String login) throws Exception;

	boolean addUserIfo(User user, UserInfo info) throws Exception;
}
