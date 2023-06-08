package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Prioridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PrioridadRepository extends JpaRepository<Prioridad, Integer>, JpaSpecificationExecutor<Prioridad> {
}