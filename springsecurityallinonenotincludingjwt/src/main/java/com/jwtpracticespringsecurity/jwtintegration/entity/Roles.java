package com.jwtpracticespringsecurity.jwtintegration.entity;

import com.jwtpracticespringsecurity.jwtintegration.dto.RolesDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long role_id;

	private String role;

	public Roles() {
	}

	public Roles(Long role_id, String role) {
		this.role_id = role_id;
		this.role = role;
	}

	public Roles(String role) {
		this.role = role;
	}

	public static Roles convertDtoToEntity(RolesDto rolesDto) {
		return new Roles(rolesDto.getRole());
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Roles{" + "role_id=" + role_id + ", role='" + role + '\'' + '}';
	}
}