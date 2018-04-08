package com.senla.educationsystem.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senla.educationsystem.api.service.IUserService;
import com.senla.educationsystem.model.bean.User;
import com.senla.educationsystem.web.dto.LoginDto;
import com.senla.educationsystem.web.token.TokenManager;
import com.senla.educationsystem.web.token.TokenRepository;

@RestController
public class AuthController {

	private static Logger log = Logger.getLogger(AuthController.class.getName());

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@RequestBody User user) {
		String token = null;
		try {
			if (user != null) {
				userService.addUser(user);
				LoginDto dto = new LoginDto(user.getLogin(), user.getPassword());
				token = logIn(dto);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return token;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String logIn(@RequestBody LoginDto dto) {
		String token = null;
		if (dto != null) {
			try {
				User user = userService.getUserByLogin(dto.getLogin());
				boolean isUserValid = validateUser(user, dto.getLogin(), dto.getPassword());
				if (isUserValid) {
					token = TokenManager.generateToken(user);
					TokenRepository.getInstance().addToken(token, user);
				}
			} catch (Exception e) {
				log.error(e);
			}
		}
		return token;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public boolean logOut(@RequestHeader String token) {
		TokenRepository.getInstance().removeToken(token);
		return true;
	}

	private boolean validateUser(User user, String login, String password) {
		if (user == null) {
			return false;
		}
		return user.getLogin().equals(login) && user.getPassword().equals(password);

	}
}
