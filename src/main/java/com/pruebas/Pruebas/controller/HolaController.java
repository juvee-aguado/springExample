package com.pruebas.Pruebas.controller;

import com.pruebas.Pruebas.beans.RequestUsuario;
import com.pruebas.Pruebas.beans.Usuario;
import com.pruebas.Pruebas.services.UsuarioServices;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class HolaController {

    @Autowired
    private UsuarioServices service;

    @GetMapping(value = "usuarioU", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> usuarioU(
            @RequestParam(name = "nombre") String nombre
    ){
        Usuario u = service.getUsuarioUpperCase(nombre);
       return new ResponseEntity(u, HttpStatus.OK);
    }

    @GetMapping(value = "usuarioL", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> usuarioL(
            @RequestParam(name = "nombre") String nombre
    ){
        Usuario u = service.getUsuarioLoweCase(nombre);
        return new ResponseEntity(u, HttpStatus.OK);
    }

    @PostMapping(value = "insertaUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> insertUsuario(
            @RequestBody RequestUsuario usuario
            ){
        Usuario u = service.insertUsuario(usuario.getName(), usuario.getLastName(), usuario.getAge());
        return new ResponseEntity(u, HttpStatus.OK);
    }
}
