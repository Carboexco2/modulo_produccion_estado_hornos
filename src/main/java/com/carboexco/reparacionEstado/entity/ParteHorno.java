package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "parte_horno")
public class ParteHorno {
    @EmbeddedId
    private ParteHornoId id;

    public ParteHornoId getId() {
        return id;
    }

    public void setId(ParteHornoId id) {
        this.id = id;
    }

    //TODO [JPA Buddy] generate columns from DB
}