package ej5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

import ej4.DiccionarioException;

public class Diccionario {
	private String nombre;
	private HashMap<String, ArrayList<String> > palabras;
	
	public Diccionario(String nombre) {
		this.nombre = nombre;
		palabras = new HashMap<>();
	}
	
	public void addPalabra(String palabra, String significado) {
		boolean encontrado = false;
		Iterator<String> it = palabras.keySet().iterator();
		while(it.hasNext() && !encontrado) {
			String aux = it.next();
			if(aux.equals(palabra)) {
				ArrayList<String> valores = palabras.get(aux);
				valores.add(significado);
				encontrado = true;
			}
		}	
		if(!encontrado) {
								//se hace asi?
			ArrayList<String> aux = new ArrayList<>();
			palabras.put(palabra, aux);
			ArrayList<String> valores = palabras.get(palabra);
			valores.add(significado);
		}
	}

	//devuelve la palabra buscada con todos los significados
	public String buscarPalabra(String nombre) throws DiccionarioException {
		StringBuilder salida  = new StringBuilder();
		boolean encontrado = false;
		Iterator<String> it = palabras.keySet().iterator();
		while(it.hasNext() && !encontrado) {
			String aux = it.next();
			if(aux.equals(nombre)) {
				salida.append(aux);
				ArrayList<String> valores = palabras.get(aux);
				for(String s: valores) {
					salida.append(s);
				}
				encontrado = true;
			}
		}
		if(!encontrado) {
			throw new DiccionarioException("No se ha encontrado esa palabra en el diccionario");
		}
		return salida.toString();

	}

	public void borrarPalabra(String nombre) throws DiccionarioException {
		if(palabras.containsKey(nombre)) {
			palabras.remove(nombre);
		}else {
			throw new DiccionarioException("La palabra a borrar no está recogida en el diccionario");
		}
	}
	
	//mostrar las palabras encontradas ordenadas alfabeticamente
	public String palabrasEmpiezanPor(String cadena) throws DiccionarioException {
		Set<String>  clavesSet = palabras.keySet();
		List<String>  clavesLista = new ArrayList<>(clavesSet);
		//el compareto de String entiendo que es alfabetico
		Collections.sort(clavesLista);
		StringBuilder salida = new StringBuilder();
		Iterator<String> itr = clavesLista.iterator();
		while (itr.hasNext()) {
			String clave = itr.next();
			if(clave.startsWith(cadena)) {
				salida.append("Palabra: " + clave + " Significados: ");
				ArrayList<String> valores = palabras.get(clave);
				for(String s2: valores) {
					salida.append(s2+ " ");
				}
				salida.append(System.lineSeparator());
			}
		}
		if (salida.isEmpty()) {
			throw new DiccionarioException("No se han encontrado palabras que empiecen por dicha secuencia");
		}
		return salida.toString();
	}

	public String mostrarPalabras() {
		Set<String> clavesSet = palabras.keySet();
		List<String> clavesLista = new ArrayList<>(clavesSet);
		Collections.sort(clavesLista);
		Iterator<String> itr = clavesLista.iterator();
		StringBuilder salida = new StringBuilder();
		while (itr.hasNext()) {
			String clave = itr.next();
			salida.append("Palabra: " + clave + " Significados: ");
			ArrayList<String> valores = palabras.get(clave);
			for(String s: valores) {
				salida.append(s + " ");
			}
			salida.append(System.lineSeparator());
		}
		return salida.toString();
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

	@Override
	public String toString() {
		return "Diccionario [nombre=" + nombre + ", palabras=" + palabras.keySet().size() + "]";
	}
	
	
}
