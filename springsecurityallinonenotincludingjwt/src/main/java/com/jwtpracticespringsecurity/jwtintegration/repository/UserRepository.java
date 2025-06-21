package com.jwtpracticespringsecurity.jwtintegration.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.jwtpracticespringsecurity.jwtintegration.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public Page<User> findAll(Pageable pageable);

	public UserDetails findByUsername(String username);

	public Optional<UserDetails> findByEmail(String email);
}