package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Bateria;
import com.carboexco.reparacionEstado.repository.BateriaRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/baterias")
public class BateriaController {

    private final BateriaRepository bateriaRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public BateriaController(BateriaRepository bateriaRepository) {
        this.bateriaRepository = bateriaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Bateria>> getAllBaterias(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Bateria> baterias = bateriaRepository.findAll();
            return ResponseEntity.ok(baterias);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/chimenea/{id}")
    public ResponseEntity<List<Bateria>> getTareaById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Bateria> baterias = bateriaRepository.findByIdChimenea_IdOrderByNombreAsc(id);
            return ResponseEntity.ok(baterias);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Bateria>> getBateriaById(@RequestHeader("Authorization") String bearerToken, @PathVariable Integer id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Bateria> bateria = bateriaRepository.findById(id);
            if (bateria.isPresent()) {
                return ResponseEntity.ok(bateria);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Bateria> createBateria(@RequestHeader("Authorization") String bearerToken, @RequestBody Bateria bateria) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Bateria createdBateria = bateriaRepository.save(bateria);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBateria);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bateria> updateBateria(@RequestHeader("Authorization") String bearerToken, @PathVariable Integer id, @RequestBody Bateria bateriaDetails) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Bateria> optionalBateria = bateriaRepository.findById(id);
            if (optionalBateria.isPresent()) {
                Bateria bateria = optionalBateria.get();
                bateria.setIdEstado(bateriaDetails.getIdEstado());
                bateria.setNombre(bateriaDetails.getNombre());
                bateria.setIdUbicacion(bateriaDetails.getIdUbicacion());
                bateria.setIdChimenea(bateriaDetails.getIdChimenea());
                Bateria updatedBateria = bateriaRepository.save(bateria);
                return ResponseEntity.ok(updatedBateria);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bateria> deleteBateria(@RequestHeader("Authorization") String bearerToken, @PathVariable Integer id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            bateriaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
