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
@Table(name = "parte_horno")
public class ParteHorno {
    @EmbeddedId
    private ParteHornoId id;


    //TODO [JPA Buddy] generate columns from DB
}