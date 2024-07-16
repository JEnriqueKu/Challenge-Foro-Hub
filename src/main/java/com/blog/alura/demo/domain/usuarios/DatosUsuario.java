package com.blog.alura.demo.domain.usuarios;

import com.blog.alura.demo.domain.perfiles.DatosPerfil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record DatosUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Email
        String correoElectronico,
        @NotBlank
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String contrasena,
        @NotNull
        @Valid
        List<DatosPerfil> perfiles
){
}
