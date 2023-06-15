package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Parte;
import com.carboexco.reparacionEstado.repository.ParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.carboexco.reparacionEstado.entity.Parte;
import com.carboexco.reparacionEstado.repository.ParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/partes")
public class ParteController {

    @Autowired
    private ParteRepository parteRepository;

    // Obtener todas las partes
    @GetMapping
    public List<Parte> getAllPartes() {
        return parteRepository.findAll();
    }

    // Obtener una parte por su ID
    @GetMapping("/{id}")
    public Parte getParteById(@PathVariable int id) {
        Optional<Parte> parte = parteRepository.findById(id);

        if (parte.isPresent()) {
            return parte.get();
        }

        return null;
    }

    // Crear una nueva parte
    @PostMapping
    public Parte createParte(@RequestBody Parte parte) {
        return parteRepository.save(parte);
    }

    // Actualizar una parte existente por su ID
    @PutMapping("/{id}")
    public Parte updateParte(@PathVariable int id, @RequestBody Parte parte) {
        Optional<Parte> currentParte = parteRepository.findById(id);

        if (currentParte.isPresent()) {
            Parte updatedParte = currentParte.get();
            updatedParte.setNombreParte(parte.getNombreParte());
            updatedParte.setIdPrioridad(parte.getIdPrioridad());
            updatedParte.setIdTipoParte(parte.getIdTipoParte());
            return parteRepository.save(updatedParte);
        }

        return null;
    }

    // Eliminar una parte por su ID
    @DeleteMapping("/{id}")
    public Parte deleteParte(@PathVariable int id) {
        Optional<Parte> parte = parteRepository.findById(id);

        if (parte.isPresent()) {
            Parte deletedParte = parte.get();
            parteRepository.deleteById(id);
            return deletedParte;
        }

        return null;
    }
}
