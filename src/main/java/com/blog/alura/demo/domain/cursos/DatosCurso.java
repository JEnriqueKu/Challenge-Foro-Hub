package com.blog.alura.demo.domain.cursos;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
        public DatosCurso(Curso curso) {
                this(curso.getNombre(), curso.getCategoria());
        }
}
