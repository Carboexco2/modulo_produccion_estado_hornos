package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.ElementoParte;
import com.carboexco.reparacionEstado.repository.ElementoParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/elementos-parte")
public class ElementoParteController {

    @Autowired
    private ElementoParteRepository elementoParteRepository;

    @GetMapping
    public List<ElementoParte> getAllElementosParte() {
        return elementoParteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ElementoParte getElementoParteById(@PathVariable int id) {
        Optional<ElementoParte> elementoParte = elementoParteRepository.findById(id);

        if (elementoParte.isPresent()) {
            return elementoParte.get();
        }

        return null;
    }

    @PostMapping
    public ElementoParte createElementoParte(@RequestBody ElementoParte elementoParte) {
        return elementoParteRepository.save(elementoParte);
    }

    @PutMapping("/{id}")
    public ElementoParte updateElementoParte(@PathVariable int id, @RequestBody ElementoParte elementoParte) {
        Optional<ElementoParte> currentElementoParte = elementoParteRepository.findById(id);

        if (currentElementoParte.isPresent()) {
            ElementoParte updatedElementoParte = currentElementoParte.get();
            updatedElementoParte.setIdParte(elementoParte.getIdParte());
            updatedElementoParte.setIdElemento(elementoParte.getIdElemento());
            updatedElementoParte.setIdEstado(elementoParte.getIdEstado());
            updatedElementoParte.setLongitud(elementoParte.getLongitud());
            updatedElementoParte.setNombre(elementoParte.getNombre());
            return elementoParteRepository.save(updatedElementoParte);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ElementoParte deleteElementoParte(@PathVariable int id) {
        Optional<ElementoParte> elementoParte = elementoParteRepository.findById(id);

        if (elementoParte.isPresent()) {
            ElementoParte deletedElementoParte = elementoParte.get();
            elementoParteRepository.deleteById(id);
            return deletedElementoParte;
        }

        return null;
    }
}

