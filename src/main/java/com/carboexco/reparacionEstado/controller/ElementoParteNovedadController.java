package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.ElementoParteNovedad;
import com.carboexco.reparacionEstado.repository.ElementoParteNovedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/elementos-parte-novedad")
public class ElementoParteNovedadController {

    @Autowired
    private ElementoParteNovedadRepository elementoParteNovedadRepository;

    @GetMapping
    public List<ElementoParteNovedad> getAllElementosParteNovedad() {
        return elementoParteNovedadRepository.findAll();
    }

    @GetMapping("/{id}")
    public ElementoParteNovedad getElementoParteNovedadById(@PathVariable Long id) {
        Optional<ElementoParteNovedad> elementoParteNovedad = elementoParteNovedadRepository.findById(id);

        if (elementoParteNovedad.isPresent()) {
            return elementoParteNovedad.get();
        }

        return null;
    }

    @PostMapping
    public ElementoParteNovedad createElementoParteNovedad(@RequestBody ElementoParteNovedad elementoParteNovedad) {
        return elementoParteNovedadRepository.save(elementoParteNovedad);
    }

    @PutMapping("/{id}")
    public ElementoParteNovedad updateElementoParteNovedad(@PathVariable Long id, @RequestBody ElementoParteNovedad elementoParteNovedad) {
        Optional<ElementoParteNovedad> currentElementoParteNovedad = elementoParteNovedadRepository.findById(id);

        if (currentElementoParteNovedad.isPresent()) {
            ElementoParteNovedad updatedElementoParteNovedad = currentElementoParteNovedad.get();
            updatedElementoParteNovedad.setIdElementoParte(elementoParteNovedad.getIdElementoParte());
            updatedElementoParteNovedad.setIdNovedad(elementoParteNovedad.getIdNovedad());
            return elementoParteNovedadRepository.save(updatedElementoParteNovedad);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ElementoParteNovedad deleteElementoParteNovedad(@PathVariable Long id) {
        Optional<ElementoParteNovedad> elementoParteNovedad = elementoParteNovedadRepository.findById(id);

        if (elementoParteNovedad.isPresent()) {
            ElementoParteNovedad deletedElementoParteNovedad = elementoParteNovedad.get();
            elementoParteNovedadRepository.deleteById(id);
            return deletedElementoParteNovedad;
        }

        return null;
    }
}

