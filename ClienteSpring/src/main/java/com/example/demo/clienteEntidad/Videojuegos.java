package com.example.demo.clienteEntidad;

import org.springframework.stereotype.Component;

@Component
public class Videojuegos {
	private int id;
	private String nombre,compania;
	private double nota;
	
	public Videojuegos() {
		
	}
	public Videojuegos(int id, String nombre, String compania, double nota) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compania = compania;
		this.nota = nota;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCompania() {
		return compania;
	}
	public void setCompania(String compania) {
		this.compania = compania;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Videojuegos [id=" + id + ", nombre=" + nombre + ", compania=" + compania + ", nota=" + nota + "]";
	}
	
}
