package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "parte_tuberia")
public class ParteTuberia {
    @EmbeddedId
    private ParteTuberiaId id;

    //TODO [JPA Buddy] generate columns from DB
}