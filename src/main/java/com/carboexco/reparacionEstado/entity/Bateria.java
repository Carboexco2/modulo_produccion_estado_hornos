package com.carboexco.reparacionEstado.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bateria")
public class Bateria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bateria", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado idEstado;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "id_ubicacion", nullable = false)
    private Integer idUbicacion;

    @ManyToOne
    @JoinColumn(name = "id_chimenea")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Chimenea idChimenea;

}