package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Plataforma;
import com.demo.repositories.RepositorioPlataformas;

@Service
public class ServicioPlataformas {

	@Autowired
	private RepositorioPlataformas repositorioPlataformas;

	public List<Plataforma> obtenerTodas() {
		return (List<Plataforma>) this.repositorioPlataformas.findAll();
	}
}
