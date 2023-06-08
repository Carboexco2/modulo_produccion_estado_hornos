package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Bateria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BateriaRepository extends JpaRepository<Bateria, Integer>, JpaSpecificationExecutor<Bateria> {
}