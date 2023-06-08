package com.ics.fastmial.modules.Auth.Dto;



public class LoginRequest {

	public String username;
	public String password;

	public LoginRequest() {
	}

	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequest{" +
				"userName='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
