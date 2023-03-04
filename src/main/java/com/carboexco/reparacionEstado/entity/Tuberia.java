package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "tuberia")
public class Tuberia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tuberia", nullable = false)
    private Integer id;

    @Column(name = "nombre_tuberia", nullable = false)
    private String nombreTuberia;

    @Column(name = "longitud", nullable = false)
    private Integer longitud;

}