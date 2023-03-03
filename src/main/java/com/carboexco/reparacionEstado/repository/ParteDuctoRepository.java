package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ParteDucto;
import com.carboexco.reparacionEstado.entity.ParteDuctoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteDuctoRepository extends JpaRepository<ParteDucto, ParteDuctoId> {
}