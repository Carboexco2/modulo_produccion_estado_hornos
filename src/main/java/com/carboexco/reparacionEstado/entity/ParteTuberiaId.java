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
public class ParteTuberiaId implements Serializable {
    private static final long serialVersionUID = -7792509690068558730L;
    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    @Column(name = "id_tuberia", nullable = false)
    private Integer idTuberia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParteTuberiaId entity = (ParteTuberiaId) o;
        return Objects.equals(this.idTuberia, entity.idTuberia) &&
                Objects.equals(this.idParte, entity.idParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTuberia, idParte);
    }

}