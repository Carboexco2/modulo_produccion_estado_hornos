package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParteBateriaId implements Serializable {
    private static final long serialVersionUID = -1611614344951562452L;
    @Column(name = "id_bateria", nullable = false)
    private Integer idBateria;

    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    public Integer getIdBateria() {
        return idBateria;
    }

    public void setIdBateria(Integer idBateria) {
        this.idBateria = idBateria;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParteBateriaId entity = (ParteBateriaId) o;
        return Objects.equals(this.idBateria, entity.idBateria) &&
                Objects.equals(this.idParte, entity.idParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBateria, idParte);
    }

}