package com.blog.alura.demo.domain.usuarios;

import com.blog.alura.demo.domain.perfiles.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
@Embeddable
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;
    @Column
    private String nombre;
    private String correoElectronico;
    private String contrasena;
    @Embedded
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfiles;

    public Usuario(DatosUsuario datosUsuario) {
        this.nombre = datosUsuario.nombre();
        this.correoElectronico = datosUsuario.correoElectronico();
        this.contrasena = datosUsuario.contrasena();
        this.perfiles = datosUsuario.perfiles().stream()
                .map(Perfil::new)
                .collect(Collectors.toList());
    }
}
