package com.jmp.movieflix.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.jmp.movieflix.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	Optional<UserDetails> findUserByEmail(String email);
}