package com.jmp.movieflix.dtos;

import lombok.Builder;

@Builder
public record StreamingResponse (Long id, String name){
}
