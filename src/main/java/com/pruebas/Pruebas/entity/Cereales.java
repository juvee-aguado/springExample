package com.pruebas.Pruebas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.hpsf.Decimal;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name= "CEREALES")
public class Cereales  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @Column(name = "NOMBRE")
    private String name;
    @Column (name = "CANTIDAD" )
    private Double cantidad;
    @Column (name = "FECHA")
    private String fecha;
    @Column (name = "PRECIO" )
    private Double precio;
}
