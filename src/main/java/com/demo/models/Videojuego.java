package com.demo.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.URL;

import com.demo.interfaces.ManejoDeFechas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "videojuegos")
public class Videojuego implements ManejoDeFechas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Este campo es obligatorio.")
	@Size(min = 5, max = 40, message = "Debe contener entre 5 y 40 caracteres.")
	private String nombre;

	@Size(max = 400, message = "Debe contener menos de 400 caracteres.")
	private String descripcion;

	@URL(message = "Debe ser una URL válida.")
	private String portada;

	@NotNull(message = "Este campo es obligatorio.")
	private LocalDate fecha_lanzamiento;

	@Max(value = 5, message = "El valor debe ser menor a 5.")
	@Min(value = 1, message = "El valor debe ser mayor a 1.")
	private double rating;

	@NotNull(message = "Este campo es obligatorio.")
	@ManyToMany
	@JoinTable(name = "videojuegos_generos", joinColumns = @JoinColumn(name = "id_videojuego"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
	private List<Genero> generos;

	@NotNull(message = "Este campo es obligatorio.")
	@ManyToMany
	@JoinTable(name = "videojuegos_plataformas", joinColumns = @JoinColumn(name = "id_videojuego"), inverseJoinColumns = @JoinColumn(name = "id_plataforma"))
	private List<Plataforma> plataformas;

	public Videojuego() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.descripcion = "";
		this.portada = "";
		this.fecha_lanzamiento = LocalDate.now();
		this.rating = 0;
		this.generos = new ArrayList<>();
		this.plataformas = new ArrayList<>();

	}

	public Videojuego(Long id, String nombre, String descripcion, String portada, String fecha_lanzamiento,
			double rating, ArrayList<Genero> generos, ArrayList<Plataforma> plataformas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.portada = portada;
		this.fecha_lanzamiento = formatearFecha(fecha_lanzamiento);
		this.rating = rating;
		this.generos = generos;
		this.plataformas = plataformas;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public LocalDate getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(LocalDate fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Plataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(List<Plataforma> plataformas) {
		this.plataformas = plataformas;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", portada=" + portada
				+ ", fecha_lanzamiento=" + fecha_lanzamiento + ", rating=" + rating + ", generos=" + generos
				+ ", plataformas=" + plataformas + "]";
	}

}
