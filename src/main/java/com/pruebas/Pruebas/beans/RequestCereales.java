package com.pruebas.Pruebas.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCereales implements Serializable {
    private String nombre;
    private double cantidad;
    private String fecha;
    private double precio;
}
