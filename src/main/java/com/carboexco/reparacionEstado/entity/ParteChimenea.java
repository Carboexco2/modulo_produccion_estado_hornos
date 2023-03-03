package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "parte_chimenea")
public class ParteChimenea {
    @EmbeddedId
    private ParteChimeneaId id;

    public ParteChimeneaId getId() {
        return id;
    }

    public void setId(ParteChimeneaId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}