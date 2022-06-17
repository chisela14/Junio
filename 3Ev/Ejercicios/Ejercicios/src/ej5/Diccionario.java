package ej5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

import ej4.Palabra;
import ej4.DiccionarioException;

public class Diccionario {
	private String nombre;
	private HashMap<String,  ArrayList<String> > palabras;
	
	public Diccionario(String nombre) {
		this.nombre = nombre;
		palabras = new HashMap<>();
	}
	
	private Palabra conseguirPalabra(String p) {
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
	
	public void addPalabra(String p, String s) {
		ArrayList<String> significados = palabras.get(p);
		if (p == null) {
			// No existe lo tengo que añadir
			significados = new ArrayList<String>();
			significados.add(s);
			palabras.put(p, significados);
		}else {
			//Comprobar que no esté el significado y si no lanzar exception
			significados.add(s);
		}
		
		
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
