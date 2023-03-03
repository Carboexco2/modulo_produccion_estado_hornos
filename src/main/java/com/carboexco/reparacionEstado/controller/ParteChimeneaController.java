package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.ParteChimenea;
import com.carboexco.reparacionEstado.repository.ParteChimeneaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parteChimeneas")
public class ParteChimeneaController {

    @Autowired
    ParteChimeneaRepository parteChimeneaRepository;

    @GetMapping
    public List<ParteChimenea> getParteChimeneaAll() {
        return parteChimeneaRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<ParteChimenea> getTareaById(@PathVariable int id) {
        List<ParteChimenea> parteChimeneas = parteChimeneaRepository.findAll();
        List<ParteChimenea> parteChimeneaChimenea = new ArrayList<>();
        for (ParteChimenea i : parteChimeneas) {
            if (id == i.getId().getIdChimenea()){
                parteChimeneaChimenea.add(i);
            }
        }
        return parteChimeneaChimenea;
    }

    @GetMapping("/{idB}/{idP}")
    public ParteChimenea getParteChimeneabyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteChimenea> parteChimeneas = parteChimeneaRepository.findAll();
        List<ParteChimenea> parteChimenea = new ArrayList<>();
        for (ParteChimenea i : parteChimeneas) {
            if (idB == i.getId().getIdChimenea() && idP == i.getId().getIdParte()){
                parteChimenea.add(i);
            }
        }

        return null;
    }

    @PostMapping
    public ParteChimenea postParteChimenea(@RequestBody ParteChimenea parteChimenea) {
        parteChimeneaRepository.save(parteChimenea);
        return parteChimenea;
    }

    @PutMapping("/{idB}/{idP}")
    public ParteChimenea putParteChimeneabyId(@PathVariable int idB,@PathVariable int idP, @RequestBody ParteChimenea parteChimenea) {

        List<ParteChimenea> parteChimeneas = parteChimeneaRepository.findAll();
        ParteChimenea parteChimeneaChimenea = new ParteChimenea();
        for (ParteChimenea i : parteChimeneas) {
            if (idB == i.getId().getIdChimenea() && idP == i.getId().getIdParte()){

                ParteChimenea parteChimeneaReturn = i;

                parteChimeneaReturn.setId(parteChimenea.getId());

                parteChimeneaRepository.save(parteChimeneaReturn);
                return parteChimeneaReturn;
            }
        }

        return null;

    }


    @DeleteMapping("/{idB}/{idP}")
    public ParteChimenea deleteParteChimeneabyId(@PathVariable int idB,@PathVariable int idP) {

        List<ParteChimenea> parteChimeneas = parteChimeneaRepository.findAll();
        ParteChimenea parteChimeneaChimenea = new ParteChimenea();
        for (ParteChimenea i : parteChimeneas) {
            if (idB == i.getId().getIdChimenea() && idP == i.getId().getIdParte()) {

                ParteChimenea parteChimeneaReturn = i;
                parteChimeneaRepository.deleteById(parteChimeneaReturn.getId());
                return parteChimeneaReturn;
            }
        }
        return null;

    }
}