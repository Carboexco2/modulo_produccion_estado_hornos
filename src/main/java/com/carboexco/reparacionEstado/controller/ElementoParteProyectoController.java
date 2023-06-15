package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.ElementoParteProyecto;
import com.carboexco.reparacionEstado.entity.ElementoParteProyectoId;
import com.carboexco.reparacionEstado.repository.ElementoParteProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/elementos-parte-proyecto")
public class ElementoParteProyectoController {

    @Autowired
    private ElementoParteProyectoRepository elementoParteProyectoRepository;

    @GetMapping
    public List<ElementoParteProyecto> getAllElementosParteProyecto() {
        return elementoParteProyectoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ElementoParteProyecto getElementoParteProyectoById(@PathVariable ElementoParteProyectoId id) {
        Optional<ElementoParteProyecto> elementoParteProyecto = elementoParteProyectoRepository.findById(id);

        if (elementoParteProyecto.isPresent()) {
            return elementoParteProyecto.get();
        }

        return null;
    }

    @PostMapping
    public ElementoParteProyecto createElementoParteProyecto(@RequestBody ElementoParteProyecto elementoParteProyecto) {
        return elementoParteProyectoRepository.save(elementoParteProyecto);
    }

    @PutMapping("/{id}")
    public ElementoParteProyecto updateElementoParteProyecto(@PathVariable ElementoParteProyectoId id, @RequestBody ElementoParteProyecto elementoParteProyecto) {
        Optional<ElementoParteProyecto> currentElementoParteProyecto = elementoParteProyectoRepository.findById(id);

        if (currentElementoParteProyecto.isPresent()) {
            ElementoParteProyecto updatedElementoParteProyecto = currentElementoParteProyecto.get();
            updatedElementoParteProyecto.setFecha(elementoParteProyecto.getFecha());
            return elementoParteProyectoRepository.save(updatedElementoParteProyecto);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ElementoParteProyecto deleteElementoParteProyecto(@PathVariable ElementoParteProyectoId id) {
        Optional<ElementoParteProyecto> elementoParteProyecto = elementoParteProyectoRepository.findById(id);

        if (elementoParteProyecto.isPresent()) {
            ElementoParteProyecto deletedElementoParteProyecto = elementoParteProyecto.get();
            elementoParteProyectoRepository.deleteById(id);
            return deletedElementoParteProyecto;
        }

        return null;
    }
}