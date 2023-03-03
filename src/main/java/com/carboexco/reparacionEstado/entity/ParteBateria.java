package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "parte_bateria")
public class ParteBateria {
    @EmbeddedId
    private ParteBateriaId id;

    public ParteBateriaId getId() {
        return id;
    }

    public void setId(ParteBateriaId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}