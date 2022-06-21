package com.jacaranda.datos;

import java.util.Objects;

public class Materia {
	
	private String nombre;
	private Libro libro;
	
	public Materia(String nombre, Libro libro) {
		this.nombre = nombre;
		this.libro = libro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	

}
