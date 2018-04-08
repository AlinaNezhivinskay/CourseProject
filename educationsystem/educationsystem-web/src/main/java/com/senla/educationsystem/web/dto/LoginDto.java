package com.senla.educationsystem.web.dto;

public class LoginDto {
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public LoginDto(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
