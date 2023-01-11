package com.pruebas.Pruebas.controller;

import com.pruebas.Pruebas.beans.RequestCereales;
import com.pruebas.Pruebas.entity.Cereales;
import com.pruebas.Pruebas.services.CerealesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class CerealesController {

    @Autowired
    private CerealesService service;

    @GetMapping(value = "cereales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cereales>> obtenerTodosLosCereales(){
        return new ResponseEntity<>(service.obtenerTodosLosCereales(), HttpStatus.OK);
    }

    @PostMapping(value = "insertarCereales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cereales> insertarCereales(
            @RequestBody RequestCereales cereales
    ) {
        Cereales c = service.insertarCereales(cereales.getNombre(), cereales.getCantidad(), cereales.getFecha(), cereales.getPrecio());
        return new ResponseEntity(c, HttpStatus.OK);
    }

    @PutMapping(value = "actualizaCereales/{id}")
    public ResponseEntity<Cereales> actualizaCereales(
            @RequestBody RequestCereales cereales,
            @PathVariable(name = "id") Long idCer
    ){
        Cereales c = service.actualizaCereales(idCer, cereales);
        if(c == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(c, HttpStatus.OK);
        }

    }
}
