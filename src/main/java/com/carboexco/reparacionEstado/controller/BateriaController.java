package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Bateria;
import com.carboexco.reparacionEstado.entity.Chimenea;
import com.carboexco.reparacionEstado.repository.BateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/baterias")
public class BateriaController {

    @Autowired
    BateriaRepository bateriaRepository;

    @GetMapping
    public List<Bateria> getBateriaAll() {
        return bateriaRepository.findAll();
    }

    @GetMapping("/chimenea/{id}")
    public List<Bateria> getTareaById(@PathVariable int id) {
        List<Bateria> baterias = bateriaRepository.findAll();
        List<Bateria> bateriaChimenea = new ArrayList<>();
        for (Bateria i : baterias) {
            if (id == i.getIdChimenea().getId()){
                bateriaChimenea.add(i);
            }
        }
        return bateriaChimenea;
    }

    @GetMapping("/{id}")
    public Bateria getBateriabyId(@PathVariable int id) {

        Optional<Bateria> bateria = bateriaRepository.findById(id);

        if (bateria.isPresent()) {
            return bateria.get();
        }

        return null;
    }

    @PostMapping
    public Bateria postBateria(@RequestBody Bateria bateria) {
        bateriaRepository.save(bateria);
        return bateria;
    }

    @PutMapping("/{id}")
    public Bateria putBateriabyId(@PathVariable int id, @RequestBody Bateria bateria) {

        Optional<Bateria> bateriaCurrent = bateriaRepository.findById(id);

        if (bateriaCurrent.isPresent()) {
            Bateria bateriaReturn = bateriaCurrent.get();

            bateriaReturn.setNombre(bateria.getNombre());
            bateriaReturn.setUbicacion(bateria.getUbicacion());

            bateriaRepository.save(bateriaReturn);
            return bateriaReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Bateria deleteBateriabyId(@PathVariable int id) {

        Optional<Bateria> bateria = bateriaRepository.findById(id);

        if (bateria.isPresent()) {
            Bateria bateriaReturn = bateria.get();
            bateriaRepository.deleteById(id);
            return bateriaReturn;
        }

        return null;
    }
}