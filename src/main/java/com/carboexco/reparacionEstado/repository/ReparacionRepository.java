package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Reparacion;
import com.carboexco.reparacionEstado.entity.ReparacionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReparacionRepository extends JpaRepository<Reparacion, ReparacionId> {
}