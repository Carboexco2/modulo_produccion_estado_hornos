package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "horno")
public class Horno {
    @Id
    @Column(name = "id_horno", nullable = false, length = 7)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_bateria", nullable = false)
    private Bateria idBateria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_operacion", nullable = false)
    private Estado idOperacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bateria getIdBateria() {
        return idBateria;
    }

    public void setIdBateria(Bateria idBateria) {
        this.idBateria = idBateria;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Estado getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Estado idOperacion) {
        this.idOperacion = idOperacion;
    }

}