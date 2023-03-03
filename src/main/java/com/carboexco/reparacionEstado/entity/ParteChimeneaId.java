package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParteChimeneaId implements Serializable {
    private static final long serialVersionUID = -2997215258566249975L;
    @Column(name = "id_chimenea", nullable = false)
    private Integer idChimenea;

    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    public Integer getIdChimenea() {
        return idChimenea;
    }

    public void setIdChimenea(Integer idChimenea) {
        this.idChimenea = idChimenea;
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
        ParteChimeneaId entity = (ParteChimeneaId) o;
        return Objects.equals(this.idChimenea, entity.idChimenea) &&
                Objects.equals(this.idParte, entity.idParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChimenea, idParte);
    }

}