package com.jmp.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmp.movieflix.entity.Streaming;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long>{

}
