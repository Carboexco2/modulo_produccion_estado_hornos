package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.ParteDucto;
import com.carboexco.reparacionEstado.repository.ParteDuctoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parteDuctos")
public class ParteDuctoController {

    @Autowired
    ParteDuctoRepository parteDuctoRepository;

    @GetMapping
    public List<ParteDucto> getParteDuctoAll() {
        return parteDuctoRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<ParteDucto> getTareaById(@PathVariable int id) {
        List<ParteDucto> parteDuctos = parteDuctoRepository.findAll();
        List<ParteDucto> parteDucto = new ArrayList<>();
        for (ParteDucto i : parteDuctos) {
            if (id == i.getId().getIdDucto()){
                parteDucto.add(i);
            }
        }
        return parteDucto;
    }

    @GetMapping("/{idB}/{idP}")
    public ParteDucto getParteDuctobyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteDucto> parteDuctos = parteDuctoRepository.findAll();
        List<ParteDucto> parteDucto = new ArrayList<>();
        for (ParteDucto i : parteDuctos) {
            if (idB == i.getId().getIdDucto() && idP == i.getId().getIdParte()){
                parteDucto.add(i);
            }
        }

        return null;
    }

    @PostMapping
    public ParteDucto postParteDucto(@RequestBody ParteDucto parteDucto) {
        parteDuctoRepository.save(parteDucto);
        return parteDucto;
    }

    @PutMapping("/{idB}/{idP}")
    public ParteDucto putParteDuctobyId(@PathVariable int idB,@PathVariable int idP, @RequestBody ParteDucto parteDucto) {

        List<ParteDucto> parteDuctos = parteDuctoRepository.findAll();
        ParteDucto parteDuctonuevo = new ParteDucto();
        for (ParteDucto i : parteDuctos) {
            if (idB == i.getId().getIdDucto() && idP == i.getId().getIdParte()){

                ParteDucto parteDuctoReturn = i;

                parteDuctoReturn.setId(parteDucto.getId());

                parteDuctoRepository.save(parteDuctoReturn);
                return parteDuctoReturn;
            }
        }

        return null;

    }


    @DeleteMapping("/{idB}/{idP}")
    public ParteDucto deleteParteDuctobyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteDucto> parteDuctos = parteDuctoRepository.findAll();
        ParteDucto parteDucto = new ParteDucto();
        for (ParteDucto i : parteDuctos) {
            if (idB == i.getId().getIdDucto() && idP == i.getId().getIdParte()) {

                ParteDucto parteDuctoReturn = i;
                parteDuctoRepository.deleteById(parteDuctoReturn.getId());
                return parteDuctoReturn;
            }
        }
        return null;

    }
}