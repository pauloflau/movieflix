package com.jmp.movieflix.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.movieflix.dtos.StreamingRequest;
import com.jmp.movieflix.dtos.StreamingResponse;
import com.jmp.movieflix.entity.Streaming;
import com.jmp.movieflix.mapper.StreamingMapper;
import com.jmp.movieflix.service.StreamingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movieflix/streaming")
@RequiredArgsConstructor
public class StreamingController {
	
private final StreamingService streamingService;
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		streamingService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StreamingResponse> findById(@PathVariable Long id) {
		Streaming streaming = streamingService.findById(id);
		if(streaming!=null) {
			return ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request) {
		Streaming newStreaming = StreamingMapper.toStreaming(request);
		Streaming saveStreaming = streamingService.save(newStreaming);
		return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(saveStreaming));
	}
	
	@GetMapping
	public ResponseEntity<List<StreamingResponse>> getAllStreamings(){
		List<StreamingResponse> streamings = streamingService.findAll()
			.stream()
			.map(streaming -> StreamingMapper.toStreamingResponse(streaming))
			.toList();	
		return ResponseEntity.ok(streamings);
	}

}
