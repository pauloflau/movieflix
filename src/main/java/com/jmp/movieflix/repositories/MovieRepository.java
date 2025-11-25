package com.jmp.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmp.movieflix.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
