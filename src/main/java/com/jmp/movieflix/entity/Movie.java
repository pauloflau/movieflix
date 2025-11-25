package com.jmp.movieflix.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	private double rating;

	@CreationTimestamp //salva a hora de criação
	@Column(name = "created_at")
	private LocalDate createdAt;

	@UpdateTimestamp //salva a hora de atualização
	@Column(name = "updated_at")
	private LocalDate updatedAt;
	
	

}
