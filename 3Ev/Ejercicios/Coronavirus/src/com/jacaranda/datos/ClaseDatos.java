package com.jacaranda.datos;

import java.util.ArrayList;

public class ClaseDatos {
	private ArrayList<ClaseMetrica> metricas;

	public ClaseDatos(ArrayList<ClaseMetrica> metricas) {
		super();
		this.metricas = metricas;
	}
	
	public ClaseDatos() {
		super();
		this.metricas = new ArrayList<ClaseMetrica>();
	}
	
	public ArrayList<ClaseMetrica> getMetrica() {
		return metricas;
	}
	

}
