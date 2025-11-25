package com.jmp.movieflix.service;

import java.util.List;

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
	
	public Streaming findById(Long id) {
		return streamingRepository.findById(id).orElse(null);
	}
	
	public Streaming save(Streaming streaming) {
		return streamingRepository.save(streaming);
	}
	
	public List<Streaming> findAll(){
		return streamingRepository.findAll();
	}
}
