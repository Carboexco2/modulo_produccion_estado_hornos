package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Ducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DuctoRepository extends JpaRepository<Ducto, Integer>, JpaSpecificationExecutor<Ducto> {
}