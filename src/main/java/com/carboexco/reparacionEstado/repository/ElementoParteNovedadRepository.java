package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ElementoParteNovedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementoParteNovedadRepository extends JpaRepository<ElementoParteNovedad, Long> {
}