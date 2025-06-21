package com.jwtpracticespringsecurity.jwtintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwtpracticespringsecurity.jwtintegration.dto.UserDto;
import com.jwtpracticespringsecurity.jwtintegration.service.UserService;

@RestController
@RequestMapping("/unauth")
public class UnAuthController {
	
	@Autowired
	private UserService userService;


    @GetMapping("/name")
    public ResponseEntity<String> getName() {
        return new ResponseEntity<String>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<String> getAddress() {
        return new ResponseEntity<String>("Kalyani Nagar", HttpStatus.OK);
    }
    
    @PostMapping("/user/add")
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
		UserDto usrDto = userService.createNewUser(userDto);
		return new ResponseEntity<UserDto>(usrDto, HttpStatus.CREATED);
	}


}