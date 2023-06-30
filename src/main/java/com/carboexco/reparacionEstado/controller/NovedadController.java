package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.Novedad;
import com.carboexco.reparacionEstado.repository.NovedadRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/novedades")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NovedadController {

    private final NovedadRepository novedadRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public NovedadController(NovedadRepository novedadRepository) {
        this.novedadRepository = novedadRepository;
    }

    @GetMapping
    public ResponseEntity<List<Novedad>> getAllNovedades(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<Novedad> novedades = novedadRepository.findAll();
            return ResponseEntity.ok(novedades);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Novedad> getNovedadById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Novedad> novedad = novedadRepository.findById(id);
            if (novedad.isPresent()) {
                return ResponseEntity.ok(novedad.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<Novedad> createNovedad(@RequestHeader("Authorization") String bearerToken, @RequestBody Novedad novedad) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Novedad createdNovedad = novedadRepository.save(novedad);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdNovedad);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Novedad> updateNovedad(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody Novedad novedad) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Novedad> currentNovedad = novedadRepository.findById(id);
            if (currentNovedad.isPresent()) {
                Novedad updatedNovedad = currentNovedad.get();
                updatedNovedad.setIdUsuario(novedad.getIdUsuario());
                updatedNovedad.setFechaHora(novedad.getFechaHora());
                updatedNovedad.setObservacion(novedad.getObservacion());
                updatedNovedad.setIdFoto(novedad.getIdFoto());
                novedadRepository.save(updatedNovedad);
                return ResponseEntity.ok(updatedNovedad);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNovedad(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<Novedad> novedad = novedadRepository.findById(id);
            if (novedad.isPresent()) {
                novedadRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}