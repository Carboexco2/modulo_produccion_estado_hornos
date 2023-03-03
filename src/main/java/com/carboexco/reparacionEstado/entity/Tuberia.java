package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tuberia")
public class Tuberia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tuberia", nullable = false)
    private Integer id;

    @Column(name = "nombre_tuberia", nullable = false)
    private Integer nombreTuberia;

    @Column(name = "longitud", nullable = false)
    private Integer longitud;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNombreTuberia() {
        return nombreTuberia;
    }

    public void setNombreTuberia(Integer nombreTuberia) {
        this.nombreTuberia = nombreTuberia;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

}