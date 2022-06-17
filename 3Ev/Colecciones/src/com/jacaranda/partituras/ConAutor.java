package com.jacaranda.partituras;

public class ConAutor extends Partitura {
	
	private String autor;

	public ConAutor(String nombre, String autor) {
		super(nombre);
		this.autor = autor;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "La partitura de " + super.getNombre() + " es de " + autor;
	}

}
