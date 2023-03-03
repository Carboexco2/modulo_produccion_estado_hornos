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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDucto() {
        return nombreDucto;
    }

    public void setNombreDucto(String nombreDucto) {
        this.nombreDucto = nombreDucto;
    }

    public Integer getLungitud() {
        return lungitud;
    }

    public void setLungitud(Integer lungitud) {
        this.lungitud = lungitud;
    }

}