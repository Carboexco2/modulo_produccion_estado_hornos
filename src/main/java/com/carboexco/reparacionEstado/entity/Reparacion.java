package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "reparacion")
public class Reparacion {
    @EmbeddedId
    private ReparacionId id;

    //TODO [JPA Buddy] generate columns from DB
}