package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Chimenea;
import com.carboexco.reparacionEstado.repository.ChimeneaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/chimeneas")
public class ChimeneaController {

    @Autowired
    ChimeneaRepository chimeneaRepository;

    @GetMapping
    public List<Chimenea> getChimeneaAll() {
        return chimeneaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Chimenea getChimeneaById(@PathVariable int id) {
        Optional<Chimenea> chimenea = chimeneaRepository.findById(id);
        return chimenea.orElse(null);
    }

    @PostMapping
    public Chimenea postChimenea(@RequestBody Chimenea chimenea) {
        chimeneaRepository.save(chimenea);
        return chimenea;
    }

    @PutMapping("/{id}")
    public Chimenea putChimeneaById(@PathVariable int id, @RequestBody Chimenea chimenea) {
        Optional<Chimenea> currentChimenea = chimeneaRepository.findById(id);

        if (currentChimenea.isPresent()) {
            Chimenea updatedChimenea = currentChimenea.get();
            updatedChimenea.setNombre(chimenea.getNombre());
            updatedChimenea.setEstadoOperativo(chimenea.getEstadoOperativo());
            chimeneaRepository.save(updatedChimenea);
            return updatedChimenea;
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Chimenea deleteChimeneaById(@PathVariable int id) {
        Optional<Chimenea> chimenea = chimeneaRepository.findById(id);

        if (chimenea.isPresent()) {
            Chimenea deletedChimenea = chimenea.get();
            chimeneaRepository.deleteById(id);
            return deletedChimenea;
        }

        return null;
    }
}
