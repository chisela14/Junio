package ej4;

import java.util.HashSet;
import java.util.Iterator;

import ej1.Alumno;

public class Diccionario {
	
	private String nombre;
	private HashSet<Palabra> palabras;
	
	public Diccionario(String nombre) {
		this.nombre = nombre;
		palabras = new HashSet<>();
	}
	
	private Palabra conseguirPalabra(Palabra p) {
		Palabra salida = null;
		boolean encontrado = false;
		while(encontrado==false) {
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
		boolean salida = false;
		if(palabras.contains(p)) {
			Palabra p2 = conseguirPalabra(p);
			Significado s2 = p.getSignificados().get(0);
			p2.significados.add(s2);
			/*
			//bucle para encontrar la palabra y añadirle el nuevo significado
			while(salida==false) {
				for(Palabra p2: palabras) {
					if(p2.equals(p)) {
						Significado s2 = p.getSignificados().get(0);
						p2.significados.add(s2);
						//pasar significado s por parametro
						//p2.significados.add(s);
						salida = true;
					}
				}
			}*/
		}else {
			palabras.add(p);
		}
	}
}
