package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.ParteHorno;
import com.carboexco.reparacionEstado.repository.ParteHornoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parteHornos")
public class ParteHornoController {

    @Autowired
    ParteHornoRepository parteHornoRepository;

    @GetMapping
    public List<ParteHorno> getParteHornoAll() {
        return parteHornoRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<ParteHorno> getTareaById(@PathVariable String id) {
        List<ParteHorno> parteHornos = parteHornoRepository.findAll();
        List<ParteHorno> parteHorno = new ArrayList<>();
        for (ParteHorno i : parteHornos) {
            if (id == i.getId().getIdHorno()){
                parteHorno.add(i);
            }
        }
        return parteHorno;
    }

    @GetMapping("/{idH}/{idP}")
    public ParteHorno getParteHornobyId(@PathVariable String idH,@PathVariable int idP) {

        List<ParteHorno> parteHornos = parteHornoRepository.findAll();
        List<ParteHorno> parteHorno = new ArrayList<>();
        for (ParteHorno i : parteHornos) {
            if (idH == i.getId().getIdHorno() && idP == i.getId().getIdParte()){
                parteHorno.add(i);
            }
        }

        return null;
    }

    @PostMapping
    public ParteHorno postParteHorno(@RequestBody ParteHorno parteHorno) {
        parteHornoRepository.save(parteHorno);
        return parteHorno;
    }

    @PutMapping("/{idH}/{idP}")
    public ParteHorno putParteHornobyId(@PathVariable String idH,@PathVariable int idP, @RequestBody ParteHorno parteHorno) {

        List<ParteHorno> parteHornos = parteHornoRepository.findAll();
        ParteHorno parteHornonuevo = new ParteHorno();
        for (ParteHorno i : parteHornos) {
            if (idH == i.getId().getIdHorno() && idP == i.getId().getIdParte()){

                ParteHorno parteHornoReturn = i;

                parteHornoReturn.setId(parteHorno.getId());

                parteHornoRepository.save(parteHornoReturn);
                return parteHornoReturn;
            }
        }

        return null;

    }


    @DeleteMapping("/{idH}/{idP}")
    public ParteHorno deleteParteHornobyId(@PathVariable String idH,@PathVariable int idP) {

        List<ParteHorno> parteHornos = parteHornoRepository.findAll();
        ParteHorno parteHorno = new ParteHorno();
        for (ParteHorno i : parteHornos) {
            if (idH == i.getId().getIdHorno() && idP == i.getId().getIdParte()) {

                ParteHorno parteHornoReturn = i;
                parteHornoRepository.deleteById(parteHornoReturn.getId());
                return parteHornoReturn;
            }
        }
        return null;

    }
}