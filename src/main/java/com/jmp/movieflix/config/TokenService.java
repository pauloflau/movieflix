package com.jmp.movieflix.config;

import java.time.Instant;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
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
    
    public Optional<JWTUserData> validateToken(String token) {
    	try{
                Algorithm algorithm = Algorithm.HMAC256(secret);

                DecodedJWT jwt = JWT.require(algorithm)
                        .build()
                        .verify(token);

               JWTUserData jwtUserData = new JWTUserData();
               jwtUserData.setUserId(jwt.getClaim("userId").asLong());
               jwtUserData.setNome(jwt.getClaim("nome").asString());
               jwtUserData.setEmail(jwt.getSubject());
                               
               return Optional.of(jwtUserData);
                   
    	} catch (JWTVerificationException ex) {
                return Optional.empty();
        }
    }
}