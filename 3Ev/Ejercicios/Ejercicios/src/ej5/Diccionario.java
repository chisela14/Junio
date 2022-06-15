package ej5;

import java.util.HashMap;
import java.util.ArrayList;

import ej4.Palabra;

public class Diccionario {
	private String nombre;
	private HashMap<Letras, ArrayList<Palabra>> palabras;
	
	public Diccionario(String nombre) {
		this.nombre = nombre;
		palabras = new HashMap<>();
	}
}
