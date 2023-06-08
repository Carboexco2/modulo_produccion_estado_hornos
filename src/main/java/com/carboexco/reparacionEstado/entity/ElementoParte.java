package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "elemento_parte")
public class ElementoParte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_parte", nullable = false)
    private Parte idParte;

    @Column(name = "id_elemento", nullable = false, length = 7)
    private String idElemento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @Column(name = "longitud")
    private Integer longitud;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

}