package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}