package com.carboexco.reparacionEstado.controller;
import com.carboexco.reparacionEstado.entity.Estado;
import com.carboexco.reparacionEstado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.carboexco.reparacionEstado.entity.Estado;
import com.carboexco.reparacionEstado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.carboexco.reparacionEstado.entity.Estado;
import com.carboexco.reparacionEstado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    // Obtener todos los estados
    @GetMapping
    public List<Estado> getAllEstados() {
        return estadoRepository.findAll();
    }

    // Obtener un estado por su ID
    @GetMapping("/{id}")
    public Estado getEstadoById(@PathVariable int id) {
        Optional<Estado> estado = estadoRepository.findById(id);

        if (estado.isPresent()) {
            return estado.get();
        }

        return null;
    }

    // Crear un nuevo estado
    @PostMapping
    public Estado createEstado(@RequestBody Estado estado) {
        return estadoRepository.save(estado);
    }

    // Actualizar un estado existente por su ID
    @PutMapping("/{id}")
    public Estado updateEstado(@PathVariable int id, @RequestBody Estado estado) {
        Optional<Estado> currentEstado = estadoRepository.findById(id);

        if (currentEstado.isPresent()) {
            Estado updatedEstado = currentEstado.get();
            updatedEstado.setNombreEstado(estado.getNombreEstado());
            return estadoRepository.save(updatedEstado);
        }

        return null;
    }

    // Eliminar un estado por su ID
    @DeleteMapping("/{id}")
    public Estado deleteEstado(@PathVariable int id) {
        Optional<Estado> estado = estadoRepository.findById(id);

        if (estado.isPresent()) {
            Estado deletedEstado = estado.get();
            estadoRepository.deleteById(id);
            return deletedEstado;
        }

        return null;
    }
}
