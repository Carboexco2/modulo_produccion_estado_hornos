package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ParteBateria;
import com.carboexco.reparacionEstado.entity.ParteBateriaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteBateriaRepository extends JpaRepository<ParteBateria, ParteBateriaId> {
}