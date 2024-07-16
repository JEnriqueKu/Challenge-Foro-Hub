package com.blog.alura.demo.domain.respuestas;

import com.blog.alura.demo.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "respuesta")
@Embeddable
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRespuesta;
    @Column
    private String mensaje;
    private Integer topico;
    private LocalDateTime fechaCreacion;
    @Embedded
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;
    private Boolean solucion;

    public Respuesta(DatosRespuesta datosRespuesta) {
        this.mensaje = datosRespuesta.mensaje();
        this.topico = datosRespuesta.topico();
        this.fechaCreacion = datosRespuesta.fechaCreacion();
        this.autor = new Usuario(datosRespuesta.autor());
        this.solucion = datosRespuesta.solucion();
    }
}
