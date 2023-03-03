package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.ParteChimenea;
import com.carboexco.reparacionEstado.entity.ParteChimeneaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteChimeneaRepository extends JpaRepository<ParteChimenea, ParteChimeneaId> {
}