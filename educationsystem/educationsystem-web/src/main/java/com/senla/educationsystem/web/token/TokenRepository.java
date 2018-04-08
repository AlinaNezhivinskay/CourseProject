package com.senla.educationsystem.web.token;

import java.util.HashMap;
import java.util.Map;

import com.senla.educationsystem.model.bean.User;

public class TokenRepository {
	private Map<String, User> tokens;
	static private TokenRepository instance;

	public static TokenRepository getInstance() {
		if (instance == null) {
			instance = new TokenRepository();
		}
		return instance;
	}

	private TokenRepository() {
		tokens = new HashMap<String, User>();
	}

	public boolean isTokenExist(String token) {
		return tokens.containsKey(token);
	}

	public void addToken(String token, User user) {
		tokens.put(token, user);
	}

	public void removeToken(String token) {
		tokens.remove(token);
	}

	public User getUserByToken(String token) {
		return tokens.get(token);
	}
}
