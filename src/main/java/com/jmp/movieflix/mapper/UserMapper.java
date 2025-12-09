package com.jmp.movieflix.mapper;

import com.jmp.movieflix.dtos.UserRequest;
import com.jmp.movieflix.dtos.UserResponse;
import com.jmp.movieflix.entity.User;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
	public static User toUser(UserRequest request) {
		User user = new User();
		user.setName(request.getNome());
		user.setEmail(request.getEmail());
		user.setPassword(request.getSenha());
		return user;
	}
	
	public static UserResponse toUserResponse(User user) {
		UserResponse response = new UserResponse();
		response.setId(user.getId());
		response.setNome(user.getName());
		response.setEmail(user.getEmail());
		return response;
	}
}
