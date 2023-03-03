package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "parte_tuberia")
public class ParteTuberia {
    @EmbeddedId
    private ParteTuberiaId id;

    public ParteTuberiaId getId() {
        return id;
    }

    public void setId(ParteTuberiaId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}