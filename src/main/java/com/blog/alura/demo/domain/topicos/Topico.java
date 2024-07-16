package com.blog.alura.demo.domain.topicos;

import com.blog.alura.demo.domain.cursos.Curso;
import com.blog.alura.demo.domain.respuestas.Respuesta;
import com.blog.alura.demo.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopico;
    @Column
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;
    @Embedded
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;
    @Embedded
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    @Embedded
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;


    public Topico(DatosTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = datosTopico.fechaCreacion();
        this.status = datosTopico.status();
        this.autor = new Usuario(datosTopico.autor());
        this.curso = new Curso(datosTopico.curso());
        this.respuestas = datosTopico.respuestas().stream()
                .map(Respuesta::new)
                .collect(Collectors.toList());
    }

    public void actualizarDatos(DatosActualizaTopico datosActualizaTopico) {
        if (datosActualizaTopico.titulo() != null){
            this.titulo = datosActualizaTopico.titulo();
        }

        if (datosActualizaTopico.mensaje() != null){
            this.mensaje = datosActualizaTopico.mensaje();
        }

        if (datosActualizaTopico.status() != null){
            this.status = datosActualizaTopico.status();
        }
    }
}
