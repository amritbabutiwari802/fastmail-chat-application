package com.ics.fastmial.modules.Auth.Dto;

public class LoginResponse {
	public String authToken;

	public LoginResponse() {
	}

	public LoginResponse(String authToken) {
		this.authToken = authToken;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
}
