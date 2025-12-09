package com.jmp.movieflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jmp.movieflix.entity.Streaming;
import com.jmp.movieflix.repositories.StreamingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StreamingService {
	
	private final StreamingRepository streamingRepository;
	
	public void delete(Long id) {
		streamingRepository.deleteById(id);
	}
	
	public Optional<Streaming> findById(Long id) {
		return streamingRepository.findById(id);
	}
	
	public Streaming save(Streaming streaming) {
		return streamingRepository.save(streaming);
	}
	
	public List<Streaming> findAll(){
		return streamingRepository.findAll();
	}
}
