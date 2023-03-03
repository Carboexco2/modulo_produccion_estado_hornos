package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Horno;
import com.carboexco.reparacionEstado.repository.HornoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/hornos")
public class HornoController {

    @Autowired
    HornoRepository hornoRepository;

    @GetMapping
    public List<Horno> getHornoAll() {
        return hornoRepository.findAll();
    }

    @GetMapping("/bateria/{id}")
    public List<Horno> getTareaById(@PathVariable int id) {
        List<Horno> hornos = hornoRepository.findAll();
        List<Horno> hornoChimenea = new ArrayList<>();
        for (Horno i : hornos) {
            if (id == i.getIdBateria().getId()){
                hornoChimenea.add(i);
            }
        }
        return hornoChimenea;
    }

    @GetMapping("/{id}")
    public Horno getHornobyId(@PathVariable String id) {

        Optional<Horno> horno = hornoRepository.findById(id);

        if (horno.isPresent()) {
            return horno.get();
        }

        return null;
    }

    @PostMapping
    public Horno postHorno(@RequestBody Horno horno) {
        hornoRepository.save(horno);
        return horno;
    }

    @PutMapping("/{id}")
    public Horno putHornobyId(@PathVariable String id, @RequestBody Horno horno) {

        Optional<Horno> hornoCurrent = hornoRepository.findById(id);

        if (hornoCurrent.isPresent()) {
            Horno hornoReturn = hornoCurrent.get();

            hornoReturn.setIdBateria(horno.getIdBateria());
            hornoReturn.setIdOperacion(horno.getIdOperacion());
            hornoReturn.setIdEstado(horno.getIdEstado());
            hornoReturn.setId(horno.getId());

            hornoRepository.save(hornoReturn);
            return hornoReturn;
        }

        return null;
    }


    @DeleteMapping("/{id}")
    public Horno deleteHornobyId(@PathVariable String id) {

        Optional<Horno> horno = hornoRepository.findById(id);

        if (horno.isPresent()) {
            Horno hornoReturn = horno.get();
            hornoRepository.deleteById(id);
            return hornoReturn;
        }

        return null;
    }
}