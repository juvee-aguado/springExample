package com.pruebas.Pruebas.repository;

import com.pruebas.Pruebas.beans.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "Select * FROM USUARIOS WHERE AGE > ?1", nativeQuery = true)
    Usuario obtenerUsuarioNombre(
            String nombre
    );

}
