package com.blog.alura.demo.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String status
) {
}
