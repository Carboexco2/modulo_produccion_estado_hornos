package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.Parte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteRepository extends JpaRepository<Parte, Integer> {
}