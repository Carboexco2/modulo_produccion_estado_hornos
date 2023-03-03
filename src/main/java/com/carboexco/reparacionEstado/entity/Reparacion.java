package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reparacion")
public class Reparacion {
    @EmbeddedId
    private ReparacionId id;

    public ReparacionId getId() {
        return id;
    }

    public void setId(ReparacionId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}