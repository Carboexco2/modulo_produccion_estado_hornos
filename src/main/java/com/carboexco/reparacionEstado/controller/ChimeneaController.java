package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Chimenea;
import com.carboexco.reparacionEstado.repository.ChimeneaRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chimeneas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChimeneaController {

    private final ChimeneaRepository chimeneaRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public ChimeneaController(ChimeneaRepository chimeneaRepository) {
        this.chimeneaRepository = chimeneaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Chimenea>> getChimeneaAll(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Chimenea> chimeneas = chimeneaRepository.findAll();
            return ResponseEntity.ok(chimeneas);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chimenea> getChimeneaById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Chimenea> chimenea = chimeneaRepository.findById(id);
            if (chimenea.isPresent()) {
                return ResponseEntity.ok(chimenea.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Chimenea> postChimenea(@RequestHeader("Authorization") String bearerToken, @RequestBody Chimenea chimenea) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Chimenea createdChimenea = chimeneaRepository.save(chimenea);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdChimenea);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Chimenea> putChimeneaById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody Chimenea chimenea) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Chimenea> currentChimenea = chimeneaRepository.findById(id);
            if (currentChimenea.isPresent()) {
                Chimenea updatedChimenea = currentChimenea.get();
                updatedChimenea.setNombre(chimenea.getNombre());
                updatedChimenea.setEstadoOperativo(chimenea.getEstadoOperativo());
                chimeneaRepository.save(updatedChimenea);
                return ResponseEntity.ok(updatedChimenea);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChimeneaById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Chimenea> chimenea = chimeneaRepository.findById(id);
            if (chimenea.isPresent()) {
                chimeneaRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}