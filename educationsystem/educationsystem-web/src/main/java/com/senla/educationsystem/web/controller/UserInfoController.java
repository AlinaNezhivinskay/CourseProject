package com.senla.educationsystem.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.IUserInfoService;
import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.model.bean.UserInfo;
import com.senla.educationsystem.web.token.TokenRepository;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

	private static Logger log = Logger.getLogger(UserInfoController.class.getName());

	@Autowired
	private IUserInfoService userInfoService;

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public boolean updateUserInfo(@RequestHeader String token, @RequestBody UserInfo userInfo) {
		boolean result = false;
		if (userInfo != null) {
			try {
				result = userInfoService.updateUserInfo(userInfo);
			} catch (Exception e) {
				log.error(e);
			}
		}
		return result;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public UserInfo getUserInfo(@RequestHeader String token) {
		UserInfo userInfo = null;
		User user = TokenRepository.getInstance().getUserByToken(token);
		if (user != null) {
			userInfo = user.getInfo();
		}
		return userInfo;
	}

}
