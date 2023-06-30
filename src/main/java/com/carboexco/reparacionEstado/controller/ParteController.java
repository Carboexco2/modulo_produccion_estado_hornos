package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Parte;
import com.carboexco.reparacionEstado.repository.ParteRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/partes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ParteController {

    private final ParteRepository parteRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public ParteController(ParteRepository parteRepository) {
        this.parteRepository = parteRepository;
    }

    @GetMapping
    public ResponseEntity<List<Parte>> getAllPartes(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Parte> partes = parteRepository.findAll();
            return ResponseEntity.ok(partes);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parte> getParteById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Parte> parte = parteRepository.findById(id);
            if (parte.isPresent()) {
                return ResponseEntity.ok(parte.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Parte> createParte(@RequestHeader("Authorization") String bearerToken, @RequestBody Parte parte) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Parte createdParte = parteRepository.save(parte);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdParte);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parte> updateParte(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody Parte parte) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Parte> currentParte = parteRepository.findById(id);
            if (currentParte.isPresent()) {
                Parte updatedParte = currentParte.get();
                updatedParte.setNombreParte(parte.getNombreParte());
                updatedParte.setIdPrioridad(parte.getIdPrioridad());
                updatedParte.setIdTipoParte(parte.getIdTipoParte());
                parteRepository.save(updatedParte);
                return ResponseEntity.ok(updatedParte);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParte(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Parte> parte = parteRepository.findById(id);
            if (parte.isPresent()) {
                parteRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}