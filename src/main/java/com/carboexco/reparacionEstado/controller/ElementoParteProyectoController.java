package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.ElementoParteProyecto;
import com.carboexco.reparacionEstado.entity.ElementoParteProyectoId;
import com.carboexco.reparacionEstado.repository.ElementoParteProyectoRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elementos-parte-proyecto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ElementoParteProyectoController {

    private final ElementoParteProyectoRepository elementoParteProyectoRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public ElementoParteProyectoController(ElementoParteProyectoRepository elementoParteProyectoRepository) {
        this.elementoParteProyectoRepository = elementoParteProyectoRepository;
    }

    @GetMapping
    public ResponseEntity<List<ElementoParteProyecto>> getAllElementosParteProyecto(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<ElementoParteProyecto> elementosParteProyecto = elementoParteProyectoRepository.findAll();
            return ResponseEntity.ok(elementosParteProyecto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElementoParteProyecto> getElementoParteProyectoById(@RequestHeader("Authorization") String bearerToken, @PathVariable ElementoParteProyectoId id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParteProyecto> elementoParteProyecto = elementoParteProyectoRepository.findById(id);
            if (elementoParteProyecto.isPresent()) {
                return ResponseEntity.ok(elementoParteProyecto.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<ElementoParteProyecto> createElementoParteProyecto(@RequestHeader("Authorization") String bearerToken, @RequestBody ElementoParteProyecto elementoParteProyecto) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            ElementoParteProyecto createdElementoParteProyecto = elementoParteProyectoRepository.save(elementoParteProyecto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdElementoParteProyecto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElementoParteProyecto> updateElementoParteProyecto(@RequestHeader("Authorization") String bearerToken, @PathVariable ElementoParteProyectoId id, @RequestBody ElementoParteProyecto elementoParteProyecto) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParteProyecto> currentElementoParteProyecto = elementoParteProyectoRepository.findById(id);
            if (currentElementoParteProyecto.isPresent()) {
                ElementoParteProyecto updatedElementoParteProyecto = currentElementoParteProyecto.get();
                updatedElementoParteProyecto.setFecha(elementoParteProyecto.getFecha());
                elementoParteProyectoRepository.save(updatedElementoParteProyecto);
                return ResponseEntity.ok(updatedElementoParteProyecto);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementoParteProyecto(@RequestHeader("Authorization") String bearerToken, @PathVariable ElementoParteProyectoId id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParteProyecto> elementoParteProyecto = elementoParteProyectoRepository.findById(id);
            if (elementoParteProyecto.isPresent()) {
                elementoParteProyectoRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}