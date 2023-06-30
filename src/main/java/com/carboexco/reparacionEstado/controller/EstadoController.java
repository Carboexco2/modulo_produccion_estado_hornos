package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Estado;
import com.carboexco.reparacionEstado.repository.EstadoRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public EstadoController(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Estado>> getAllEstados(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Estado> estados = estadoRepository.findAll();
            return ResponseEntity.ok(estados);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Estado> estado = estadoRepository.findById(id);
            if (estado.isPresent()) {
                return ResponseEntity.ok(estado.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestHeader("Authorization") String bearerToken, @RequestBody Estado estado) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Estado createdEstado = estadoRepository.save(estado);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEstado);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estado> updateEstado(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody Estado estado) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Estado> currentEstado = estadoRepository.findById(id);
            if (currentEstado.isPresent()) {
                Estado updatedEstado = currentEstado.get();
                updatedEstado.setNombreEstado(estado.getNombreEstado());
                estadoRepository.save(updatedEstado);
                return ResponseEntity.ok(updatedEstado);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Estado> estado = estadoRepository.findById(id);
            if (estado.isPresent()) {
                estadoRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
