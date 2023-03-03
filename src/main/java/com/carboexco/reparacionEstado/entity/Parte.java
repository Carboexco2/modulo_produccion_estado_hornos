package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "parte")
public class Parte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parte", nullable = false)
    private Integer id;

    @Column(name = "nombre_parte", nullable = false, length = 30)
    private String nombreParte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreParte() {
        return nombreParte;
    }

    public void setNombreParte(String nombreParte) {
        this.nombreParte = nombreParte;
    }

}