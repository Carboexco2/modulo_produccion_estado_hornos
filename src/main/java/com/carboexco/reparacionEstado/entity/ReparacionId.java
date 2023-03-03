package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
public class ReparacionId implements Serializable {
    private static final long serialVersionUID = -4088446574369244146L;
    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    @Column(name = "id_elemento", nullable = false, length = 7)
    private String idElemento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReparacionId entity = (ReparacionId) o;
        return Objects.equals(this.idProyecto, entity.idProyecto) &&
                Objects.equals(this.idElemento, entity.idElemento) &&
                Objects.equals(this.idParte, entity.idParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idElemento, idParte);
    }

}