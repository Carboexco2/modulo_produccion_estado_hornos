package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Ducto;
import com.carboexco.reparacionEstado.entity.Chimenea;
import com.carboexco.reparacionEstado.repository.DuctoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/ductos")
public class DuctoController {

    @Autowired
    DuctoRepository ductoRepository;

    @GetMapping
    public List<Ducto> getDuctoAll() {
        return ductoRepository.findAll();
    }


    @GetMapping("/{id}")
    public Ducto getDuctobyId(@PathVariable int id) {

        Optional<Ducto> ducto = ductoRepository.findById(id);

        if (ducto.isPresent()) {
            return ducto.get();
        }

        return null;
    }

    @PostMapping
    public Ducto postDucto(@RequestBody Ducto ducto) {
        ductoRepository.save(ducto);
        return ducto;
    }

    @PutMapping("/{id}")
    public Ducto putDuctobyId(@PathVariable int id, @RequestBody Ducto ducto) {

        Optional<Ducto> ductoCurrent = ductoRepository.findById(id);

        if (ductoCurrent.isPresent()) {
            Ducto ductoReturn = ductoCurrent.get();

            ductoReturn.setNombreDucto(ducto.getNombreDucto());
            ductoReturn.setLungitud(ducto.getLungitud());

            ductoRepository.save(ductoReturn);
            return ductoReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Ducto deleteDuctobyId(@PathVariable int id) {

        Optional<Ducto> ducto = ductoRepository.findById(id);

        if (ducto.isPresent()) {
            Ducto ductoReturn = ducto.get();
            ductoRepository.deleteById(id);
            return ductoReturn;
        }

        return null;
    }
}