package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParteDuctoId implements Serializable {
    private static final long serialVersionUID = -569402457766258660L;
    @Column(name = "id_ducto", nullable = false)
    private Integer idDucto;

    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    public Integer getIdDucto() {
        return idDucto;
    }

    public void setIdDucto(Integer idDucto) {
        this.idDucto = idDucto;
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
        ParteDuctoId entity = (ParteDuctoId) o;
        return Objects.equals(this.idDucto, entity.idDucto) &&
                Objects.equals(this.idParte, entity.idParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDucto, idParte);
    }

}