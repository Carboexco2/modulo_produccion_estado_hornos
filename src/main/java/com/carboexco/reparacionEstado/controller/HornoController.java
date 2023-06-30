package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Horno;
import com.carboexco.reparacionEstado.repository.HornoRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hornos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HornoController {

    private final HornoRepository hornoRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public HornoController(HornoRepository hornoRepository) {
        this.hornoRepository = hornoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Horno>> getAllHornos(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Horno> hornos = hornoRepository.findAll();
            return ResponseEntity.ok(hornos);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horno> getHornoById(@RequestHeader("Authorization") String bearerToken, @PathVariable String id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Horno> horno = hornoRepository.findById(id);
            if (horno.isPresent()) {
                return ResponseEntity.ok(horno.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Horno> createHorno(@RequestHeader("Authorization") String bearerToken, @RequestBody Horno horno) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Horno createdHorno = hornoRepository.save(horno);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdHorno);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horno> updateHorno(@RequestHeader("Authorization") String bearerToken, @PathVariable String id, @RequestBody Horno horno) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Horno> currentHorno = hornoRepository.findById(id);
            if (currentHorno.isPresent()) {
                Horno updatedHorno = currentHorno.get();
                updatedHorno.setIdBateria(horno.getIdBateria());
                updatedHorno.setIdEstado(horno.getIdEstado());
                updatedHorno.setIdOperacion(horno.getIdOperacion());
                hornoRepository.save(updatedHorno);
                return ResponseEntity.ok(updatedHorno);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHorno(@RequestHeader("Authorization") String bearerToken, @PathVariable String id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Horno> horno = hornoRepository.findById(id);
            if (horno.isPresent()) {
                hornoRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}