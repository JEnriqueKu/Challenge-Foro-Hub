package com.blog.alura.demo.domain.topicos;

import com.blog.alura.demo.domain.cursos.DatosCurso;
import com.blog.alura.demo.domain.respuestas.DatosRespuestaPublico;
import com.blog.alura.demo.domain.usuarios.DatosUsuarioPublico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopicoPublico(
        Long id,
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
        DatosUsuarioPublico autor,
        @NotNull
        @Valid
        DatosCurso curso,
        @Valid
        List<DatosRespuestaPublico> respuestas
) {
        public DatosTopicoPublico(Topico datosTopico) {
                this(datosTopico.getIdTopico(),
                        datosTopico.getTitulo(),
                        datosTopico.getMensaje(),
                        datosTopico.getFechaCreacion(),
                        datosTopico.getStatus(),
                        new DatosUsuarioPublico(datosTopico.getAutor()),
                        new DatosCurso(datosTopico.getCurso()),
                        datosTopico.getRespuestas().stream().map(DatosRespuestaPublico::new).toList());
        }


}
