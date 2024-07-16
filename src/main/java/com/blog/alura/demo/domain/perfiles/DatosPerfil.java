package com.blog.alura.demo.domain.perfiles;

import jakarta.validation.constraints.NotBlank;

public record DatosPerfil(
        @NotBlank
        String nombre
) {
        public DatosPerfil(Perfil perfil) {
                this(perfil.getNombre());
        }
}
