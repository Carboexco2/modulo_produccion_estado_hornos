package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Bateria;
import com.carboexco.reparacionEstado.repository.BateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/baterias")
public class BateriaController {
    private final BateriaRepository bateriaRepository;

    @Autowired
    public BateriaController(BateriaRepository bateriaRepository) {
        this.bateriaRepository = bateriaRepository;
    }

    @GetMapping
    public List<Bateria> getAllBaterias() {
        return bateriaRepository.findAll();
    }

    @GetMapping("/chimenea/{id}")
    public List<Bateria> getTareaById(@PathVariable int id) {
        List<Bateria> baterias = bateriaRepository.findByIdChimenea_IdOrderByNombreAsc(id);
        List<Bateria> bateriaChimenea = new ArrayList<>();
        for (Bateria i : baterias) {
            if (id == i.getIdChimenea().getId()) {
                bateriaChimenea.add(i);
            }
        }
        return bateriaChimenea;
    }

    @GetMapping("/{id}")
    public Optional<Bateria> getBateriaById(@PathVariable Integer id) {
        return bateriaRepository.findById(id);
    }

    @PostMapping
    public Bateria createBateria(@RequestBody Bateria bateria) {
        return bateriaRepository.save(bateria);
    }

    @PutMapping("/{id}")
    public Bateria updateBateria(@PathVariable Integer id, @RequestBody Bateria bateriaDetails) {
        Optional<Bateria> optionalBateria = bateriaRepository.findById(id);
        if (optionalBateria.isPresent()) {
            Bateria bateria = optionalBateria.get();
            bateria.setIdEstado(bateriaDetails.getIdEstado());
            bateria.setNombre(bateriaDetails.getNombre());
            bateria.setIdUbicacion(bateriaDetails.getIdUbicacion());
            bateria.setIdChimenea(bateriaDetails.getIdChimenea());
            return bateriaRepository.save(bateria);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBateria(@PathVariable Integer id) {
        bateriaRepository.deleteById(id);
    }
}
