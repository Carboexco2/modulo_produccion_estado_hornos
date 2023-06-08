package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EstadoRepository extends JpaRepository<Estado, Integer>, JpaSpecificationExecutor<Estado> {
}