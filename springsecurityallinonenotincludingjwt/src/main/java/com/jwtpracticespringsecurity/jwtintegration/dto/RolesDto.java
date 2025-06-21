package com.jwtpracticespringsecurity.jwtintegration.dto;

import com.jwtpracticespringsecurity.jwtintegration.entity.Roles;

public class RolesDto {

	private Long id;
	private String role;

	public RolesDto() {
	}

	public RolesDto(Long id, String role) {
		this.id = id;
		this.role = role;
	}

	public RolesDto(String role) {
		this.role = role;
	}

	public static RolesDto convertEntityToDto(Roles role) {
		RolesDto rolesDto = new RolesDto();
		rolesDto.setRole(role.getRole());
		return rolesDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "RolesDto{ role= " + role + '}';
	}
}