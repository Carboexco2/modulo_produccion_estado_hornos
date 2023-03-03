package com.carboexco.reparacionEstado.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Data
@Table(name = "horno")
public class Horno {
    @Id
    @Column(name = "id_horno", nullable = false, length = 7)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_bateria", nullable = false)
    private Bateria idBateria;

    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @ManyToOne
    @JoinColumn(name = "id_operacion", nullable = false)
    private Estado idOperacion;

}