package com.carboexco.reparacionEstado.controller;

import com.carboexco.reparacionEstado.entity.TipoParte;
import com.carboexco.reparacionEstado.repository.TipoParteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/tipos-parte")
public class TipoParteController {

    @Autowired
    private TipoParteRepository tipoParteRepository;

    // Obtener todos los tipos de parte
    @GetMapping
    public List<TipoParte> getAllTiposParte() {
        return tipoParteRepository.findAll();
    }

    // Obtener un tipo de parte por su ID
    @GetMapping("/{id}")
    public TipoParte getTipoParteById(@PathVariable int id) {
        Optional<TipoParte> tipoParte = tipoParteRepository.findById(id);

        if (tipoParte.isPresent()) {
            return tipoParte.get();
        }

        return null;
    }

    // Crear un nuevo tipo de parte
    @PostMapping
    public TipoParte createTipoParte(@RequestBody TipoParte tipoParte) {
        return tipoParteRepository.save(tipoParte);
    }

    // Actualizar un tipo de parte existente por su ID
    @PutMapping("/{id}")
    public TipoParte updateTipoParte(@PathVariable int id, @RequestBody TipoParte tipoParte) {
        Optional<TipoParte> currentTipoParte = tipoParteRepository.findById(id);

        if (currentTipoParte.isPresent()) {
            TipoParte updatedTipoParte = currentTipoParte.get();
            updatedTipoParte.setNombre(tipoParte.getNombre());
            return tipoParteRepository.save(updatedTipoParte);
        }

        return null;
    }

    // Eliminar un tipo de parte por su ID
    @DeleteMapping("/{id}")
    public TipoParte deleteTipoParte(@PathVariable int id) {
        Optional<TipoParte> tipoParte = tipoParteRepository.findById(id);

        if (tipoParte.isPresent()) {
            TipoParte deletedTipoParte = tipoParte.get();
            tipoParteRepository.deleteById(id);
            return deletedTipoParte;
        }

        return null;
    }
}

