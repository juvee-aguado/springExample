package com.pruebas.Pruebas.controller;

import com.pruebas.Pruebas.entity.Cereales;
import com.pruebas.Pruebas.services.CerealesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
