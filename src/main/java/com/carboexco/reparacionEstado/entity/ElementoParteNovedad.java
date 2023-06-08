package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "elemento_parte_novedad")
public class ElementoParteNovedad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_elemento_parte", nullable = false)
    private Integer idElementoParte;

    @Column(name = "id_novedad", nullable = false)
    private Integer idNovedad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ElementoParteNovedad entity = (ElementoParteNovedad) o;
        return Objects.equals(this.idElementoParte, entity.idElementoParte) &&
                Objects.equals(this.idNovedad, entity.idNovedad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idElementoParte, idNovedad);
    }
}