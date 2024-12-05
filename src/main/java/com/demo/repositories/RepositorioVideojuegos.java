package com.demo.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Videojuego;

import jakarta.transaction.Transactional;

@Repository
public interface RepositorioVideojuegos extends CrudRepository<Videojuego, Long>, PagingAndSortingRepository<Videojuego, Long> {

	// Ejemplo SELECT
	// @Query(value = "SELECT v FROM Videojuego v WHERE v.id_usuario = ?1")
	@Query(value = "SELECT * FROM videojuegos WHERE id_usuario = ?1", nativeQuery = true)
	Optional<Videojuego> obtenerMiVideojuego(Long idUsuario);
}
