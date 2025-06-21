package com.jwtpracticespringsecurity.jwtintegration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtpracticespringsecurity.jwtintegration.dto.LogInRequest;
import com.jwtpracticespringsecurity.jwtintegration.dto.UserDto;
import com.jwtpracticespringsecurity.jwtintegration.service.UserService;



@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() throws Exception {
		List<UserDto> listUsrsDto = userService.getAllUsers();
		if (listUsrsDto.size() == 0) {
			return ResponseEntity.status(HttpStatus.OK).body("List is empty");
		}
		return ResponseEntity.status(HttpStatus.OK).body(listUsrsDto);
	}

	@GetMapping("/user/:username")
	public ResponseEntity<UserDetails> getUser(@PathVariable("username") String username) {
		try {
			UserDetails u = userService.loadUserByUsername(username);
			return ResponseEntity.status(HttpStatus.OK).body(u);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getCause());
		} finally {
			System.out.println("program");
		}
	}

	@PostMapping("/user/login")
	public ResponseEntity<String> loginUser(@RequestBody LogInRequest logInRequest) {
		UserDetails u = userService.findByEmail(logInRequest.getEmail(), logInRequest.getPassword());
		if (u != null) {
			System.out.println("UmU --->" + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
		}
		return new ResponseEntity<>("Successfully Logged in", HttpStatus.OK);
	}
}