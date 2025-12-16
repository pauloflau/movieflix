package com.jmp.movieflix.dtos;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message="nome da categoria e obrigatorio") String name) {

}
