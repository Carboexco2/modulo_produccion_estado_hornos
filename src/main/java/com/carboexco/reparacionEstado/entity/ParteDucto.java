package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "parte_ducto")
public class ParteDucto {
    @EmbeddedId
    private ParteDuctoId id;

    public ParteDuctoId getId() {
        return id;
    }

    public void setId(ParteDuctoId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}