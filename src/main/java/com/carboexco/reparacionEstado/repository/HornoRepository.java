package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Horno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HornoRepository extends JpaRepository<Horno, String> {
}