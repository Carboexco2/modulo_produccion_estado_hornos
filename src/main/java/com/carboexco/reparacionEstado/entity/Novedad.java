package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
public class Novedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "fecha_hora", nullable = false)
    private Instant fechaHora;

    @Column(name = "observacion", nullable = false, length = 500)
    private String observacion;

    @Column(name = "id_foto", nullable = false)
    private Integer idFoto;

}