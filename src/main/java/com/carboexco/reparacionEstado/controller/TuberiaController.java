package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Tuberia;
import com.carboexco.reparacionEstado.entity.Chimenea;
import com.carboexco.reparacionEstado.repository.TuberiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tuberias")
public class TuberiaController {

    @Autowired
    TuberiaRepository tuberiaRepository;

    @GetMapping
    public List<Tuberia> getTuberiaAll() {
        return tuberiaRepository.findAll();
    }



    @GetMapping("/{id}")
    public Tuberia getTuberiabyId(@PathVariable int id) {

        Optional<Tuberia> tuberia = tuberiaRepository.findById(id);

        if (tuberia.isPresent()) {
            return tuberia.get();
        }

        return null;
    }

    @PostMapping
    public Tuberia postTuberia(@RequestBody Tuberia tuberia) {
        tuberiaRepository.save(tuberia);
        return tuberia;
    }

    @PutMapping("/{id}")
    public Tuberia putTuberiabyId(@PathVariable int id, @RequestBody Tuberia tuberia) {

        Optional<Tuberia> tuberiaCurrent = tuberiaRepository.findById(id);

        if (tuberiaCurrent.isPresent()) {
            Tuberia tuberiaReturn = tuberiaCurrent.get();

            tuberiaReturn.setNombreTuberia(tuberia.getNombreTuberia());
            tuberiaReturn.setLongitud(tuberia.getLongitud());

            tuberiaRepository.save(tuberiaReturn);
            return tuberiaReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Tuberia deleteTuberiabyId(@PathVariable int id) {

        Optional<Tuberia> tuberia = tuberiaRepository.findById(id);

        if (tuberia.isPresent()) {
            Tuberia tuberiaReturn = tuberia.get();
            tuberiaRepository.deleteById(id);
            return tuberiaReturn;
        }

        return null;
    }
}