package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "elemento_parte_proyecto")
public class ElementoParteProyecto {
    @EmbeddedId
    private ElementoParteProyectoId id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

}