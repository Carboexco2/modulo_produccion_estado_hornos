package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "prioridad")
public class Prioridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prioridad", nullable = false)
    private Integer id;

    @Column(name = "nombre_prioridad", nullable = false, length = 10)
    private String nombrePrioridad;


}