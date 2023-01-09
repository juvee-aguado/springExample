package com.pruebas.Pruebas.services;

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

}
