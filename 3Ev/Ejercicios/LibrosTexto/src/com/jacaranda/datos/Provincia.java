package com.jacaranda.datos;

import java.util.HashSet;
import java.util.Objects;

public class Provincia {
	
	private String nombre;
	private HashSet<Localidad> localidades;
	
	public Provincia(String nombre) {
		this.nombre = nombre;
		this.localidades = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Localidad> getLocalidades() {
		return localidades;
	}
	public void addLocalidad(Localidad l) {
		this.localidades.add(l);
	}

	public void setLocalidades(HashSet<Localidad> localidades) {
		this.localidades = localidades;
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
		Provincia other = (Provincia) obj;
		return Objects.equals(nombre, other.nombre);
	}

	

}
