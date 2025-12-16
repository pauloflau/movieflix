package com.jmp.movieflix.config;

public class JWTUserData {
	Long userId;
	String email;
	String nome;
	
	public JWTUserData() {
		// TODO Auto-generated constructor stub
	}

	public JWTUserData(Long userId, String email, String nome) {
		super();
		this.userId = userId;
		this.email = email;
		this.nome = nome;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
