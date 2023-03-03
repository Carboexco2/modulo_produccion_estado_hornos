package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParteHornoId implements Serializable {
    private static final long serialVersionUID = -8444223700454630742L;
    @Column(name = "id_parte", nullable = false)
    private Integer idParte;

    @Column(name = "id_horno", nullable = false, length = 7)
    private String idHorno;

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public String getIdHorno() {
        return idHorno;
    }

    public void setIdHorno(String idHorno) {
        this.idHorno = idHorno;
    }

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