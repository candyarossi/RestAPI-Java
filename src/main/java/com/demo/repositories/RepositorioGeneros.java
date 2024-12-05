package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Genero;

@Repository
public interface RepositorioGeneros extends CrudRepository<Genero, Long> {

}
