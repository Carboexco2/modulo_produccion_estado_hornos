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
@Data
public class ParteHornoId implements Serializable {
    private static final long serialVersionUID = -8444223700454630742L;
    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    @Column(name = "id_horno", nullable = false, length = 7)
    private String idHorno;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ParteHornoId entity = (ParteHornoId) o;
        return Objects.equals(this.idHorno, entity.idHorno) &&
                Objects.equals(this.idParte, entity.idParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHorno, idParte);
    }

}