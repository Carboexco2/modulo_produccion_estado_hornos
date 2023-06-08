package com.carboexco.reparacionEstado.repository;

import com.carboexco.reparacionEstado.entity.TipoParte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoParteRepository extends JpaRepository<TipoParte, Integer> {
}