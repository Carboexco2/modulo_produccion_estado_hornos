package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
public class ParteChimeneaId implements Serializable {
    private static final long serialVersionUID = -2997215258566249975L;
    @Column(name = "id_chimenea", nullable = false)
    private Integer idChimenea;

    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

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