package com.jmp.movieflix.config;

import java.time.Instant;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jmp.movieflix.entity.User;

@Component
public class TokenService {
    
    private String secret="token";

    public String generateToken(User user) {
      Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
		.withSubject(user.getEmail())
      	.withClaim("userId", user.getId())
        	.withClaim("nome", user.getName())
            .withExpiresAt(Instant.now().plusSeconds(86400))
            .withIssuedAt(Instant.now())
            .withIssuer("API Moviflix")
            .sign(algorithm);
    }  
}
