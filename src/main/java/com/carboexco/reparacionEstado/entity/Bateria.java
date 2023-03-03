package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bateria")
public class Bateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bateria", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;

    @Column(name = "ubicacion", nullable = false, length = 500)
    private String ubicacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}