package com.pruebas.Pruebas.controller;

import com.pruebas.Pruebas.beans.RequestUsuario;
import com.pruebas.Pruebas.entity.Usuario;
import com.pruebas.Pruebas.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if(u==null){
            return new ResponseEntity( HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(u, HttpStatus.OK);
        }

    }

    @GetMapping(value = "usuarioL", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> usuarioL(

            @RequestParam(name = "nombre") String nombre
    ){
        Usuario u = service.getUsuarioLoweCase(nombre);

        if( u==null ){
            return new ResponseEntity(u, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(u, HttpStatus.OK);
        }

    }

    @PostMapping(value = "insertaUsuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> insertUsuario(
            @RequestBody RequestUsuario usuario
            ){
        Usuario u = service.insertUsuario(usuario.getName(), usuario.getLastName(), usuario.getAge());
        return new ResponseEntity(u, HttpStatus.OK);
    }


    @GetMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> obtenerTodosLosUsuarios(
    ){
        List<Usuario> u = service.getTodosLosUsuarios();
        return new ResponseEntity(u, HttpStatus.OK);
    }

    @PutMapping(value = "actualiza_usuario/{id}")
    public ResponseEntity<Usuario> actualizaUsuario(
            @RequestBody RequestUsuario usuario,
            @PathVariable(name = "id") Long idUser
    ){
        Usuario u = service.actualizaUsuario(idUser, usuario);
        if(u == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(u, HttpStatus.OK);
        }

    }

}
