package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.ElementoParte;
import com.carboexco.reparacionEstado.repository.ElementoParteRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elementos-parte")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ElementoParteController {

    private final ElementoParteRepository elementoParteRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public ElementoParteController(ElementoParteRepository elementoParteRepository) {
        this.elementoParteRepository = elementoParteRepository;
    }

    @GetMapping
    public ResponseEntity<List<ElementoParte>> getAllElementosParte(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<ElementoParte> elementosParte = elementoParteRepository.findAll();
            return ResponseEntity.ok(elementosParte);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElementoParte> getElementoParteById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParte> elementoParte = elementoParteRepository.findById(id);
            if (elementoParte.isPresent()) {
                return ResponseEntity.ok(elementoParte.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<ElementoParte> createElementoParte(@RequestHeader("Authorization") String bearerToken, @RequestBody ElementoParte elementoParte) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            ElementoParte createdElementoParte = elementoParteRepository.save(elementoParte);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdElementoParte);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElementoParte> updateElementoParte(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody ElementoParte elementoParte) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParte> currentElementoParte = elementoParteRepository.findById(id);
            if (currentElementoParte.isPresent()) {
                ElementoParte updatedElementoParte = currentElementoParte.get();
                updatedElementoParte.setIdParte(elementoParte.getIdParte());
                updatedElementoParte.setIdElemento(elementoParte.getIdElemento());
                updatedElementoParte.setIdEstado(elementoParte.getIdEstado());
                updatedElementoParte.setLongitud(elementoParte.getLongitud());
                updatedElementoParte.setNombre(elementoParte.getNombre());
                elementoParteRepository.save(updatedElementoParte);
                return ResponseEntity.ok(updatedElementoParte);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementoParte(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParte> elementoParte = elementoParteRepository.findById(id);
            if (elementoParte.isPresent()) {
                elementoParteRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}