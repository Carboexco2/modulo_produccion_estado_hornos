package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Horno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface HornoRepository extends JpaRepository<Horno, String>, JpaSpecificationExecutor<Horno> {
}