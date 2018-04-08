package com.senla.educationsystem.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.IUserService;
import com.senla.educationsystem.model.bean.User;

@RestController
@RequestMapping("/user")
public class UserController {

	private static Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public boolean addUser(@RequestBody User user) {
		boolean result = false;
		try {
			if (user != null) {
				result = userService.addUser(user);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> answer = null;
		try {
			answer = userService.getAllUsers();
		} catch (Exception e) {
			log.error(e);
		}
		return answer;
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public User getUser(@RequestParam String login) {
		User answer = null;
		try {
			answer = userService.getUserByLogin(login);
		} catch (Exception e) {
			log.error(e);
		}
		return answer;
	}

}
