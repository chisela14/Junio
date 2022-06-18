package com.jacaranda.partituras;

public class Anonima extends Partitura {
	
	private String genero;

	public Anonima(String nombre, String genero) {
		super(nombre);
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "La partitura de " + super.getNombre() + " es música " + genero;
	}
}
