package com.pruebas.Pruebas.services;

import com.pruebas.Pruebas.UsuarioDAO;
import com.pruebas.Pruebas.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {

    @Autowired
    UsuarioDAO dao;

    public Usuario getUsuarioUpperCase(String nombre){

        Usuario u = dao.getUsuario(nombre);
        if(u != null){
            u.setName(u.getName().toUpperCase());
            u.setLastName(u.getLastName().toUpperCase());
        }
        return  u;
    }

    public Usuario getUsuarioLoweCase(String nombre){

        Usuario u = dao.getUsuario(nombre);
        u.setName(u.getName().toLowerCase());
        u.setLastName(u.getLastName().toLowerCase());

        return  u;
    }

    public Usuario insertUsuario(String name, String lastName, String age){
        return  dao.insertUsuario(name, lastName, age);
    }

    public List<Usuario> getTodosLosUsuarios(){

        List<Usuario> listaUsuarios = dao.getTodosLosUsuarios();

        return  listaUsuarios;
    }

}
