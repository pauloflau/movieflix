package com.jmp.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.movieflix.config.TokenService;
import com.jmp.movieflix.dtos.LoginRequest;
import com.jmp.movieflix.dtos.LoginResponse;
import com.jmp.movieflix.dtos.UserRequest;
import com.jmp.movieflix.dtos.UserResponse;
import com.jmp.movieflix.entity.User;
import com.jmp.movieflix.mapper.UserMapper;
import com.jmp.movieflix.service.UserService;

@RestController
@RequestMapping("/movieflix/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
		User savedUser = userService.save(UserMapper.toUser(request));
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(UserMapper.toUserResponse(savedUser));
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
		UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha());
			
		Authentication authenticate = authenticationManager.authenticate(userAndPass);
			
		User user = (User) authenticate.getPrincipal();		

		String token = tokenService.generateToken(user);

		return ResponseEntity.ok(new LoginResponse(token));

	}
}
