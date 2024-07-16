package com.blog.alura.demo.domain.perfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "perfil")
@Embeddable
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPerfil;
    @Column
    private String nombre;

    public Perfil(DatosPerfil datosPerfil) {
        this.nombre = datosPerfil.nombre();
    }
}
