package com.jmp.movieflix.dtos;

public class LoginResponse {
	private String token;
	
	public LoginResponse() {
		// TODO Auto-generated constructor stub
	}

	public LoginResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
