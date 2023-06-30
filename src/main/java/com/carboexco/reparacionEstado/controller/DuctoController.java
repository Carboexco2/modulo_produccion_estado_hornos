package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Ducto;
import com.carboexco.reparacionEstado.repository.DuctoRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ductos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DuctoController {

    private final DuctoRepository ductoRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public DuctoController(DuctoRepository ductoRepository) {
        this.ductoRepository = ductoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Ducto>> getAllDuctos(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Ducto> ductos = ductoRepository.findAll();
            return ResponseEntity.ok(ductos);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ducto> getDuctoById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Ducto> ducto = ductoRepository.findById(id);
            if (ducto.isPresent()) {
                return ResponseEntity.ok(ducto.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Ducto> createDucto(@RequestHeader("Authorization") String bearerToken, @RequestBody Ducto ducto) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Ducto createdDucto = ductoRepository.save(ducto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDucto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ducto> updateDucto(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody Ducto ducto) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Ducto> currentDucto = ductoRepository.findById(id);
            if (currentDucto.isPresent()) {
                Ducto updatedDucto = currentDucto.get();
                updatedDucto.setNombreDucto(ducto.getNombreDucto());
                updatedDucto.setLungitud(ducto.getLungitud());
                updatedDucto.setIdEstado(ducto.getIdEstado());
                updatedDucto.setTuberia(ducto.getTuberia());
                ductoRepository.save(updatedDucto);
                return ResponseEntity.ok(updatedDucto);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDucto(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Ducto> ducto = ductoRepository.findById(id);
            if (ducto.isPresent()) {
                ductoRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}