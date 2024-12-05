package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "plataformas")
public class Plataforma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nombre;

	@ManyToMany
	@JoinTable(name = "videojuegos_plataformas", joinColumns = @JoinColumn(name = "id_plataforma"), inverseJoinColumns = @JoinColumn(name = "id_videojuego"))
	@Transient
	private List<Videojuego> videojuegos;

	public Plataforma() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.videojuegos = new ArrayList<>();
	}

	public Plataforma(Long id, String nombre, List<Videojuego> videojuegos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.videojuegos = videojuegos;
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

	public List<Videojuego> getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(List<Videojuego> videojuegos) {
		this.videojuegos = videojuegos;
	}

	@Override
	public String toString() {
		return "Plataforma [id=" + id + ", nombre=" + nombre + ", videojuegos=" + videojuegos + "]";
	}
}
