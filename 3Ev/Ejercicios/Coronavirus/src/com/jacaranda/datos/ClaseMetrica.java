package com.jacaranda.datos;

import java.util.ArrayList;

public class ClaseMetrica {
	
	private ArrayList<Datos> datos = new ArrayList<>();

	public ClaseMetrica() {
		this.datos = new ArrayList<Datos>();
	}
	
	public ClaseMetrica(ArrayList<Datos> datos) {
		super();
		this.datos = datos;
	}

	public ArrayList<Datos> getDatos() {
		return datos;
	}
	
}
