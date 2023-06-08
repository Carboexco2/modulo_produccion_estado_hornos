package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ElementoParteProyectoId implements Serializable {
    private static final long serialVersionUID = -218359138306916272L;
    @Column(name = "id_elemento_parte", nullable = false)
    private Integer idElementoParte;

    @Column(name = "id_proyecto", nullable = false)
    private Integer idProyecto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ElementoParteProyectoId entity = (ElementoParteProyectoId) o;
        return Objects.equals(this.idProyecto, entity.idProyecto) &&
                Objects.equals(this.idElementoParte, entity.idElementoParte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idElementoParte);
    }

}