package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.ParteBateria;
import com.carboexco.reparacionEstado.repository.ParteBateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parteBaterias")
public class ParteBateriaController {

    @Autowired
    ParteBateriaRepository parteBateriaRepository;

    @GetMapping
    public List<ParteBateria> getParteBateriaAll() {
        return parteBateriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<ParteBateria> getTareaById(@PathVariable int id) {
        List<ParteBateria> parteBaterias = parteBateriaRepository.findAll();
        List<ParteBateria> parteBateriaChimenea = new ArrayList<>();
        for (ParteBateria i : parteBaterias) {
            if (id == i.getId().getIdBateria()){
                parteBateriaChimenea.add(i);
            }
        }
        return parteBateriaChimenea;
    }

    @GetMapping("/{idB}/{idP}")
    public ParteBateria getParteBateriabyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteBateria> parteBaterias = parteBateriaRepository.findAll();
        List<ParteBateria> parteBateriaChimenea = new ArrayList<>();
        for (ParteBateria i : parteBaterias) {
            if (idB == i.getId().getIdBateria() && idP == i.getId().getIdParte()){
                parteBateriaChimenea.add(i);
            }
        }

        return null;
    }

    @PostMapping
    public ParteBateria postParteBateria(@RequestBody ParteBateria parteBateria) {
        parteBateriaRepository.save(parteBateria);
        return parteBateria;
    }

    @PutMapping("/{idB}/{idP}")
    public ParteBateria putParteBateriabyId(@PathVariable int idB,@PathVariable int idP, @RequestBody ParteBateria parteBateria) {

        List<ParteBateria> parteBaterias = parteBateriaRepository.findAll();
        ParteBateria parteBateriaChimenea = new ParteBateria();
        for (ParteBateria i : parteBaterias) {
            if (idB == i.getId().getIdBateria() && idP == i.getId().getIdParte()){

            ParteBateria parteBateriaReturn = i;

            parteBateriaReturn.setId(parteBateria.getId());

            parteBateriaRepository.save(parteBateriaReturn);
            return parteBateriaReturn;
        }
        }

        return null;

    }


    @DeleteMapping("/{idB}/{idP}")
    public ParteBateria deleteParteBateriabyId(@PathVariable int idB,@PathVariable int idP) {

            List<ParteBateria> parteBaterias = parteBateriaRepository.findAll();
            ParteBateria parteBateriaChimenea = new ParteBateria();
            for (ParteBateria i : parteBaterias) {
                if (idB == i.getId().getIdBateria() && idP == i.getId().getIdParte()) {

                    ParteBateria parteBateriaReturn = i;
                    parteBateriaRepository.deleteById(parteBateriaReturn.getId());
                    return parteBateriaReturn;
                }
            }
        return null;

    }
}