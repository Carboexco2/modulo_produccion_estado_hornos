package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Parte;
import com.carboexco.reparacionEstado.repository.ParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/partes")
public class ParteController {

    @Autowired
    ParteRepository parteRepository;

    @GetMapping
    public List<Parte> getParteAll() {
        return parteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Parte getPartebyId(@PathVariable int id) {

        Optional<Parte> parte = parteRepository.findById(id);

        if (parte.isPresent()) {
            return parte.get();
        }

        return null;
    }

    @PostMapping
    public Parte postParte(@RequestBody Parte parte) {
        parteRepository.save(parte);
        return parte;
    }

    @PutMapping("/{id}")
    public Parte putPartebyId(@PathVariable int id, @RequestBody Parte parte) {

        Optional<Parte> parteCurrent = parteRepository.findById(id);

        if (parteCurrent.isPresent()) {
            Parte parteReturn = parteCurrent.get();

            parteReturn.setNombreParte(parte.getNombreParte());

            parteRepository.save(parteReturn);
            return parteReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Parte deletePartebyId(@PathVariable int id) {

        Optional<Parte> parte = parteRepository.findById(id);

        if (parte.isPresent()) {
            Parte parteReturn = parte.get();
            parteRepository.deleteById(id);
            return parteReturn;
        }

        return null;
    }
}