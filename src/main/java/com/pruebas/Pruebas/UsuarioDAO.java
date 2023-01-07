package com.pruebas.Pruebas;

import com.pruebas.Pruebas.beans.Usuario;
import com.pruebas.Pruebas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDAO {

    @Autowired
    private UsuarioRepository repository;

    public Usuario getUsuario(String nombre){

        Usuario u = repository.obtenerUsuarioNombre(nombre);
        return  u;
    }

    public Usuario insertUsuario(String name, String lastName, String age){
        Usuario u =  new Usuario();
        u.setName(name);
        u.setLastName(lastName);
        u.setAge(age);
        repository.save(u);
        return  repository.obtenerUsuarioNombre(name);
    }

}
