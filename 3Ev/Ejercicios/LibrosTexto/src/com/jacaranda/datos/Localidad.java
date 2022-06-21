package com.jacaranda.datos;

import java.util.HashSet;
import java.util.Objects;

public class Localidad {
	
	private String nombre;
	private HashSet<Centro> centros;
	
	public Localidad(String nombre) {
		this.nombre = nombre;
		this.centros = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Centro> getCentros() {
		return centros;
	}

	public void setCentros(HashSet<Centro> centros) {
		this.centros = centros;
	}
	public void addCentro(Centro c) {
		this.centros.add(c);
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
		Localidad other = (Localidad) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
}
