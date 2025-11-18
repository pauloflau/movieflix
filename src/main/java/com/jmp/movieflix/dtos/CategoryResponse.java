package com.jmp.movieflix.dtos;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name ) {

}
