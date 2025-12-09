package com.jmp.movieflix.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.movieflix.dtos.MovieRequest;
import com.jmp.movieflix.dtos.MovieResponse;
import com.jmp.movieflix.entity.Movie;
import com.jmp.movieflix.mapper.MovieMapper;
import com.jmp.movieflix.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController {

	private final MovieService movieService;

	@PostMapping
	public ResponseEntity<MovieResponse> Save(@RequestBody MovieRequest request) {
		Movie savedMovie = movieService.save(MovieMapper.toMovie(request));
		return ResponseEntity.ok(MovieMapper.toMovieResponse(savedMovie));
	}

	@GetMapping
	public ResponseEntity<List<MovieResponse>> findAll() {
		return ResponseEntity
				.ok(movieService.findAll().stream().map(movie -> MovieMapper.toMovieResponse(movie)).toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieResponse> findById(@PathVariable Long id) {
		return movieService.findById(id).map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @RequestBody MovieRequest request) {
		return movieService.update(id, MovieMapper.toMovie(request))
				.map(movie -> ResponseEntity.ok(MovieMapper.toMovieResponse(movie)))
				.orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<MovieResponse>> findByCategoria(@RequestParam Long categoriaId) {
		return ResponseEntity.ok(movieService.findByCategory(categoriaId)
				.stream()
				.map(MovieMapper::toMovieResponse)
				.toList());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
		boolean deleted = movieService.delete(id);
		if (deleted) {
			return ResponseEntity.noContent().build(); // 204
		} else {
			return ResponseEntity.notFound().build(); // 404
		}
	}

}
