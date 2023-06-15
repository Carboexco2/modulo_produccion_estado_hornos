package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Ducto;
import com.carboexco.reparacionEstado.repository.DuctoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ductos")
public class DuctoController {

    @Autowired
    private DuctoRepository ductoRepository;

    @GetMapping
    public List<Ducto> getAllDuctos() {
        return ductoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ducto getDuctoById(@PathVariable int id) {
        Optional<Ducto> ducto = ductoRepository.findById(id);

        if (ducto.isPresent()) {
            return ducto.get();
        }

        return null;
    }

    @PostMapping
    public Ducto createDucto(@RequestBody Ducto ducto) {
        return ductoRepository.save(ducto);
    }

    @PutMapping("/{id}")
    public Ducto updateDucto(@PathVariable int id, @RequestBody Ducto ducto) {
        Optional<Ducto> currentDucto = ductoRepository.findById(id);

        if (currentDucto.isPresent()) {
            Ducto updatedDucto = currentDucto.get();
            updatedDucto.setNombreDucto(ducto.getNombreDucto());
            updatedDucto.setLungitud(ducto.getLungitud());
            updatedDucto.setIdEstado(ducto.getIdEstado());
            updatedDucto.setTuberia(ducto.getTuberia());
            return ductoRepository.save(updatedDucto);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Ducto deleteDucto(@PathVariable int id) {
        Optional<Ducto> ducto = ductoRepository.findById(id);

        if (ducto.isPresent()) {
            Ducto deletedDucto = ducto.get();
            ductoRepository.deleteById(id);
            return deletedDucto;
        }

        return null;
    }
}
