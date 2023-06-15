package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Prioridad;
import com.carboexco.reparacionEstado.repository.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.carboexco.reparacionEstado.entity.Prioridad;
import com.carboexco.reparacionEstado.repository.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/prioridades")
public class PrioridadController {

    @Autowired
    private PrioridadRepository prioridadRepository;

    // Obtener todas las prioridades
    @GetMapping
    public List<Prioridad> getAllPrioridades() {
        return prioridadRepository.findAll();
    }

    // Obtener una prioridad por su ID
    @GetMapping("/{id}")
    public Prioridad getPrioridadById(@PathVariable int id) {
        Optional<Prioridad> prioridad = prioridadRepository.findById(id);

        if (prioridad.isPresent()) {
            return prioridad.get();
        }

        return null;
    }

    // Crear una nueva prioridad
    @PostMapping
    public Prioridad createPrioridad(@RequestBody Prioridad prioridad) {
        return prioridadRepository.save(prioridad);
    }

    // Actualizar una prioridad existente por su ID
    @PutMapping("/{id}")
    public Prioridad updatePrioridad(@PathVariable int id, @RequestBody Prioridad prioridad) {
        Optional<Prioridad> currentPrioridad = prioridadRepository.findById(id);

        if (currentPrioridad.isPresent()) {
            Prioridad updatedPrioridad = currentPrioridad.get();
            updatedPrioridad.setNombrePrioridad(prioridad.getNombrePrioridad());
            return prioridadRepository.save(updatedPrioridad);
        }

        return null;
    }

    // Eliminar una prioridad por su ID
    @DeleteMapping("/{id}")
    public Prioridad deletePrioridad(@PathVariable int id) {
        Optional<Prioridad> prioridad = prioridadRepository.findById(id);

        if (prioridad.isPresent()) {
            Prioridad deletedPrioridad = prioridad.get();
            prioridadRepository.deleteById(id);
            return deletedPrioridad;
        }

        return null;
    }
}
