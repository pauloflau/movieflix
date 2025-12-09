package com.jmp.movieflix.dtos;

public class LoginRequest {
	private String email;
	private String senha;
	
	public LoginRequest() {
		// TODO Auto-generated constructor stub
	}

	public LoginRequest(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setNome(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
