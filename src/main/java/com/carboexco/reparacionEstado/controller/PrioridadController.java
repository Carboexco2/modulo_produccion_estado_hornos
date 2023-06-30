package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Prioridad;
import com.carboexco.reparacionEstado.repository.PrioridadRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prioridades")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PrioridadController {

    private final PrioridadRepository prioridadRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public PrioridadController(PrioridadRepository prioridadRepository) {
        this.prioridadRepository = prioridadRepository;
    }

    @GetMapping
    public ResponseEntity<List<Prioridad>> getAllPrioridades(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Prioridad> prioridades = prioridadRepository.findAll();
            return ResponseEntity.ok(prioridades);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prioridad> getPrioridadById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Prioridad> prioridad = prioridadRepository.findById(id);
            if (prioridad.isPresent()) {
                return ResponseEntity.ok(prioridad.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Prioridad> createPrioridad(@RequestHeader("Authorization") String bearerToken, @RequestBody Prioridad prioridad) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Prioridad createdPrioridad = prioridadRepository.save(prioridad);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPrioridad);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prioridad> updatePrioridad(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody Prioridad prioridad) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Prioridad> currentPrioridad = prioridadRepository.findById(id);
            if (currentPrioridad.isPresent()) {
                Prioridad updatedPrioridad = currentPrioridad.get();
                updatedPrioridad.setNombrePrioridad(prioridad.getNombrePrioridad());
                prioridadRepository.save(updatedPrioridad);
                return ResponseEntity.ok(updatedPrioridad);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrioridad(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Prioridad> prioridad = prioridadRepository.findById(id);
            if (prioridad.isPresent()) {
                prioridadRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}