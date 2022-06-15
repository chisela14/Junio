package ej4;

import java.util.ArrayList;
import java.util.Objects;

public class Palabra {
	
	private String nombre;
	ArrayList<Significado> significados;
	
	public Palabra(String nombre, Significado significado) {
		this.nombre = nombre;
		significados = new ArrayList<>();
		significados.add(significado);
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Significado> getSignificados() {
		return significados;
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
		Palabra other = (Palabra) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Palabra [nombre=" + nombre + ", significados=" + significados + "]";
	}
	
	
}
