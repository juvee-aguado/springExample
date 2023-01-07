package com.pruebas.Pruebas.beans;


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
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(sequenceName = "task_id_seq", allocationSize = 1, name = "task_id_seq")
    Long id;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "APELLIDO")
    private String lastName;
    @Column(name = "EDAD")
    private String age;

}
