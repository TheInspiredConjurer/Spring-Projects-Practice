package com.jwtpracticespringsecurity.jwtintegration.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jwtpracticespringsecurity.jwtintegration.dto.UserDto;
import com.jwtpracticespringsecurity.jwtintegration.entity.Roles;
import com.jwtpracticespringsecurity.jwtintegration.repository.RolesRepository;
import com.jwtpracticespringsecurity.jwtintegration.repository.UserRepository;
import com.jwtpracticespringsecurity.jwtintegration.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	@Lazy
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolesRepository rolesRepository;

	@Autowired
	@Lazy
	private AuthenticationManager authenticationManager;

	@Override
	public UserDto createNewUser(UserDto userDto) {
		com.jwtpracticespringsecurity.jwtintegration.entity.User u1 = com.jwtpracticespringsecurity.jwtintegration.entity.User
				.convertDtoToEntity(userDto);
		u1.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Roles role = rolesRepository.findById(1L).orElseThrow(() -> new RuntimeException("Role with ID 1 not found"));
		u1.setRoles(List.of(role));
		u1 = userRepository.save(u1);
		return UserDto.convertEntityToDto(u1);
	}

	@Override
	public List<UserDto> getAllUsers() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 5);
		List<UserDto> a = userRepository.findAll(firstPageWithTwoElements).stream().map(UserDto::convertEntityToDto)
				.collect(Collectors.toList());
		return a;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails u = userRepository.findByUsername(username);
		UsernamePasswordAuthenticationToken au = new UsernamePasswordAuthenticationToken(u.getUsername(),
				u.getPassword());
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(au);
		return u;
	}

	@Override
	public UserDetails findByEmail(String email, String password) throws AuthenticationException {
		Optional<UserDetails> u = Optional.of(userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found")));
		System.out.println(u.get().getUsername());
		System.out.println("UmU ---> " + u);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(u.get(), password);
		Authentication auth = authenticationManager.authenticate(token);
		System.out.println("wooo!!!");
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(auth);
		System.out.println(sc.getAuthentication().isAuthenticated());
		return u.get();
	}
}