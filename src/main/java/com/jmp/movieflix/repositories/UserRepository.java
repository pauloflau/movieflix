package com.jmp.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmp.movieflix.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}