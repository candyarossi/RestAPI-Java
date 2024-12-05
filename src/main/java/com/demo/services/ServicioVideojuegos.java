package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.models.Videojuego;
import com.demo.repositories.RepositorioVideojuegos;

@Service
public class ServicioVideojuegos {

	@Autowired
	private RepositorioVideojuegos repositorioVideojuegos;

	public Page<Videojuego> obtenerTodosLosVideojuegos(int pagina, String orden) {
		PageRequest pageRequest = PageRequest.of(pagina, 6);
		if (orden != null) {
			Sort sort = null;
			if (orden.equals("ASC")) {
				sort = Sort.by(Sort.Direction.ASC, "nombre");
			} else if (orden.equals("DESC")) {
				sort = Sort.by(Sort.Direction.DESC, "nombre");
			}
			pageRequest = PageRequest.of(pagina, 6, sort);
		}
		return this.repositorioVideojuegos.findAll(pageRequest);
	}

	public Videojuego obtenerPorId(Long id) {
		return this.repositorioVideojuegos.findById(id).orElse(null);
	}

	public Videojuego crear(Videojuego videojuego) {
		return this.repositorioVideojuegos.save(videojuego);
	}

	public Videojuego actualizar(Videojuego videojuego) {
		return this.repositorioVideojuegos.save(videojuego);
	}

	public void eliminar(Long id) {
		this.repositorioVideojuegos.deleteById(id);
	}

	public Videojuego obtenerMiVideojuego(Long idUsuario) {
		return this.repositorioVideojuegos.obtenerMiVideojuego(idUsuario).orElse(null);
	}
}
