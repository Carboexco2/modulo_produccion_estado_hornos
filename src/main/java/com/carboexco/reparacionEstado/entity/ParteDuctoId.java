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
public class ParteDuctoId implements Serializable {
    private static final long serialVersionUID = -569402457766258660L;
    @Column(name = "id_ducto", nullable = false)
    private Integer idDucto;

    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

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