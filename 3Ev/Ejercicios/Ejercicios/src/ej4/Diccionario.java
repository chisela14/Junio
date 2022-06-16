package ej4;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Diccionario {
	
	private String nombre;
	private LinkedList<Palabra> palabras;
	
	public Diccionario(String nombre) {
		this.nombre = nombre;
		palabras = new LinkedList<>();
	}
	
	private Palabra conseguirPalabra(Palabra p) {
		Palabra salida = null;
		boolean encontrado = false;
		while(!encontrado) {
			for(Palabra p2: palabras) {
				if(p2.equals(p)) {
					salida = p2;
					encontrado = true;
				}
			}
		}
		return salida;
	}
	
	public void addPalabra(Palabra p) {
		if(palabras.contains(p)) {
			Palabra p2 = conseguirPalabra(p);
			Significado s2 = p.getSignificados().get(0);
			p2.significados.add(s2);
		}else {
			palabras.add(p);
		}
	}
	
	public String buscarPalabra(String nombre) throws DiccionarioException {
		Palabra salida = null;
		boolean encontrado = false;
		while(!encontrado) {
			for(Palabra p: palabras) {
				if(p.getNombre().equals(nombre)) {
					salida = p;
					encontrado = true;
				}
			}
			if(!encontrado) {
				throw new DiccionarioException("No se ha encontrado esa palabra en el diccionario");
			}
		}
		return salida.toString();
	}
	
	public void borrarPalabra(String nombre) throws DiccionarioException {
		Palabra borrar = null;
		for(Palabra p: palabras) {
			if(p.getNombre().equals(nombre)) {
				borrar = p;
			}
		}
		if(borrar!= null && palabras.contains(borrar)) {
			palabras.remove(borrar);
		}else {
			throw new DiccionarioException("La palabra a borrar no está recogida en el diccionario");
		}
	
	}
	
	public String palabrasEmpiezanPor(String cadena) throws DiccionarioException {
		Collections.sort(palabras);
		StringBuilder salida = new StringBuilder();
		for(Palabra p: palabras) {
			if(p.getNombre().startsWith(cadena)) {
				salida.append(p.toString()+ System.lineSeparator());
			}
		}
		if(salida.isEmpty()) {
			throw new DiccionarioException("No se han encontrado palabras que empiecen por dicha secuencia");
		}
		return salida.toString();
	}
	
	public String mostrarPalabras() {
		Collections.sort(palabras);
		Iterator<Palabra> itr = palabras.iterator();
		StringBuilder salida = new StringBuilder();
		while(itr.hasNext()) {
			salida.append(itr.next().toString() + System.lineSeparator());
		}
		return salida.toString();
	}

	@Override
	public String toString() {
		return "Diccionario: " + nombre + " Número de palabras: " + palabras.size();
	}
	
}
