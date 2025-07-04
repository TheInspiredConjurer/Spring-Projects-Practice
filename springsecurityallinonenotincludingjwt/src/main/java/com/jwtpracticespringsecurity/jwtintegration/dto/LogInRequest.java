package com.jwtpracticespringsecurity.jwtintegration.dto;

public class LogInRequest {

	private String email;
	private String password;

	public LogInRequest() {
	}

	public LogInRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LogInRequest{" + "email='" + email + '\'' + ", password='" + password + '\'' + '}';
	}
}