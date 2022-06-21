package com.jacaranda.datos;

import java.util.HashSet;
import java.util.Objects;

public class Curso {
	
	private String nombre;
	private HashSet<Materia> materias;
	
	public Curso(String nombre) {
		this.nombre = nombre;
		this.materias = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}
	public void addMateria(Materia m) {
		this.materias.add(m);
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
		Curso other = (Curso) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
