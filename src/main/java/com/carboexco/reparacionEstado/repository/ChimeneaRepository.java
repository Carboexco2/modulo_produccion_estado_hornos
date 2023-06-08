package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Chimenea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChimeneaRepository extends JpaRepository<Chimenea, Integer>, JpaSpecificationExecutor<Chimenea> {
}