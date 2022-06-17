package ej4;

import java.util.ArrayList;
import java.util.Objects;

public class Palabra implements Comparable<Palabra>{
	
	private String nombre;
	private ArrayList<String> significados;
	
	public Palabra(String nombre, String significado) {
		this.nombre = nombre;
		significados = new ArrayList<>();
		significados.add(significado);
	}

	public String getNombre() {
		return nombre;
	}

	// Devuelve un String con significados (una palabra siempre tendrá como mínimo uno)
	public String getSignificados() {
		StringBuilder resultado = new StringBuilder();
		for (String aux: significados) {
			resultado.append(aux + System.lineSeparator());
		}
		return resultado.toString();
	}
	//ad significado
	public void addSignificado(String str) throws PalabraException {
		if(significados.contains(str)) {
			throw new PalabraException("El significado ya está guardado");
		}else {
			significados.add(str);
		}
	}
	public void delSignificado(String str) throws PalabraException {
		if(!significados.contains(str)) {
			throw new PalabraException("No se puede borrar porque no está guardado");
		}else {
			significados.remove(str);
		}
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
		return "Palabra: " + nombre + " Significados: " + getSignificados();
	}

	@Override
	public int compareTo(Palabra o) {
		return this.nombre.compareTo(o.getNombre());
	}
	
	
}
