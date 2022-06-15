package com.jacaranda.energia;

import java.util.LinkedList;

public class Empresa {
	private String nombre;
	private LinkedList<Generador> generadores;
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		generadores = new LinkedList<>();
	}
	
}
