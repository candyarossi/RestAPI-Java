package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Genero;
import com.demo.repositories.RepositorioGeneros;

@Service
public class ServicioGeneros {
	@Autowired
	private RepositorioGeneros repositorioGeneros;

	public List<Genero> obtenerTodos() {
		return (List<Genero>) this.repositorioGeneros.findAll();
	}
}
