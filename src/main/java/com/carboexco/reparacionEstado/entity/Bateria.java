package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "bateria")
public class Bateria {
    @Id
    @Column(name = "id_bateria", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @Column(name = "nombre", nullable = false, length = 500)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_chimenea")
    private Chimenea idChimenea;

    @Column(name = "id_ubicacion", nullable = false)
    private Integer idUbicacion;

}