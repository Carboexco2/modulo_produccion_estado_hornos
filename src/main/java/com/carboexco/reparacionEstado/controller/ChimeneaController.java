package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Chimenea;
import com.carboexco.reparacionEstado.repository.ChimeneaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/chimeneas")
public class ChimeneaController {

    @Autowired
    ChimeneaRepository chimeneaRepository;

    @GetMapping
    public List<Chimenea> getChimeneaAll() {
        return chimeneaRepository.findAll();
    }



    @GetMapping("/{id}")
    public Chimenea getChimeneabyId(@PathVariable int id) {

        Optional<Chimenea> chimenea = chimeneaRepository.findById(id);

        if (chimenea.isPresent()) {
            return chimenea.get();
        }

        return null;
    }

    @PostMapping
    public Chimenea postChimenea(@RequestBody Chimenea chimenea) {
        chimeneaRepository.save(chimenea);
        return chimenea;
    }

    @PutMapping("/{id}")
    public Chimenea putChimeneabyId(@PathVariable int id, @RequestBody Chimenea chimenea) {

        Optional<Chimenea> chimeneaCurrent = chimeneaRepository.findById(id);

        if (chimeneaCurrent.isPresent()) {
            Chimenea chimeneaReturn = chimeneaCurrent.get();

            chimeneaReturn.setNombre(chimenea.getNombre());

            chimeneaRepository.save(chimeneaReturn);
            return chimeneaReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Chimenea deleteChimeneabyId(@PathVariable int id) {

        Optional<Chimenea> chimenea = chimeneaRepository.findById(id);

        if (chimenea.isPresent()) {
            Chimenea chimeneaReturn = chimenea.get();
            chimeneaRepository.deleteById(id);
            return chimeneaReturn;
        }

        return null;
    }
}