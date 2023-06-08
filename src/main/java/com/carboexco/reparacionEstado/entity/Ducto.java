package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "ducto")
public class Ducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ducto", nullable = false)
    private Integer id;

    @Column(name = "nombre_ducto", nullable = false, length = 100)
    private String nombreDucto;

    @Column(name = "lungitud", nullable = false)
    private Integer lungitud;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @Column(name = "tuberia", nullable = false)
    private Boolean tuberia = false;

}