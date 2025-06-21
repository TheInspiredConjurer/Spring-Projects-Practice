package com.jwtpracticespringsecurity.jwtintegration.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.jwtpracticespringsecurity.jwtintegration.entity.User;

public class UserDto {
	private Long id;
	private List<RolesDto> role;
	private String username;
	private String email;
	private String password;

	public UserDto() {
	}

	public UserDto(String username, String email, List<RolesDto> role) {
		this.username = username;
		this.email = email;
		this.role = role;
	}

	public UserDto(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public static UserDto convertEntityToDto(User user) {
		return new UserDto(user.getUsername(), user.getEmail(),
				user.getRoles().stream().map(RolesDto::convertEntityToDto).collect(Collectors.toList()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RolesDto> getRole() {
		return role;
	}

	public void setRole(List<RolesDto> role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "UserDto{" + "id=" + id + ", role=" + role + ", username='" + username + '\'' + ", email='" + email
				+ '\'' + ", password='" + password + '\'' + '}';
	}
}