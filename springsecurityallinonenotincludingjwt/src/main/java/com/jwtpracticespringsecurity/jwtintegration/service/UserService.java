package com.jwtpracticespringsecurity.jwtintegration.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.jwtpracticespringsecurity.jwtintegration.dto.UserDto;

@Service
public interface UserService extends UserDetailsService {

	public UserDto createNewUser(UserDto userDto);

	public List<UserDto> getAllUsers();

	public UserDetails findByEmail(String email, String password);

}