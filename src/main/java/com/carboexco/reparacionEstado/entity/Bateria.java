package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "bateria")
public class Bateria {
    @Id
    @Column(name = "id_bateria", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;

    @Column(name = "ubicacion", nullable = false, length = 500)
    private String ubicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chimenea")
    private Chimenea idChimenea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
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

    public Chimenea getIdChimenea() {
        return idChimenea;
    }

    public void setIdChimenea(Chimenea idChimenea) {
        this.idChimenea = idChimenea;
    }

}