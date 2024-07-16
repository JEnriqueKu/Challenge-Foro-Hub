package com.blog.alura.demo.domain.respuestas;

import com.blog.alura.demo.domain.usuarios.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Integer topico,
        @NotNull
        @FutureOrPresent
        LocalDateTime fechaCreacion,
        @NotNull
        @Valid
        DatosUsuario autor,
        @NotNull
        Boolean solucion
) {
}
