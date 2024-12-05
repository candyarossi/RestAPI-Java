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

	// Ejemplo INSERT (sin insertar géneros y plataformas)
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO videojuegos (nombre, descripcion, portada, fecha_lanzamiento, rating, id_usuario) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
	Videojuego guardarVideojuego(String nombre, String descripcion, String portada, LocalDate fecha_lanzamiento,
			double rating, Long id_usuario);

	// Ejemplo UPDATE (sin actualizar géneros y plataformas)
	@Transactional
	@Modifying
	@Query(value = "UPDATE videojuegos SET nombre = ?2, descripcion = ?3, portada = ?4, fecha_lanzamiento = ?5, rating = ?6, id_usuario = ?7 WHERE id = ?1", nativeQuery = true)
	Videojuego actualizarVideojuego(Long id, String nombre, String descripcion, String portada,
			LocalDate fecha_lanzamiento, double rating, Long id_usuario);

	// Ejemplo DELETE
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM videojuegos WHERE id = ?1", nativeQuery = true)
	void eliminarVideojuego(Long idVideojuego);

	// Ejemplo JOIN (este ejemplo devolverá un videojuego combinado con un usuario)
	// El resultado debería ser mapeado
	@Query(value = "SELECT * FROM videojuegos v JOIN usuarios u ON v.id_usuario = u.id WHERE u.id = ?1", nativeQuery = true)
	Object[] obtenerVideojuegoConUsuario(Long idUsuario);
}
