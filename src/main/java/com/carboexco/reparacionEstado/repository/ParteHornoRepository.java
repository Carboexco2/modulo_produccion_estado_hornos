package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ParteHorno;
import com.carboexco.reparacionEstado.entity.ParteHornoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteHornoRepository extends JpaRepository<ParteHorno, ParteHornoId> {
}