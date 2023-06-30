package com.carboexco.reparacionEstado.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class statusController {
    @GetMapping({"/status"})
    public String status(){
        return "ESTADO DE LA API REST DEL MODULO_PRODUCCION_REPARACIONESTADO";
    }
}
