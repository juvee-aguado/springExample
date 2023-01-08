package com.pruebas.Pruebas.repository;

import com.pruebas.Pruebas.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "Select * FROM USUARIOSDB WHERE NOMBRE = ?1", nativeQuery = true)
    Usuario obtenerUsuarioNombre(
            String nombre
    );

}
