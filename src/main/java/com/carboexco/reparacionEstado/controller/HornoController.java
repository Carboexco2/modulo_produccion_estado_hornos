package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Horno;
import com.carboexco.reparacionEstado.repository.HornoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.carboexco.reparacionEstado.entity.Horno;
import com.carboexco.reparacionEstado.repository.HornoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/hornos")
public class HornoController {

    @Autowired
    private HornoRepository hornoRepository;

    // Obtener todos los hornos
    @GetMapping
    public List<Horno> getAllHornos() {
        return hornoRepository.findAll();
    }

    // Obtener un horno por su ID
    @GetMapping("/{id}")
    public Horno getHornoById(@PathVariable String id) {
        Optional<Horno> horno = hornoRepository.findById(id);

        if (horno.isPresent()) {
            return horno.get();
        }

        return null;
    }

    // Crear un nuevo horno
    @PostMapping
    public Horno createHorno(@RequestBody Horno horno) {
        return hornoRepository.save(horno);
    }

    // Actualizar un horno existente por su ID
    @PutMapping("/{id}")
    public Horno updateHorno(@PathVariable String id, @RequestBody Horno horno) {
        Optional<Horno> currentHorno = hornoRepository.findById(id);

        if (currentHorno.isPresent()) {
            Horno updatedHorno = currentHorno.get();
            updatedHorno.setIdBateria(horno.getIdBateria());
            updatedHorno.setIdEstado(horno.getIdEstado());
            updatedHorno.setIdOperacion(horno.getIdOperacion());
            return hornoRepository.save(updatedHorno);
        }

        return null;
    }

    // Eliminar un horno por su ID
    @DeleteMapping("/{id}")
    public Horno deleteHorno(@PathVariable String id) {
        Optional<Horno> horno = hornoRepository.findById(id);

        if (horno.isPresent()) {
            Horno deletedHorno = horno.get();
            hornoRepository.deleteById(id);
            return deletedHorno;
        }

        return null;
    }
}
