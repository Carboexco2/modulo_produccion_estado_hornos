package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ElementoParteProyecto;
import com.carboexco.reparacionEstado.entity.ElementoParteProyectoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementoParteProyectoRepository extends JpaRepository<ElementoParteProyecto, ElementoParteProyectoId> {
}