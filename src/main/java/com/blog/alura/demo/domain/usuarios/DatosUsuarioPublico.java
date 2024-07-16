package com.blog.alura.demo.domain.usuarios;

import com.blog.alura.demo.domain.perfiles.DatosPerfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DatosUsuarioPublico(
        @NotBlank
        String nombre,
        @NotNull
        @Valid
        List<DatosPerfil> perfiles
) {
        public DatosUsuarioPublico(Usuario datosUsuario) {
                this(datosUsuario.getNombre(),
                        datosUsuario.getPerfiles().stream().map(DatosPerfil::new).toList());
        }
}
