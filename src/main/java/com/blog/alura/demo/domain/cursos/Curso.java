package com.blog.alura.demo.domain.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
@Embeddable
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    @Column
    private String nombre;
    private String categoria;

    public Curso(DatosCurso datosCurso) {
        this.nombre = datosCurso.nombre();
        this.categoria = datosCurso.categoria();
    }
}
