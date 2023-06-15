package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Novedad;
import com.carboexco.reparacionEstado.repository.NovedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/novedades")
public class NovedadController {

    @Autowired
    private NovedadRepository novedadRepository;

    // Obtener todas las novedades
    @GetMapping
    public List<Novedad> getAllNovedades() {
        return novedadRepository.findAll();
    }

    // Obtener una novedad por su ID
    @GetMapping("/{id}")
    public Novedad getNovedadById(@PathVariable int id) {
        Optional<Novedad> novedad = novedadRepository.findById(id);

        if (novedad.isPresent()) {
            return novedad.get();
        }

        return null;
    }

    // Crear una nueva novedad
    @PostMapping
    public Novedad createNovedad(@RequestBody Novedad novedad) {
        return novedadRepository.save(novedad);
    }

    // Actualizar una novedad existente por su ID
    @PutMapping("/{id}")
    public Novedad updateNovedad(@PathVariable int id, @RequestBody Novedad novedad) {
        Optional<Novedad> currentNovedad = novedadRepository.findById(id);

        if (currentNovedad.isPresent()) {
            Novedad updatedNovedad = currentNovedad.get();
            updatedNovedad.setIdUsuario(novedad.getIdUsuario());
            updatedNovedad.setFechaHora(novedad.getFechaHora());
            updatedNovedad.setObservacion(novedad.getObservacion());
            updatedNovedad.setIdFoto(novedad.getIdFoto());
            return novedadRepository.save(updatedNovedad);
        }

        return null;
    }

    // Eliminar una novedad por su ID
    @DeleteMapping("/{id}")
    public Novedad deleteNovedad(@PathVariable int id) {
        Optional<Novedad> novedad = novedadRepository.findById(id);

        if (novedad.isPresent()) {
            Novedad deletedNovedad = novedad.get();
            novedadRepository.deleteById(id);
            return deletedNovedad;
        }

        return null;
    }
}
