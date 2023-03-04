package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "parte_bateria")
public class ParteBateria {
    @EmbeddedId
    private ParteBateriaId id;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;
    //TODO [JPA Buddy] generate columns from DB
}