package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadRepository extends JpaRepository<Novedad, Integer> {
}