package com.blog.alura.demo.domain.topicos;

import com.blog.alura.demo.domain.cursos.DatosCurso;
import com.blog.alura.demo.domain.usuarios.DatosUsuario;
import com.blog.alura.demo.domain.respuestas.DatosRespuesta;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @FutureOrPresent
        LocalDateTime fechaCreacion,
        @NotBlank
        String status,
        @NotNull
        @Valid
        DatosUsuario autor,
        @NotNull
        @Valid
        DatosCurso curso,
        @Valid
        List<DatosRespuesta> respuestas

) {
}
