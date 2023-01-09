package com.pruebas.Pruebas.dao;

import com.pruebas.Pruebas.entity.Cereales;
import com.pruebas.Pruebas.entity.Usuario;
import com.pruebas.Pruebas.repository.CerealesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CerealesDAO {

    @Autowired
    private CerealesRepository repository;

    public List<Cereales> obtenerTodosLosCereales (){
        Iterator<Cereales> iter = repository.findAll().iterator();
        List<Cereales> copy = new ArrayList<Cereales>();
        while (iter.hasNext()){
            copy.add(iter.next());
        }
        return  copy;
    }

}
