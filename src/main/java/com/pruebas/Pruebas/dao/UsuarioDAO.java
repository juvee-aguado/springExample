package com.pruebas.Pruebas.dao;

import com.pruebas.Pruebas.entity.Usuario;
import com.pruebas.Pruebas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDAO {

    @Autowired
    private UsuarioRepository repository;

    public Usuario getUsuario(String nombre){

        Usuario u = repository.obtenerUsuarioNombre(nombre);
        return  u;
    }

    public Usuario getUsuarioById(Long id){
        Optional<Usuario> usuarioOpcional = repository.findById(id);
        if(usuarioOpcional.isPresent()){
            return  usuarioOpcional.get();
        }else{
            return null;
        }
    }

    public Usuario insertUsuario(String name, String lastName, String age){
        Usuario u =  new Usuario();
        u.setName(name);
        u.setLastName(lastName);
        u.setAge(age);
        repository.save(u);
        return  repository.obtenerUsuarioNombre(name);
    }

    public List<Usuario> getTodosLosUsuarios(){

        Iterator<Usuario> iter = repository.findAll().iterator();
        List<Usuario> copy = new ArrayList<Usuario>();
        while (iter.hasNext()){
            copy.add(iter.next());
        }

        return  copy;
    }

    public Usuario actualizaUsuario(Usuario u){
        repository.save(u);
        Optional<Usuario> usuarioOpcional = repository.findById(u.getId());
        if(usuarioOpcional.isPresent()){
            return usuarioOpcional.get();
        }else{
            return null;
        }
    }

}
