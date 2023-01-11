package com.pruebas.Pruebas.services;

import com.pruebas.Pruebas.beans.RequestCereales;
import com.pruebas.Pruebas.dao.CerealesDAO;
import com.pruebas.Pruebas.entity.Cereales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CerealesService {

    @Autowired
    private CerealesDAO dao;

    public List<Cereales> obtenerTodosLosCereales(){
        return  dao.obtenerTodosLosCereales();
    }

    public Cereales insertarCereales(String nombre, double cantidad, String fecha, double precio) {
        return dao.insertarCereales(nombre, cantidad, fecha, precio);
    }
    public Cereales actualizaCereales (Long idCer, RequestCereales cerealesRequest){

        Cereales aCer = new Cereales();
        aCer.setId(idCer);
        aCer.setName(cerealesRequest.getNombre());
        aCer.setCantidad(cerealesRequest.getCantidad());
        aCer.setFecha(cerealesRequest.getFecha());
        aCer.setPrecio(cerealesRequest.getPrecio());

        Cereales cerealesBaseDatos = dao.getCerealesById(aCer.getId());
        if(cerealesBaseDatos==null){
            return null;
        }else{
            return dao.actualizaCereales(aCer);
        }
    }
}

