package com.pruebas.Pruebas.dao;

import com.pruebas.Pruebas.entity.Cereales;
import com.pruebas.Pruebas.repository.CerealesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    //creando el metodo de insertar nuevos cereales
    public Cereales insertarCereales(String nombre, double cantidad, String fecha, double precio) {
        Cereales c = new Cereales();
        c.setName(nombre);
        c.setCantidad(cantidad);
        c.setFecha(fecha);
        c.setPrecio(precio);
        repository.save(c);
        return repository.obtenerCerealesNombre(nombre);
    }
    public Cereales getCerealesById(Long id){
        Optional<Cereales> cerealesOptional = repository.findById(id);
        if(cerealesOptional.isPresent()){
            return  cerealesOptional.get();
        }else{
            return null;
        }
    }

    public Cereales actualizaCereales(Cereales c){
        repository.save(c);
        Optional<Cereales> cerealesOptional = repository.findById(c.getId());
        if(cerealesOptional.isPresent()){
            return cerealesOptional.get();
        }else{
            return null;
        }
    }
}
