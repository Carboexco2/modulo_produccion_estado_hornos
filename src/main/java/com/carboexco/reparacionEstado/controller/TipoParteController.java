package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.TipoParte;
import com.carboexco.reparacionEstado.repository.TipoParteRepository;
import com.carboexco.reparacionEstado.security.TokenValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipos-parte")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoParteController {

    private final TipoParteRepository tipoParteRepository;
    private final TokenValidationService authorizador = new TokenValidationService("");

    @Autowired
    public TipoParteController(TipoParteRepository tipoParteRepository) {
        this.tipoParteRepository = tipoParteRepository;
    }

    @GetMapping
    public ResponseEntity<List<TipoParte>> getAllTiposParte(@RequestHeader("Authorization") String bearerToken) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            List<TipoParte> tiposParte = tipoParteRepository.findAll();
            return ResponseEntity.ok(tiposParte);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoParte> getTipoParteById(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<TipoParte> tipoParte = tipoParteRepository.findById(id);
            if (tipoParte.isPresent()) {
                return ResponseEntity.ok(tipoParte.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<TipoParte> createTipoParte(@RequestHeader("Authorization") String bearerToken, @RequestBody TipoParte tipoParte) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            TipoParte createdTipoParte = tipoParteRepository.save(tipoParte);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdTipoParte);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoParte> updateTipoParte(@RequestHeader("Authorization") String bearerToken, @PathVariable int id, @RequestBody TipoParte tipoParte) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<TipoParte> currentTipoParte = tipoParteRepository.findById(id);
            if (currentTipoParte.isPresent()) {
                TipoParte updatedTipoParte = currentTipoParte.get();
                updatedTipoParte.setNombre(tipoParte.getNombre());
                tipoParteRepository.save(updatedTipoParte);
                return ResponseEntity.ok(updatedTipoParte);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoParte(@RequestHeader("Authorization") String bearerToken, @PathVariable int id) {
        authorizador.setBearerToken(bearerToken);
        if (authorizador.callValidateTokenEndpoint().getStatusCodeValue() == 200) {
            Optional<TipoParte> tipoParte = tipoParteRepository.findById(id);
            if (tipoParte.isPresent()) {
                tipoParteRepository.deleteById(id);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}