package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.ElementoParteNovedad;
import com.carboexco.reparacionEstado.repository.ElementoParteNovedadRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elementos-parte-novedad")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ElementoParteNovedadController {

    private final ElementoParteNovedadRepository elementoParteNovedadRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public ElementoParteNovedadController(ElementoParteNovedadRepository elementoParteNovedadRepository) {
        this.elementoParteNovedadRepository = elementoParteNovedadRepository;
    }

    @GetMapping
    public ResponseEntity<List<ElementoParteNovedad>> getAllElementosParteNovedad(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<ElementoParteNovedad> elementosParteNovedad = elementoParteNovedadRepository.findAll();
            return ResponseEntity.ok(elementosParteNovedad);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElementoParteNovedad> getElementoParteNovedadById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParteNovedad> elementoParteNovedad = elementoParteNovedadRepository.findById(id);
            if (elementoParteNovedad.isPresent()) {
                return ResponseEntity.ok(elementoParteNovedad.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<ElementoParteNovedad> createElementoParteNovedad(@RequestHeader("Authorization") String bearerToken, @RequestBody ElementoParteNovedad elementoParteNovedad) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            ElementoParteNovedad createdElementoParteNovedad = elementoParteNovedadRepository.save(elementoParteNovedad);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdElementoParteNovedad);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElementoParteNovedad> updateElementoParteNovedad(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id, @RequestBody ElementoParteNovedad elementoParteNovedad) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParteNovedad> currentElementoParteNovedad = elementoParteNovedadRepository.findById(id);
            if (currentElementoParteNovedad.isPresent()) {
                ElementoParteNovedad updatedElementoParteNovedad = currentElementoParteNovedad.get();
                updatedElementoParteNovedad.setIdElementoParte(elementoParteNovedad.getIdElementoParte());
                updatedElementoParteNovedad.setIdNovedad(elementoParteNovedad.getIdNovedad());
                elementoParteNovedadRepository.save(updatedElementoParteNovedad);
                return ResponseEntity.ok(updatedElementoParteNovedad);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementoParteNovedad(@RequestHeader("Authorization") String bearerToken, @PathVariable Long id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<ElementoParteNovedad> elementoParteNovedad = elementoParteNovedadRepository.findById(id);
            if (elementoParteNovedad.isPresent()) {
                elementoParteNovedadRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}