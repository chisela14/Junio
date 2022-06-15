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
	
	public String buscarPalabra(Palabra p) {
		return conseguirPalabra(p).toString();
	}
	
	public void borrarPalabra(Palabra p) {
		palabras.remove(p);
	}
	
	public String palabrasEmpiezanPor(String cadena) {
		Collections.sort(palabras);
		Iterator<Palabra> itr = palabras.iterator();
		StringBuilder salida = new StringBuilder();
		while(itr.hasNext()&&itr.next().getNombre().startsWith(cadena)) {
			salida.append(itr.next().toString());
		}
		return salida.toString();
	}
	
	public String mostrarPalabras() {
		Iterator<Palabra> itr = palabras.iterator();
		StringBuilder salida = new StringBuilder();
		while(itr.hasNext()) {
			salida.append(itr.next().toString());
		}
		return salida.toString();
	}

	@Override
	public String toString() {
		return "Diccionario: " + nombre + " Número de palabras: " + palabras.size();
	}
	
}
