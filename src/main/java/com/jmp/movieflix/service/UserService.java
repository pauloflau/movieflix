package com.jmp.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jmp.movieflix.entity.User;
import com.jmp.movieflix.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {  //metodo para salvar usuario
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		return userRepository.save(user);
	}	
}