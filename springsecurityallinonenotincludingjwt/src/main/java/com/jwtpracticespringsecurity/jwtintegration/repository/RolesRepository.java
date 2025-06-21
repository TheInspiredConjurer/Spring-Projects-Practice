package com.jwtpracticespringsecurity.jwtintegration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtpracticespringsecurity.jwtintegration.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}