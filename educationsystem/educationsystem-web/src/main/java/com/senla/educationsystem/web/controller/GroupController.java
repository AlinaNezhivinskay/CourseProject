package com.senla.educationsystem.web.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.IGroupService;
import com.senla.educationsystem.model.bean.Group;

@RestController
@RequestMapping("/group")
public class GroupController {

	private static Logger log = Logger.getLogger(GroupController.class.getName());

	@Autowired
	private IGroupService groupService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public boolean newUser(@RequestBody Group group) {
		boolean answer = false;
		try {
			answer = groupService.addGroup(group);
		} catch (Exception e) {
			log.error(e);
		}
		return answer;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Group> getUsers() {
		List<Group> answer = null;
		try {
			answer = groupService.getAllGroups();
		} catch (Exception e) {
			log.error(e);
		}
		return answer;
	}

}
