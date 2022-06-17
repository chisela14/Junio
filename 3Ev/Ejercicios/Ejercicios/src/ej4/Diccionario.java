package ej4;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Diccionario {

	private String nombre;
	private LinkedList<Palabra> palabras;

	public Diccionario(String nombre) {
		this.nombre = nombre;
		palabras = new LinkedList<>();
	}

	public void addPalabra(String palabra, String significado) throws PalabraException {
		//palabra aux con los datos que me pasan
		Palabra p = new Palabra(palabra, significado);
		if (palabras.contains(p)) {
			int indice = palabras.indexOf(p);
			palabras.get(indice).addSignificado(significado);
		} else {
			palabras.add(p);
		}
	}

	//devuelve la palabra buscada con todos los significados
	public String buscarPalabra(String nombre) throws DiccionarioException {
		Palabra p = new Palabra(nombre,"");
		String resultado;
		
		if(palabras.contains(p)) {
			int indice = palabras.indexOf(p);
			resultado = palabras.get(indice).toString();
		}else {
			throw new DiccionarioException("No se ha encontrado esa palabra en el diccionario");
		}
		return resultado;

	}

	public void borrarPalabra(String nombre) throws DiccionarioException {
		Palabra borrar = new Palabra(nombre,"");
		if(palabras.contains(borrar)) {
			int indice = palabras.indexOf(borrar);
			palabras.remove(indice);
		}else {
			throw new DiccionarioException("La palabra a borrar no está recogida en el diccionario");
		}
	}

	public String palabrasEmpiezanPor(String cadena) throws DiccionarioException {
		Collections.sort(palabras);
		StringBuilder salida = new StringBuilder();
		for (Palabra p : palabras) {
			if (p.getNombre().startsWith(cadena)) {
				salida.append(p.toString() + System.lineSeparator());
			}
		}
		if (salida.isEmpty()) {
			throw new DiccionarioException("No se han encontrado palabras que empiecen por dicha secuencia");
		}
		return salida.toString();
	}

	public String mostrarPalabras() {
		Collections.sort(palabras);
		Iterator<Palabra> itr = palabras.iterator();
		StringBuilder salida = new StringBuilder();
		while (itr.hasNext()) {
			salida.append(itr.next().toString() + System.lineSeparator());
		}
		return salida.toString();
	}

	@Override
	public String toString() {
		return "Diccionario: " + nombre + " Número de palabras: " + palabras.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, palabras);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diccionario other = (Diccionario) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(palabras, other.palabras);
	}
	

}
