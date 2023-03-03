package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ParteTuberia;
import com.carboexco.reparacionEstado.entity.ParteTuberiaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteTuberiaRepository extends JpaRepository<ParteTuberia, ParteTuberiaId> {
}