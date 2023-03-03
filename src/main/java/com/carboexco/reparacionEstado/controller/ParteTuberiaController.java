package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.ParteTuberia;
import com.carboexco.reparacionEstado.repository.ParteTuberiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parteTuberias")
public class ParteTuberiaController {

    @Autowired
    ParteTuberiaRepository parteTuberiaRepository;

    @GetMapping
    public List<ParteTuberia> getParteTuberiaAll() {
        return parteTuberiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<ParteTuberia> getTareaById(@PathVariable int id) {
        List<ParteTuberia> parteTuberias = parteTuberiaRepository.findAll();
        List<ParteTuberia> parteTuberia = new ArrayList<>();
        for (ParteTuberia i : parteTuberias) {
            if (id == i.getId().getIdTuberia()){
                parteTuberia.add(i);
            }
        }
        return parteTuberia;
    }

    @GetMapping("/{idB}/{idP}")
    public ParteTuberia getParteTuberiabyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteTuberia> parteTuberias = parteTuberiaRepository.findAll();
        List<ParteTuberia> parteTuberia = new ArrayList<>();
        for (ParteTuberia i : parteTuberias) {
            if (idB == i.getId().getIdTuberia() && idP == i.getId().getIdParte()){
                parteTuberia.add(i);
            }
        }

        return null;
    }

    @PostMapping
    public ParteTuberia postParteTuberia(@RequestBody ParteTuberia parteTuberia) {
        parteTuberiaRepository.save(parteTuberia);
        return parteTuberia;
    }

    @PutMapping("/{idB}/{idP}")
    public ParteTuberia putParteTuberiabyId(@PathVariable int idB,@PathVariable int idP, @RequestBody ParteTuberia parteTuberia) {

        List<ParteTuberia> parteTuberias = parteTuberiaRepository.findAll();
        ParteTuberia parteTuberianuevo = new ParteTuberia();
        for (ParteTuberia i : parteTuberias) {
            if (idB == i.getId().getIdTuberia() && idP == i.getId().getIdParte()){

                ParteTuberia parteTuberiaReturn = i;

                parteTuberiaReturn.setId(parteTuberia.getId());

                parteTuberiaRepository.save(parteTuberiaReturn);
                return parteTuberiaReturn;
            }
        }

        return null;

    }


    @DeleteMapping("/{idB}/{idP}")
    public ParteTuberia deleteParteTuberiabyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteTuberia> parteTuberias = parteTuberiaRepository.findAll();
        ParteTuberia parteTuberia = new ParteTuberia();
        for (ParteTuberia i : parteTuberias) {
            if (idB == i.getId().getIdTuberia() && idP == i.getId().getIdParte()) {

                ParteTuberia parteTuberiaReturn = i;
                parteTuberiaRepository.deleteById(parteTuberiaReturn.getId());
                return parteTuberiaReturn;
            }
        }
        return null;

    }
}