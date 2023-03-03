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
@Table(name = "parte_ducto")
public class ParteDucto {
    @EmbeddedId
    private ParteDuctoId id;


    //TODO [JPA Buddy] generate columns from DB
}