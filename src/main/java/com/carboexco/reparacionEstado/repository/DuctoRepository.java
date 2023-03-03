package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Ducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuctoRepository extends JpaRepository<Ducto, Integer> {
}