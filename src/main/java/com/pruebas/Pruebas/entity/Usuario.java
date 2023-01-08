package com.pruebas.Pruebas.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USUARIOSDB")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "APELLIDO")
    private String lastName;
    @Column(name = "EDAD")
    private String age;

}
