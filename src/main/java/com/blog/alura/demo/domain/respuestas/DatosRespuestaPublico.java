package com.blog.alura.demo.domain.respuestas;

import com.blog.alura.demo.domain.usuarios.DatosUsuarioPublico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRespuestaPublico(
        @NotBlank
        String mensaje,
        @NotNull
        Integer topico,
        @NotNull
        @FutureOrPresent
        LocalDateTime fechaCreacion,
        @NotNull
        @Valid
        DatosUsuarioPublico autor,
        @NotNull
        Boolean solucion
) {
        public DatosRespuestaPublico(Respuesta respuesta) {
                this(respuesta.getMensaje(),
                        respuesta.getTopico(),
                        respuesta.getFechaCreacion(),
                        new DatosUsuarioPublico(respuesta.getAutor()),
                        respuesta.getSolucion());
        }
}
