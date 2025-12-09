package com.jmp.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.movieflix.entity.User;
import com.jmp.movieflix.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {  //metodo para salvar usuario
		return userRepository.save(user);
	}	
}