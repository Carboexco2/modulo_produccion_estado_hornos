package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ElementoParte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementoParteRepository extends JpaRepository<ElementoParte, Integer> {
}