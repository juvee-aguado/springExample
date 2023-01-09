package com.pruebas.Pruebas.repository;

import com.pruebas.Pruebas.entity.Cereales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CerealesRepository extends CrudRepository<Cereales, Long> {
}
